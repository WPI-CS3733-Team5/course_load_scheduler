package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleAction;
import org.dselent.course_load_scheduler.client.action.SendHomeFilterAction;
import org.dselent.course_load_scheduler.client.action.SendRequestDifferentScheduleAction;
import org.dselent.course_load_scheduler.client.event.ReceiveHomeEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendAcceptScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeFilterEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestDifferentScheduleEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.ActiveUser;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.ScheduleLinks;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.HomePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.utils.Pair;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.HomeView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.inject.Inject;

public class HomePresenterImpl extends BasePresenterImpl implements HomePresenter {
	
	private IndexPresenter parentPresenter;
	private HomeView view;
	private boolean acceptScheduleInProgress;
	private boolean requestDifferentScheduleInProgress;
	private boolean applyFilterInProgress;
	private ArrayList<UserInfo> userInfoList;
	private ArrayList<InstructorInfo> instructorInfoList;
	private ArrayList<ScheduleLinks> scheduleLinksList;
	private ArrayList<CourseInfo> courseInfoList;
	private ArrayList<SectionInfo> sectionInfoList;
	private ArrayList<LabInfo> labInfoList;
	private ArrayList<CalendarInfo> calendarInfoList;

	@Inject
	public HomePresenterImpl(IndexPresenter parentPresenter, HomeView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setParent(this);
		acceptScheduleInProgress = false;
		requestDifferentScheduleInProgress = false;
		applyFilterInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public void bind()
	{
		HandlerRegistration acceptRegistration;
		acceptRegistration = eventBus.addHandler(SendAcceptScheduleEvent.TYPE, this);
		eventBusRegistration.put(SendAcceptScheduleEvent.TYPE, acceptRegistration);
		
		HandlerRegistration requestRegistration;
		requestRegistration = eventBus.addHandler(SendRequestDifferentScheduleEvent.TYPE,  this);
		eventBusRegistration.put(SendRequestDifferentScheduleEvent.TYPE, requestRegistration);
		
		HandlerRegistration applyRegistration;
		applyRegistration = eventBus.addHandler(SendHomeFilterEvent.TYPE,  this);
		eventBusRegistration.put(SendHomeFilterEvent.TYPE, applyRegistration);
	}
	
	@Override
	public void go(HasWidgets container) {
		if(parentPresenter.getActiveUser().getUserRole() == 1) {
			view.getUserDropDown().clear();
			view.getUserDropDown().addItem(parentPresenter.getActiveUser().getUserName());
		} else
		{
			view.getUserDropDown().clear();
			for(UserInfo i: userInfoList) {
				view.getUserDropDown().addItem(i.getUserName());
			}
		}
		
		view.getTermDropDown().addItem("A");
		view.getTermDropDown().addItem("B");
		view.getTermDropDown().addItem("C");
		view.getTermDropDown().addItem("D");
		view.getTermDropDown().addItem("E1");
		view.getTermDropDown().addItem("E2");
		
		parentPresenter.showMenuTabs();
		container.clear();
		container.add(view.getWidgetContainer());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BaseView<? extends BasePresenter> getView() {
		return (BaseView<? extends BasePresenter>) this.view;
	}
	
	@Override
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}
	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
	}
	@Override
	public void applyFilter(ListBox termBox, ListBox userBox) {
		if(!applyFilterInProgress)
		{
			applyFilterInProgress = true;
			view.getApply().setEnabled(false);
			
			String term = termBox.getItemText(termBox.getSelectedIndex());
			String username = userBox.getItemText(userBox.getSelectedIndex());
			view.getCalendarList().clear();
			applyFilter(term, username);
		}
	}
	
	private boolean applyFilter(String termString, String username)
	{
		parentPresenter.showLoadScreen();
		
		int term = termToInt(termString);
		UserInfo user = new UserInfo();
		InstructorInfo instructor = new InstructorInfo();
		instructor.setId(0);
				
		ArrayList<SectionInfo> sections = new ArrayList<>();
		ArrayList<LabInfo> labs = new ArrayList<>();
		
		ArrayList<Pair<Pair<CourseInfo, SectionInfo>, CalendarInfo>> coursesAndSectionsAndCalendars = new ArrayList<>();
		ArrayList<Pair<Pair<CourseInfo, LabInfo>, CalendarInfo>> coursesAndLabsAndCalendars = new ArrayList<>();
		
		for(int i = 0; i < userInfoList.size(); i++) {
			if(userInfoList.get(i).getUserName().equals(username)) {
				user = userInfoList.get(i);
				break;
			}
		}
		
		for(int i = 0; i < instructorInfoList.size(); i++) {
			if(instructorInfoList.get(i).getUserInfoId() == user.getId()) {
				instructor = instructorInfoList.get(i);
				break;
			}
		}
		
		if(instructor.getId() == 0) {
			view.getCalendarList().addItem("The selected user has no schedule");
			return false;
		}
		
		for(int i = 0; i < scheduleLinksList.size(); i++) {
			if(scheduleLinksList.get(i).getInstructorInfoId() == instructor.getId()) {
				for(int b = 0; b < sectionInfoList.size(); b++) {
					if(scheduleLinksList.get(i).getSectionInfoId() == sectionInfoList.get(b).getId()) {
						sections.add(sectionInfoList.get(b));
						break;
					}
				}
			}
			break;
		}
		
		for(int i = 0; i < labInfoList.size(); i++) {
			if(labInfoList.get(i).getInstructorInfoId() == instructor.getId()) {
				labs.add(labInfoList.get(i));
			}
		}
		
		
		for(int i = 0; i < sections.size(); i++) {
			for(int b = 0; b < courseInfoList.size(); b++) {
				if(courseInfoList.get(b).getId() == sections.get(i).getCourseInfoId()) {
					for(int c = 0; c < calendarInfoList.size(); c++) {
						if(calendarInfoList.get(c).getId() == sections.get(i).getCalendarInfoId() && calendarInfoList.get(c).getTerm() == term) {
							Pair<CourseInfo, SectionInfo> tempPair1 = new Pair(courseInfoList.get(b), sections.get(i));
							Pair<Pair<CourseInfo, SectionInfo>, CalendarInfo> temp2 = new Pair(tempPair1, calendarInfoList.get(c));
							coursesAndSectionsAndCalendars.add(temp2);
							break;
						}
					}
					break;
				}
			}
		}
		
		for(int i = 0; i < sections.size(); i++) {
			for(int b = 0; b < labs.size(); b ++) {
				if(labs.get(b).getSectionInfoId() == sections.get(i).getId()) {
					for(int c = 0; c < courseInfoList.size(); c++) {
						if(courseInfoList.get(c).getId() == sections.get(i).getCourseInfoId()) {
							for(int d = 0; d < calendarInfoList.size(); d++) {
								if(calendarInfoList.get(d).getId() == labs.get(b).getCalendarInfoId() && calendarInfoList.get(d).getTerm() == term) {
									Pair<CourseInfo, LabInfo> temp1 = new Pair(courseInfoList.get(c), labs.get(b));
									Pair<Pair<CourseInfo, LabInfo>, CalendarInfo> temp2= new Pair(temp1, calendarInfoList.get(d));
									coursesAndLabsAndCalendars.add(temp2);
									break;
								}
							}
							break;
						}
					}
					break;
				}
			}
		}
		
		for(int i = 0; i < coursesAndSectionsAndCalendars.size(); i++) {
			view.getCalendarList().addItem(coursesAndSectionsAndCalendars.get(i).getValue1().getValue1().getCourseName() + 
					" Section Number: " + 
					termToString(coursesAndSectionsAndCalendars.get(i).getValue2().getTerm()) + 
					coursesAndSectionsAndCalendars.get(i).getValue1().getValue2().getSectionNumber() + 
					coursesAndSectionsAndCalendars.get(i).getValue2().getYear() + 
					" Schedule: " +
					coursesAndSectionsAndCalendars.get(i).getValue2().getDays() +
					" " +
					coursesAndSectionsAndCalendars.get(i).getValue2().getStartTime() +
					" - " +
					coursesAndSectionsAndCalendars.get(i).getValue2().getEndTime());
		}
		for(int i = 0; i < coursesAndLabsAndCalendars.size(); i++) {
			view.getCalendarList().addItem(coursesAndLabsAndCalendars.get(i).getValue1().getValue1().getCourseName() +
					" Lab: " +
					termToString(coursesAndLabsAndCalendars.get(i).getValue2().getTerm()) +
					coursesAndLabsAndCalendars.get(i).getValue2().getYear() + 
					"X Schedule:" +
					coursesAndLabsAndCalendars.get(i).getValue2().getDays() + 
					" " +
					coursesAndLabsAndCalendars.get(i).getValue2().getStartTime() + 
					" - " +
					coursesAndLabsAndCalendars.get(i).getValue2().getEndTime());
		}
		
		parentPresenter.hideLoadScreen();
		applyFilterInProgress = false;
		view.getApply().setEnabled(true);
		
		return true;
	}
	
	private int termToInt(String termString) {
		
		int term = 0;
		
		if(termString.equals("A")) term = 1;
		if(termString.equals("B")) term = 2;
		if(termString.equals("C")) term = 3;
		if(termString.equals("D")) term = 4;
		if(termString.equals("E1")) term = 5;
		if(termString.equals("E2")) term = 6;
		
		return term;
	}
	
	private String termToString (Integer termInt) {
		String term = "ERROR";

		switch(termInt) {
		case 1:
			term = "A";
			break;
		case 2:
			term = "B";
			break;
		case 3:
			term = "C";
			break;
		case 4: 
			term = "D";
			break;
		case 5:
			term = "E1";
			break;
		case 6:
			term = "E2";
			break;
		}
		
		return term;
	}
	
	@Override
	public void acceptSchedule(ListBox termBox, ListBox userBox) {
		if(!acceptScheduleInProgress)
		{
			acceptScheduleInProgress = true;
			view.getAcceptSchedule().setEnabled(false);
			
			String term = termBox.getItemText(termBox.getSelectedIndex());
			String username = userBox.getItemText(userBox.getSelectedIndex());
			
			sendAcceptSchedule(term, username);
		}
	}
	
	private void sendAcceptSchedule(String term, String username) {
		SendAcceptScheduleAction sasa = new SendAcceptScheduleAction(term, username);
		SendAcceptScheduleEvent sase = new SendAcceptScheduleEvent(sasa);
		eventBus.fireEvent(sase);
	}
	
	//TODO move to NotificationsPresenterImpl
	@Override
	public void onSendAcceptSchedule(SendAcceptScheduleEvent evt) {
		String term = evt.getAction().getTerm();
		String username = evt.getAction().getUserName();
		
		//TODO create notification for admin saying that username accepted their schedule for term
	}
	
	@Override
	public void requestDifferentSchedule(ListBox termBox, ListBox userBox) {
		if(!requestDifferentScheduleInProgress)
		{
			requestDifferentScheduleInProgress = true;
			view.getRequestDifferentSchedule().setEnabled(false);
			
			String term = termBox.getItemText(termBox.getSelectedIndex());
			String username = userBox.getItemText(userBox.getSelectedIndex());
			
			sendRequestDifferentSchedule(term, username);
		}
	}
	
	private void sendRequestDifferentSchedule(String term, String username) {
		SendRequestDifferentScheduleAction srdsa = new SendRequestDifferentScheduleAction(term, username, view.getViewRootPanel());
		SendRequestDifferentScheduleEvent srdse = new SendRequestDifferentScheduleEvent(srdsa);
		eventBus.fireEvent(srdse);
	}
	
	@Override
	public void onReceiveHome(ReceiveHomeEvent evt)
	{
		HasWidgets container = evt.getContainer();
		ReceiveHomeAction rha = evt.getAction();
		instructorInfoList = rha.getInstructors();
		userInfoList = rha.getUsers();
		courseInfoList = rha.getCourses();
		sectionInfoList = rha.getSections();
		labInfoList = rha.getLabs();
		calendarInfoList = rha.getCalendars();
		scheduleLinksList = rha.getSchedules();
		
		go(container);
		Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
	}
}
