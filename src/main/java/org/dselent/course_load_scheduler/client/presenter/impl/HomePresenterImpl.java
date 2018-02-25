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
		//gets the active user off parentPresenter and checks if his role is admin or not
		//if the user is a regular user then clear the dropdown and add only this user to the list
		if(parentPresenter.getActiveUser().getUserRole() == 1) {
			view.getUserDropDown().clear();
			view.getUserDropDown().addItem(parentPresenter.getActiveUser().getUserName());
		} else
		//if the user isnt the regular user then fill the dropdown menu with all the users in userInfoList
		{
			view.getUserDropDown().clear();
			for(UserInfo i: userInfoList) {
				view.getUserDropDown().addItem(i.getUserName());
			}
		}
		
		//puts the A, B, C ect, terms in the drop down menu
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
	
	//apply filter when the termBox and userBox are filled in.
	// show the load screen while stuff is happening
	@Override
	public void applyFilter(ListBox termBox, ListBox userBox) {
		if(!applyFilterInProgress)
		{
			applyFilterInProgress = true;
			view.getApply().setEnabled(false);
			
			String term = termBox.getItemText(termBox.getSelectedIndex());
			String username = userBox.getItemText(userBox.getSelectedIndex());
			view.getCalendarList().clear();
			goFilter(term, username);
		}
	}
	
	private boolean goFilter(String termString, String username)
	{
		parentPresenter.showLoadScreen();
		
		//make termString an int and set term = to it.
		int term = termToInt(termString);
		
		//create a new user and instructor, then set instructors Id to 0
		UserInfo user = new UserInfo();
		InstructorInfo instructor = new InstructorInfo();
		instructor.setId(0);
				
		ArrayList<SectionInfo> sections = new ArrayList<>();
		ArrayList<LabInfo> labs = new ArrayList<>();
		
		//makes two lists that associate the given info with eachother. 
		ArrayList<Pair<Pair<CourseInfo, SectionInfo>, CalendarInfo>> coursesAndSectionsAndCalendars = new ArrayList<>();
		ArrayList<Pair<Pair<CourseInfo, LabInfo>, CalendarInfo>> coursesAndLabsAndCalendars = new ArrayList<>();
		
		//runs until it hits the end of the userInfoList(see above). checks if a user in the userInfoList shares a 
		//userName with the username parameter. If it finds on it sets the user variable from above the the found user.
		for(int i = 0; i < userInfoList.size(); i++) {
			if(userInfoList.get(i).getUserName().equals(username)) {
				user = userInfoList.get(i);
				break;
			}
		}
		
		//same thing as the username loop above but for the instructor variable. 
		for(int i = 0; i < instructorInfoList.size(); i++) {
			if(instructorInfoList.get(i).getUserInfoId() == user.getId()) {
				instructor = instructorInfoList.get(i);
				break;
			}
		}
		
		//if the instructor variables Id = 0 then add that string to the views calendarList and return false. 
		if(instructor.getId() == 0) {
			view.getCalendarList().addItem("The selected user has no schedule");
			return false;
		}
		
		//iterate over the scheduleLinksList
		for(int i = 0; i < scheduleLinksList.size(); i++) {
			//if the ith element in in scheduleLinksList has a instructorInfoId = to the instructor 
			//variable from above then continue
			//the loop. else break from the loop.
			if(scheduleLinksList.get(i).getInstructorInfoId() == instructor.getId()) {
				//iterate over the sectionInfo list. 
				for(int b = 0; b < sectionInfoList.size(); b++) {
					//if the ith element of scheduleLinksList' id is the same as the bth element of sectionInfoList
					//then add the bth element of sectionInfoList to the sections list. then break from the loop.
					if(scheduleLinksList.get(i).getSectionInfoId() == sectionInfoList.get(b).getId()) {
						sections.add(sectionInfoList.get(b));
						break;
					}
				}
			}
			break;
		}
		
		//iterate over the labInfoList.
		for(int i = 0; i < labInfoList.size(); i++) {
			//if the ith element in labInfoList has the same Id as instructor, then add that ith lab to the labs list. 
			if(labInfoList.get(i).getInstructorInfoId() == instructor.getId()) {
				labs.add(labInfoList.get(i));
			}
		}
		
		//iterate over the section list.
		for(int i = 0; i < sections.size(); i++) {
			//iterate over the courseInfList.
			for(int b = 0; b < courseInfoList.size(); b++) {
				//if the bth element of courseInfoList has the same id as the ith element of sections,
				if(courseInfoList.get(b).getId() == sections.get(i).getCourseInfoId()) {
					//then iterate over calendarInfoList.
					for(int c = 0; c < calendarInfoList.size(); c++) {
						//if the cth element of calendarInfoList's Id is the same as the ith element of section's calendarInfoId
						//and calendarInfoList term property has the same term value as the term variable made from the parameter 
						if(calendarInfoList.get(c).getId() == sections.get(i).getCalendarInfoId() && calendarInfoList.get(c).getTerm() == term) {
							//then set CourseInfo and SectionInfo to be associated with eachother in a pair. else break from loop.
							Pair<CourseInfo, SectionInfo> tempPair1 = new Pair(courseInfoList.get(b), sections.get(i));
							//then set that pair and calendarInfo to be associated with each other. 
							Pair<Pair<CourseInfo, SectionInfo>, CalendarInfo> temp2 = new Pair(tempPair1, calendarInfoList.get(c));
							//then add those 3 associated lists to coursesAndSectionsAndCalendars, and break from the for loop
							coursesAndSectionsAndCalendars.add(temp2);
							break;
						}
					}
					break;
				}
			}
		}
		
		//iterate over sections 
		for(int i = 0; i < sections.size(); i++) {
			//iterate over labs
			for(int b = 0; b < labs.size(); b ++) {
				//if the bth element of labs has the same id as the ith element of section then 
				if(labs.get(b).getSectionInfoId() == sections.get(i).getId()) {
					//iterate over courseInfoList. else break from the loop. 
					for(int c = 0; c < courseInfoList.size(); c++) {
						//if the cth element of courseInfiList has the same id as teh ith element of sections then
						if(courseInfoList.get(c).getId() == sections.get(i).getCourseInfoId()) {
							//iterate over calendarInfoList
							for(int d = 0; d < calendarInfoList.size(); d++) {
								// same thing as the big for loop above, just with different lists, and info
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
		
		//iterate over our combined list.
		for(int i = 0; i < coursesAndSectionsAndCalendars.size(); i++) {
			//add the courseName, from the first value of the first pair of the ith element of the courseAndSectionsAndCaldendars paired list. 
			view.getCalendarList().addItem(coursesAndSectionsAndCalendars.get(i).getValue1().getValue1().getCourseName() + 
					" Section Number: " + 
					//set the second value of the ith element of this lists term to a string. 
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
		
		//same thing as aboce
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
		
		//turns the load screen off. load the actual screen. 
		parentPresenter.hideLoadScreen();
		applyFilterInProgress = false;
		view.getApply().setEnabled(true);
		
		return true;
	}
	
	//turn the term string into an int. 
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
	
	//turn the term int into a string. 
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
