package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;

import javax.inject.Inject;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendEditWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendRequestNewScheduleAction;
import org.dselent.course_load_scheduler.client.action.SendSortWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendViewCourseDetailsAction;
import org.dselent.course_load_scheduler.client.event.ReceiveWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendEditWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestDifferentScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestNewScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SendSortWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendViewCourseDetailsEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.WishlistLinks;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.WishlistPresenter;
import org.dselent.course_load_scheduler.client.utils.Pair;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.WishlistView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public class WishlistPresenterImpl extends BasePresenterImpl implements WishlistPresenter {

	private IndexPresenter parentPresenter;
	private MenuTabsPresenterImpl menuTabs;
	private WishlistView view;
	private boolean sort;
	private boolean viewCourseDetails;
	private boolean requestNewSchedule;
	private boolean editWishlist;
	private ArrayList<InstructorInfo> instructorInfoList;
	private ArrayList<SectionInfo> sectionInfoList;
	private ArrayList<CalendarInfo> calendarInfoList;
	private ArrayList<CourseInfo> courseInfoList;
	private ArrayList<LabInfo> labInfoList;
	private ArrayList<WishlistLinks> wishlists;

	@Inject
	public WishlistPresenterImpl(IndexPresenter parentPresenter, WishlistView view) {
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setParent(this);

	}

	@Override
	public void go(HasWidgets container) {
		
		ArrayList<String> departments = new ArrayList<>();
		for(int i = 0; i < instructorInfoList.size(); i++) {
			boolean onList = false;
			for(int b = 0; b < departments.size(); b++) {
				if(instructorInfoList.get(i).getDepartment().equals(departments.get(b))){
					onList = true;
				}
			}
			if(!onList) {
				departments.add(instructorInfoList.get(i).getDepartment());
			}
		}
		java.util.Collections.sort(departments);
		
		ArrayList<Integer> courseNumbers = new ArrayList<>();
		for(int i = 0; i < courseInfoList.size(); i++) {
			courseNumbers.add(courseInfoList.get(i).getCourseNumber());
		}
		java.util.Collections.sort(courseNumbers);

		for (int i = 0; i < departments.size(); i++) {
			view.getDeptCmbx().addItem(departments.get(i));
		}
		
		view.getTermCmbx().addItem("A");
		view.getTermCmbx().addItem("B");
		view.getTermCmbx().addItem("C");
		view.getTermCmbx().addItem("D");
		view.getTermCmbx().addItem("E1");
		view.getTermCmbx().addItem("E2");
		
		view.getSortDeptRadioButton().setValue(true);
		view.getSortTermRadioButton().setValue(false);
		view.getSortCourseNumberRadioButton().setValue(false);
		
		for(int i = 0; i < courseNumbers.size(); i++) {
			view.getCourseNumberCmbx().addItem(courseNumbers.get(i).toString());
		}
		
		wishlistFilter();
		
		container.clear();
		container.add(view.getWidgetContainer());
		
	}
	
	private void wishlistFilter() {
		parentPresenter.showLoadScreen();
		
		view.getCourseListBox().clear();
		view.getLocationListBox().clear();
		view.getTermListBox().clear();
		view.getTimesListBox().clear();
		
		if(view.getSortDeptRadioButton().getValue()) {
			filterByDepartment();
		} else if(view.getSortTermRadioButton().getValue()) {
			filterByTerm();
		} else {
			filterByCourseNumber();
		}
		
		parentPresenter.hideLoadScreen();
	}
	
	public void filterByDepartment() {
		String department = view.getDeptCmbx().getValue(view.getDeptCmbx().getSelectedIndex());
		ArrayList<Pair<Pair<CourseInfo, SectionInfo>, CalendarInfo>> coursesAndSectionsAndCalendars = new ArrayList<>();
		Integer activeUserId = parentPresenter.getActiveUser().getId();
		Integer activeInstructorId = -1;
		for(int i = 0; i < instructorInfoList.size(); i++) {
			if(instructorInfoList.get(i).getUserInfoId() == activeUserId) {
				activeInstructorId = instructorInfoList.get(i).getId();
			}
		}
		if(activeInstructorId == -1) {
			return;
		}
		
		ArrayList<WishlistLinks> userWishlists = new ArrayList<>();
		for(int i = 0; i < wishlists.size(); i++) {
			if(wishlists.get(i).getInstructorInfoId() == activeInstructorId) {
				userWishlists.add(wishlists.get(i));
			}
		}
		
		ArrayList<SectionInfo> wishlistSections = new ArrayList<>();
		for(int i = 0; i < userWishlists.size(); i++) {
			for(int a = 0; a < sectionInfoList.size(); a++) {
				if(userWishlists.get(i).getSectionInfoId() == sectionInfoList.get(a).getId()) {
					wishlistSections.add(sectionInfoList.get(a));
					break;
				}
			}
		}
		
		for(int i = 0; i < courseInfoList.size(); i++) {
			for(int a = 0; a < wishlistSections.size(); a++) {
				if(wishlistSections.get(a).getCourseInfoId() == courseInfoList.get(i).getId()) {
					for(int b = 0; b < calendarInfoList.size(); b++) {
						if(wishlistSections.get(a).getCalendarInfoId() == calendarInfoList.get(b).getId()) {
							Pair<CourseInfo, SectionInfo> cAndS = new Pair(courseInfoList.get(i), wishlistSections.get(a));
							Pair<Pair<CourseInfo, SectionInfo>, CalendarInfo> cAndSAndcal = new Pair(cAndS, calendarInfoList.get(b));
							coursesAndSectionsAndCalendars.add(cAndSAndcal);
							break;
						}
					}
					break;
				}
			}
		}
		
		for(int i = 0; i < coursesAndSectionsAndCalendars.size(); i++) {
			view.getCourseListBox().addItem(coursesAndSectionsAndCalendars.get(i).getValue1().getValue1().getCourseName());
			view.getLocationListBox().addItem(coursesAndSectionsAndCalendars.get(i).getValue1().getValue2().getLocation());
			view.getTimesListBox().addItem(coursesAndSectionsAndCalendars.get(i).getValue2().getStartTime().toString() 
					+ " - " 
					+ coursesAndSectionsAndCalendars.get(i).getValue2().getEndTime().toString());
			view.getTermListBox().addItem(coursesAndSectionsAndCalendars.get(i).getValue2().getTerm().toString() 
					+ coursesAndSectionsAndCalendars.get(i).getValue2().getYear().toString());
		}
	}
	
	public void filterByTerm() {
		String term = view.getTermCmbx().getSelectedItemText();
		
		ArrayList<Pair<Pair<CalendarInfo, SectionInfo>, CourseInfo>> calendarsAndSectionsAndCourses = new ArrayList<>();
		Integer activeUserId = parentPresenter.getActiveUser().getId();
		Integer activeInstructorId = -1;
		for(int i = 0; i < instructorInfoList.size(); i++) {
			if(instructorInfoList.get(i).getUserInfoId() == activeUserId) {
				activeInstructorId = instructorInfoList.get(i).getId();
			}
		}
		if(activeInstructorId == -1) {
			return;
		}
		
		ArrayList<WishlistLinks> userWishlists = new ArrayList<>();
		for(int i = 0; i < wishlists.size(); i++) {
			if(wishlists.get(i).getInstructorInfoId() == activeInstructorId) {
				userWishlists.add(wishlists.get(i));
			}
		}
		
		ArrayList<SectionInfo> wishlistSections = new ArrayList<>();
		for(int i = 0; i < userWishlists.size(); i++) {
			for(int a = 0; a < sectionInfoList.size(); a++) {
				if(userWishlists.get(i).getSectionInfoId() == sectionInfoList.get(a).getId()) {
					wishlistSections.add(sectionInfoList.get(a));
					break;
				}
			}
		}
		
		ArrayList<Pair<CalendarInfo, SectionInfo>> calendarsAndSections = new ArrayList<>();
		for(int i = 0; i < wishlistSections.size(); i++) {
			for(int a = 0; a < calendarInfoList.size(); a++) {
				if(wishlistSections.get(i).getCourseInfoId() == calendarInfoList.get(a).getId()) {
					if(termToString(calendarInfoList.get(a).getTerm()).equals(term)) {
						Pair<CalendarInfo, SectionInfo> temp = new Pair(calendarInfoList.get(a), wishlistSections.get(i));
						calendarsAndSections.add(temp);
						break;
					}
				}
			}
		}
		
		for(int i = 0; i < calendarsAndSections.size(); i++) {
			for(int a = 0; a < courseInfoList.size(); a++) {
				if(calendarsAndSections.get(i).getValue2().getCourseInfoId() == courseInfoList.get(a).getId()) {
					Pair<Pair<CalendarInfo, SectionInfo>, CourseInfo> temp = new Pair(calendarsAndSections.get(i), courseInfoList.get(a));
					calendarsAndSectionsAndCourses.add(temp);
					break;
				}
			}
		}
		
		for(int i = 0; i < calendarsAndSectionsAndCourses.size(); i++) {
			view.getCourseListBox().addItem(calendarsAndSectionsAndCourses.get(i).getValue2().getCourseName());
			view.getLocationListBox().addItem(calendarsAndSectionsAndCourses.get(i).getValue1().getValue2().getLocation());
			view.getTimesListBox().addItem(calendarsAndSectionsAndCourses.get(i).getValue1().getValue1().getStartTime().toString() 
					+ " - " 
					+ calendarsAndSectionsAndCourses.get(i).getValue1().getValue1().getEndTime().toString());
			view.getTermListBox().addItem(calendarsAndSectionsAndCourses.get(i).getValue1().getValue1().getTerm().toString() 
					+ calendarsAndSectionsAndCourses.get(i).getValue1().getValue1().getYear().toString());
		}
	}
	
	public void filterByCourseNumber() {
		Integer courseNum = termToInt(view.getCourseNumberCmbx().getValue(view.getCourseNumberCmbx().getSelectedIndex()));
		Integer activeUserId = parentPresenter.getActiveUser().getId();
		ArrayList<Pair<Pair<CourseInfo, SectionInfo>, CalendarInfo>> coursesAndSectionsAndCalendars = new ArrayList<>();

		Integer activeInstructorId = -1;
		for(int i = 0; i < instructorInfoList.size(); i++) {
			if(instructorInfoList.get(i).getUserInfoId() == activeUserId) {
				activeInstructorId = instructorInfoList.get(i).getId();
			}
		}
		if(activeInstructorId == -1) {
			return;
		}

		ArrayList<CourseInfo> courses = new ArrayList<>();
		for(int i = 0; i < courseInfoList.size(); i++) {
			if(courseInfoList.get(i).getCourseNumber() == courseNum) {
				courses.add(courseInfoList.get(i));
			}
		}
		
		ArrayList<WishlistLinks> userWishlists = new ArrayList<>();
		for(int i = 0; i < wishlists.size(); i++) {
			if(wishlists.get(i).getInstructorInfoId() == activeInstructorId) {
				userWishlists.add(wishlists.get(i));
			}
		}
		
		ArrayList<SectionInfo> sections = new ArrayList<>();
		for(int i = 0; i < sectionInfoList.size(); i++) {
			for(int a = 0; a < userWishlists.size(); a++) {
				if(userWishlists.get(a).getSectionInfoId() == sectionInfoList.get(i).getId()) {
					sections.add(sectionInfoList.get(i));
				}
				break;
			}
		}
		
		for(int i = 0; i < courses.size(); i++) {
			for(int a = 0; a < sections.size(); a++) {
				if(sections.get(a).getCourseInfoId() == courses.get(i).getId()) {
					for(int b = 0; b < calendarInfoList.size(); b++) {
						if(sections.get(a).getCalendarInfoId() == calendarInfoList.get(b).getId()) {
							Pair<CourseInfo, SectionInfo> cAndS = new Pair(courses.get(i), sections.get(a));
							Pair<Pair<CourseInfo, SectionInfo>, CalendarInfo> cAndSAndcal = new Pair(cAndS, calendarInfoList.get(b));
							coursesAndSectionsAndCalendars.add(cAndSAndcal);
							break;
						}
					}
					break;
				}
			}
		}
		
		for(int i = 0; i < coursesAndSectionsAndCalendars.size(); i++) {
			view.getCourseListBox().addItem(coursesAndSectionsAndCalendars.get(i).getValue1().getValue1().getCourseName());
			view.getLocationListBox().addItem(coursesAndSectionsAndCalendars.get(i).getValue1().getValue2().getLocation());
			view.getTimesListBox().addItem(coursesAndSectionsAndCalendars.get(i).getValue2().getStartTime().toString() 
					+ " - " 
					+ coursesAndSectionsAndCalendars.get(i).getValue2().getEndTime().toString());
			view.getTermListBox().addItem(coursesAndSectionsAndCalendars.get(i).getValue2().getTerm().toString() 
					+ coursesAndSectionsAndCalendars.get(i).getValue2().getYear().toString());
		}
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
	// wisihlitview getview

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
	public void sort(RadioButton name, ListBox department, ListBox term, TextBox courseNumber) {
		if (!sort) {

			sort = true;
			view.getSortButton().setEnabled(false);

//			String department1 = department.getItemText(department.getSelectedIndex());
//			String term1 = term.getItemText(term.getSelectedIndex());
//			String courseNumber1 = courseNumber.getSelectedText();
//			sendSort(department1, term1, courseNumber1);
			
			wishlistFilter();
			
			view.getSortButton().setEnabled(true);
			sort = false;

		}

	}

//	private void sendSort(String dept, String term, String courseNum) {
//
//		SendSortWishlistAction ssa = new SendSortWishlistAction(dept, term, courseNum);
//		SendSortWishlistEvent sse = new SendSortWishlistEvent(ssa);
//		eventBus.fireEvent(sse);
//
//	}

	@Override
	public void viewCourseDetails(ListBox course) {
		if (!viewCourseDetails) {

			viewCourseDetails = true;
			view.getViewCourseDetailsButton().setEnabled(false);

//			String course1 = course.getItemText(course.getSelectedIndex());
//			sendViewCourseDetails(course1);
			
			menuTabs.courses();
			view.getViewCourseDetailsButton().setEnabled(true);
			viewCourseDetails = false;
		}

	}

//	private void sendViewCourseDetails(String course) {
//
//		SendViewCourseDetailsAction svcda = new SendViewCourseDetailsAction(course);
//		SendViewCourseDetailsEvent svcde = new SendViewCourseDetailsEvent(svcda, this.getView().getViewRootPanel());
//		eventBus.fireEvent(svcde);
//
//	}

	@Override
	public void editWishlist() {
		if (!editWishlist) {

			editWishlist = true;
			view.getEditWishlistButton().setEnabled(false);

//			sendEditWishList();
			
			menuTabs.courses();
			view.getEditWishlistButton().setEnabled(true);
			editWishlist = false;

		}
	}

//	private void sendEditWishList() {
//
//		SendEditWishlistAction svcda = new SendEditWishlistAction();
//		SendEditWishlistEvent svcde = new SendEditWishlistEvent(svcda);
//		eventBus.fireEvent(svcde);
//
//	}

	@Override
	public void requestNewSchedule() {
		if (!requestNewSchedule) {
			requestNewSchedule = true;
			view.getRequestNewScheduleButton();

			sendRequestNewSchedule();
		}

	}

	private void sendRequestNewSchedule() {

		SendRequestNewScheduleAction srnsa = new SendRequestNewScheduleAction();
		SendRequestNewScheduleEvent srnse = new SendRequestNewScheduleEvent(srnsa);
		eventBus.fireEvent(srnse);

	}

	//TODO the two following methods are not constructed correctly and need to be fixed
//	@Override
//	public void onSendWishlist(SendWishlistEvent evt) {
//		go(evt.getAction().getPanel());
//	}
//
//	@Override
//	public void onSendRequestDifferentSchedule(SendRequestDifferentScheduleEvent evt) {
//		go(evt.getAction().getPanel());
//	}

	public ArrayList<SectionInfo> getSectionInfoList() {
		return sectionInfoList;
	}

	public void setSectionInfoList(ArrayList<SectionInfo> sectionInfoList) {
		this.sectionInfoList = sectionInfoList;
	}

	public ArrayList<CalendarInfo> getCalendarInfoList() {
		return calendarInfoList;
	}

	public void setCalendarInfoList(ArrayList<CalendarInfo> calendarInfoList) {
		this.calendarInfoList = calendarInfoList;
	}

	public ArrayList<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}

	public void setCourseInfoList(ArrayList<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}

	public ArrayList<LabInfo> getLabInfoList() {
		return labInfoList;
	}

	public void setLabInfoList(ArrayList<LabInfo> labInfoList) {
		this.labInfoList = labInfoList;
	}

	public void onReceiveWishlist(ReceiveWishlistEvent evt) {
		HasWidgets container = evt.getContainer();
		ReceiveWishlistAction rwa = evt.getAction();
		setSectionInfoList(rwa.getSections());
		setCalendarInfoList(rwa.getCalendars());
		setCourseInfoList(rwa.getCourses());
		setLabInfoList(rwa.getLabs());
		wishlists = rwa.getWishlists();
		
		go(container);
		Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
	}

	public MenuTabsPresenterImpl getMenuTabs() {
		return menuTabs;
	}

	public void setMenuTabs(MenuTabsPresenterImpl menuTabs) {
		this.menuTabs = menuTabs;
	}
}
