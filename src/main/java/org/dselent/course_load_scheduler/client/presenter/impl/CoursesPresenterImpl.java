package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;

import javax.inject.Inject;

import org.dselent.course_load_scheduler.client.action.ReceiveCoursesAction;
import org.dselent.course_load_scheduler.client.action.SendAddToWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendApplyChangesAction;
import org.dselent.course_load_scheduler.client.action.SendCancelChangesAction;
import org.dselent.course_load_scheduler.client.action.SendCreateCourseAction;
import org.dselent.course_load_scheduler.client.action.SendEditCoursesAction;
import org.dselent.course_load_scheduler.client.action.SendMeetingTimesAction;
import org.dselent.course_load_scheduler.client.action.SendPopup1ApplyAction;
import org.dselent.course_load_scheduler.client.action.SendPopup1CancelAction;
import org.dselent.course_load_scheduler.client.action.SendPopup2ApplyAction;
import org.dselent.course_load_scheduler.client.action.SendPopup2CancelAction;
import org.dselent.course_load_scheduler.client.action.SendPopup2StartTimeAction;
import org.dselent.course_load_scheduler.client.action.SendPopup3ApplyAction;
import org.dselent.course_load_scheduler.client.action.SendRemoveCourseAction;
import org.dselent.course_load_scheduler.client.action.SendRemoveSelectedFromWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendSectionTypeAction;
import org.dselent.course_load_scheduler.client.action.SendSortCoursesAction;
import org.dselent.course_load_scheduler.client.action.SendViewFullWishlistAction;
import org.dselent.course_load_scheduler.client.event.ReceiveCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendAddToWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendApplyChangesEvent;
import org.dselent.course_load_scheduler.client.event.SendCancelChangesEvent;
import org.dselent.course_load_scheduler.client.event.SendCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendCreateCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendEditCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendMeetingTimesEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup1ApplyEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup1CancelEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup2ApplyEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup2CancelEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup2EndTimeEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup2StartTimeEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup3ApplyEvent;
import org.dselent.course_load_scheduler.client.event.SendRemoveCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendRemoveSelectedFromWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendSectionTypeEvent;
import org.dselent.course_load_scheduler.client.event.SendSortCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendViewFullWishlistEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.CoursesPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.utils.Quintuple;
import org.dselent.course_load_scheduler.client.view.CoursesView;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public class CoursesPresenterImpl extends BasePresenterImpl implements CoursesPresenter {
	
	private IndexPresenter parentPresenter;
	private CoursesView view;
	private boolean requestSortCoursesInProgress;
	private boolean requestAddToWishlistInProgress;
	private boolean requestEditCoursesInProgress;
	private boolean requestApplyChangesInProgress;
	private boolean requestCancelChangesInProgress;
	private boolean requestRemoveCourseInProgress;
	private boolean requestRemoveSelectedFromWishlistInProgress;
	private boolean requestViewFullWishlistInProgress;
	private boolean requestCreateNewCourseInProgress;
	private boolean requestSectionTypeInProgress;
	private boolean requestMeetingTimesInProgress;
	private boolean requestPopup1ApplyInProgress;
	private boolean requestPopup1CancelInProgress;
	private boolean requestPopup2StartTimeInProgress;
	private boolean requestPopup2EndTimeInProgress;
	private boolean requestPopup2ApplyInProgress;
	private boolean requestPopup2CancelInProgress;
	private boolean requestPopup3ApplyInProgress;
	private boolean populateCoursesInProgress;
	private boolean populateWishlistInProgress;
	private ArrayList<CourseInfo> courseList;
	private ArrayList<SectionInfo> sectionList;
	private ArrayList<CalendarInfo> calendarList;
	private ArrayList<LabInfo> labList;
	private ArrayList<InstructorInfo> instructorInfoList;
	private ArrayList<UserInfo> userInfoList;

	@Inject
	public CoursesPresenterImpl(IndexPresenter parentPresenter, CoursesView view)
	{
		this.parentPresenter = parentPresenter;
		this.view = view;
		view.setPresenter(this);
		
		
	}
	
	
	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public void bind()
	{
		HandlerRegistration sortRegistration;
		sortRegistration = eventBus.addHandler(SendSortCoursesEvent.TYPE, this);
		eventBusRegistration.put(SendSortCoursesEvent.TYPE, sortRegistration);
		
		HandlerRegistration addToWishlistRegistration;
		addToWishlistRegistration = eventBus.addHandler(SendAddToWishlistEvent.TYPE, this);
		eventBusRegistration.put(SendAddToWishlistEvent.TYPE, addToWishlistRegistration);
		
		HandlerRegistration editRegistration;
		editRegistration = eventBus.addHandler(SendEditCoursesEvent.TYPE, this);
		eventBusRegistration.put(SendEditCoursesEvent.TYPE, editRegistration);

		HandlerRegistration applyChangesRegistration;
		applyChangesRegistration = eventBus.addHandler(SendApplyChangesEvent.TYPE, this);
		eventBusRegistration.put(SendApplyChangesEvent.TYPE, applyChangesRegistration);

		HandlerRegistration cancelChangesRegistration;
		cancelChangesRegistration = eventBus.addHandler(SendCancelChangesEvent.TYPE, this);
		eventBusRegistration.put(SendCancelChangesEvent.TYPE, cancelChangesRegistration);

		HandlerRegistration removeCourseRegistration;
		removeCourseRegistration = eventBus.addHandler(SendRemoveCourseEvent.TYPE, this);
		eventBusRegistration.put(SendRemoveCourseEvent.TYPE, removeCourseRegistration);
		
		HandlerRegistration removeSelectedFromWishlistRegistration;
		removeSelectedFromWishlistRegistration = eventBus.addHandler(SendRemoveSelectedFromWishlistEvent.TYPE, this);
		eventBusRegistration.put(SendRemoveSelectedFromWishlistEvent.TYPE, removeSelectedFromWishlistRegistration);

		HandlerRegistration viewFullWishlistRegistration;
		viewFullWishlistRegistration = eventBus.addHandler(SendViewFullWishlistEvent.TYPE, this);
		eventBusRegistration.put(SendViewFullWishlistEvent.TYPE, viewFullWishlistRegistration);

		HandlerRegistration createNewCourseRegistration;
		createNewCourseRegistration = eventBus.addHandler(SendCreateCourseEvent.TYPE, this);
		eventBusRegistration.put(SendCreateCourseEvent.TYPE, createNewCourseRegistration);
		
		HandlerRegistration sectionTypeRegistration;
		sectionTypeRegistration = eventBus.addHandler(SendSectionTypeEvent.TYPE, this);
		eventBusRegistration.put(SendSectionTypeEvent.TYPE, sectionTypeRegistration);

		HandlerRegistration meetingTimesRegistration;
		meetingTimesRegistration = eventBus.addHandler(SendMeetingTimesEvent.TYPE, this);
		eventBusRegistration.put(SendMeetingTimesEvent.TYPE, meetingTimesRegistration);

		HandlerRegistration popup1ApplyRegistration;
		popup1ApplyRegistration = eventBus.addHandler(SendPopup1ApplyEvent.TYPE, this);
		eventBusRegistration.put(SendPopup1ApplyEvent.TYPE, popup1ApplyRegistration);
		
		HandlerRegistration popup1CancelRegistration;
		popup1CancelRegistration = eventBus.addHandler(SendPopup1CancelEvent.TYPE, this);
		eventBusRegistration.put(SendPopup1CancelEvent.TYPE, popup1CancelRegistration);

		HandlerRegistration popup2StartTimeRegistration;
		popup2StartTimeRegistration = eventBus.addHandler(SendPopup2StartTimeEvent.TYPE, this);
		eventBusRegistration.put(SendPopup2StartTimeEvent.TYPE, popup2StartTimeRegistration);
		
		HandlerRegistration popup2EndTimeRegistration;
		popup2EndTimeRegistration = eventBus.addHandler(SendPopup2EndTimeEvent.TYPE, this);
		eventBusRegistration.put(SendPopup2EndTimeEvent.TYPE, popup2EndTimeRegistration);

		HandlerRegistration popup2ApplyRegistration;
		popup2ApplyRegistration = eventBus.addHandler(SendPopup2ApplyEvent.TYPE, this);
		eventBusRegistration.put(SendPopup2ApplyEvent.TYPE, popup2ApplyRegistration);
		
		HandlerRegistration popup2CancelRegistration;
		popup2CancelRegistration = eventBus.addHandler(SendPopup2CancelEvent.TYPE, this);
		eventBusRegistration.put(SendPopup2CancelEvent.TYPE, popup2CancelRegistration);

		HandlerRegistration popup3ApplyRegistration;
		popup3ApplyRegistration = eventBus.addHandler(SendPopup3ApplyEvent.TYPE, this);
		eventBusRegistration.put(SendPopup3ApplyEvent.TYPE, popup3ApplyRegistration);
		
	}
	
	//
	
	@Override
	public CoursesView getView()
	{
		return view;
	}
		
	@Override
	public void showPopupPanel1()
	{
		// thank you stackoverflow
		// https://stackoverflow.com/questions/23017908/gwt-set-the-visibility-of-widget-using-css-visibility-property
		view.getPopupPanel1().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
	}
	
	@Override
	public void hidePopupPanel1()
	{
		view.getPopupPanel1().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
	}
	
	@Override
	public void showPopupPanel2()
	{
		// thank you stackoverflow
		// https://stackoverflow.com/questions/23017908/gwt-set-the-visibility-of-widget-using-css-visibility-property
		view.getPopupPanel2().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
	}
	
	@Override
	public void hidePopupPanel2()
	{
		view.getPopupPanel2().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
	}
	
	@Override
	public void showPopupPanel3()
	{
		// thank you stackoverflow
		// https://stackoverflow.com/questions/23017908/gwt-set-the-visibility-of-widget-using-css-visibility-property
		view.getPopupPanel3().getElement().getStyle().setVisibility(Style.Visibility.VISIBLE);
	}
	
	@Override
	public void hidePopupPanel3()
	{
		view.getPopupPanel3().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
	}
	
	@Override
	public void go(HasWidgets container) {
		
		view.getDepartmentRadioButton().setValue(true);
		view.getTermRadioButton().setValue(false);
		view.getCourseNumberRadioButton().setValue(false);
		
		clearCoursesTextBoxes();
		
		view.getTermDropDown().addItem("A");
		view.getTermDropDown().addItem("B");
		view.getTermDropDown().addItem("C");
		view.getTermDropDown().addItem("D");
		view.getTermDropDown().addItem("E1");
		view.getTermDropDown().addItem("E2");
		
		view.getDepartmentDropDown().addItem("CS");
		view.getDepartmentDropDown().addItem("IMGD");
		view.getDepartmentDropDown().addItem("ECE");
		view.getDepartmentDropDown().addItem("RBE");
		view.getDepartmentDropDown().addItem("MA");
		
		view.getCourseNumberTextBox().setText("Course Number");
		
		
		coursesFilter(view.getDepartmentRadioButton().getValue(), view.getTermRadioButton().getValue(), view.getCourseNumberRadioButton().getValue());
		
		container.clear();
		container.add(view.getWidgetContainer());
		
		if(parentPresenter.getActiveUser().getUserRole() == 1) {
			editButtons(false);
		}
	}
	
	private void editButtons(Boolean editing) {
		
		view.getEditButton().setEnabled(!editing);
		view.getApplyChangesButton().setEnabled(editing);
		view.getCancelChangesButton().setEnabled(editing);
		view.getRemoveCourseButton().setEnabled(editing);
		view.getMeetingTimesTextBox().setEnabled(editing);
		view.getSectionTypeTextBox().setEnabled(editing);
		
	}
	
	private void clearCoursesTextBoxes() {
		view.getDepartmentTextBox().setText("");
		view.getCourseNumberSideTextBox().setText("");
		view.getCourseSectionTextBox().setText("");
		view.getSectionTypeTextBox().setText("");
		view.getTermTextBox().setText("");
		view.getMeetingTimesTextBox().setText("");
		view.getLocationTextBox().setText("");

	}
	
	
	private void coursesFilter(Boolean departmentsRadioButton, Boolean termRadioButton, Boolean courseNumberRadioButton) {
		parentPresenter.showLoadScreen();
		if(departmentsRadioButton) {
			filterByDepartment();
		}
		else if(termRadioButton) {
			filterByTerm();
		}
		else {
			filterByCourseNumber();
		}
		parentPresenter.hideLoadScreen();
	}
	
	private void filterByDepartment() {
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
		
		ArrayList<Integer> sections = new ArrayList<>();
		
		for(int i = 0; i < sectionList.size(); i++) {
			boolean onList = false;
			for(int b = 0; b < sections.size(); b++) {
				if(sectionList.get(i).getSectionNumber().equals(sections.get(b))){
					onList = true;
				}
			}
			if(!onList) {
				sections.add(sectionList.get(i).getSectionNumber());
			}
		}
	
		java.util.Collections.sort(sections);
				
		ArrayList<CourseInfo> alphaCourseList = alphabatizeCourses(courseList);
		ArrayList<UserInfo> alphaUserList = alphabatizeUsers(userInfoList);
		
		ArrayList<Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo>> quintupleList = new ArrayList<>();

		for(int i = 0; i < alphaCourseList.size(); i++) {
			Boolean hasCourse = false;
			for(int a = 0; a < alphaUserList.size(); a++) {
				for(int b = 0; b < instructorInfoList.size(); b++) {
					if(instructorInfoList.get(b).getUserInfoId() == alphaUserList.get(i).getId()) {
						Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo> temp = new Quintuple(instructorInfoList.get(b), alphaUserList.get(a), alphaCourseList.get(i), sectionList, calendarList);
						quintupleList.add(temp);
						hasCourse = true;
						break;
					}
				}
				if(!hasCourse) {
					Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo> temp2 = new Quintuple(new InstructorInfo(), alphaUserList.get(a), alphaCourseList.get(i), sectionList, calendarList);
					quintupleList.add(temp2);
				}
			}
			
			hasCourse = false;
		}
		
		ArrayList<Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo>> sortedQuintuple = new ArrayList<>();
				
		for(int i = 0; i < departments.size(); i++) {
			for(int b = 0; i < quintupleList.size(); b++) {
				if(departments.get(i).equals(quintupleList.get(b).getValue1().getDepartment())) {
					sortedQuintuple.add(quintupleList.get(b));
				}
			}
		}
		
		for(int i = 0; i < quintupleList.size(); i++) {
			if(quintupleList.get(i).getValue1().getDepartment().isEmpty()) {
				sortedQuintuple.add(quintupleList.get(i));
			}
		}
		
		for(int i = 0; i < quintupleList.size(); i++) {
			view.getCoursesListBox().addItem(quintupleList.get(i).getValue3().getDepartment()
					+" "
					+ quintupleList.get(i).getValue3().getCourseNumber()
					+ " --- "
					+ quintupleList.get(i).getValue4().getSectionNumber()
					+ " "
					+ quintupleList.get(i).getValue5().getDays()
					+ " "
					+ quintupleList.get(i).getValue5().getStartTime()
					+ " "
					+ quintupleList.get(i).getValue5().getEndTime()
					+ " "
					+ quintupleList.get(i).getValue2().getLastName()
					+ " "
					+ quintupleList.get(i).getValue2().getFirstName());
		}
	}
	
	
	// Filter by Term
	
	private void filterByTerm() {
		ArrayList<Integer> terms = new ArrayList<>();
		
		for(int i = 0; i < calendarList.size(); i++) {
			boolean onList = false;
			for(int b = 0; b < terms.size(); b++) {
				if(calendarList.get(i).getTerm().equals(terms.get(b))){
					onList = true;
				}
			}
			if(!onList) {
				terms.add(calendarList.get(i).getTerm());
			}
		}
		
		java.util.Collections.sort(terms);
		
		ArrayList<Integer> sections = new ArrayList<>();
		
			for(int i = 0; i < sectionList.size(); i++) {
				boolean onList = false;
				for(int b = 0; b < sections.size(); b++) {
					if(sectionList.get(i).getSectionNumber().equals(sections.get(b))){
						onList = true;
					}
				}
				if(!onList) {
					sections.add(sectionList.get(i).getSectionNumber());
				}
			}
		
		java.util.Collections.sort(sections);
						
		ArrayList<CourseInfo> alphaCourseList = alphabatizeCourses(courseList);
		ArrayList<UserInfo> alphaUserList = alphabatizeUsers(userInfoList);
		
		ArrayList<Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo>> quintupleList = new ArrayList<>();

		for(int i = 0; i < alphaCourseList.size(); i++) {
			Boolean hasCourse = false;
			for(int a = 0; a < alphaUserList.size(); a++) {
				for(int b = 0; b < instructorInfoList.size(); b++) {
					if(instructorInfoList.get(b).getUserInfoId() == alphaUserList.get(i).getId()) {
						Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo> temp = new Quintuple(instructorInfoList.get(b), alphaUserList.get(a), alphaCourseList.get(i), sectionList, calendarList);
						quintupleList.add(temp);
						hasCourse = true;
						break;
					}
				}
				if(!hasCourse) {
					Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo> temp2 = new Quintuple(new InstructorInfo(), alphaUserList.get(a), alphaCourseList.get(i), sectionList, calendarList);
					quintupleList.add(temp2);
				}
			}
			
			hasCourse = false;
		}
		
		ArrayList<Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo>> sortedQuintuple = new ArrayList<>();
				
		for(int i = 0; i < terms.size(); i++) {
			for(int b = 0; i < quintupleList.size(); b++) {
				if(terms.get(i).equals(quintupleList.get(b).getValue5().getTerm())) {
					sortedQuintuple.add(quintupleList.get(b));
				}
			}
		}
		
		for(int i = 0; i < quintupleList.size(); i++) {
			if(quintupleList.get(i).getValue5().getTerm().toString().isEmpty()) {
				sortedQuintuple.add(quintupleList.get(i));
			}
		}
		
		for(int i = 0; i < quintupleList.size(); i++) {
			view.getCoursesListBox().addItem(quintupleList.get(i).getValue3().getDepartment()
					+" "
					+ quintupleList.get(i).getValue3().getCourseNumber()
					+ " --- "
					+ quintupleList.get(i).getValue4().getSectionNumber()
					+ " "
					+ quintupleList.get(i).getValue5().getDays()
					+ " "
					+ quintupleList.get(i).getValue5().getStartTime()
					+ " "
					+ quintupleList.get(i).getValue5().getEndTime()
					+ " "
					+ quintupleList.get(i).getValue2().getLastName()
					+ " "
					+ quintupleList.get(i).getValue2().getFirstName());
		}
	}
	
	
	
	
	// Filter By CourseNumber
	
	private void filterByCourseNumber() {
		ArrayList<Integer> courseNumbers = new ArrayList<>();
		
		for(int i = 0; i < courseList.size(); i++) {
			boolean onList = false;
			for(int b = 0; b < courseNumbers.size(); b++) {
				if(courseList.get(i).getCourseNumber().equals(courseNumbers.get(b))){
					onList = true;
				}
			}
			if(!onList) {
				courseNumbers.add(courseList.get(i).getCourseNumber());
			}
		}
		
		java.util.Collections.sort(courseNumbers);
						
		ArrayList<CourseInfo> alphaCourseList = alphabatizeCourses(courseList);
		ArrayList<UserInfo> alphaUserList = alphabatizeUsers(userInfoList);
		
		ArrayList<Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo>> quintupleList = new ArrayList<>();

		for(int i = 0; i < alphaCourseList.size(); i++) {
			Boolean hasCourse = false;
			for(int a = 0; a < alphaUserList.size(); a++) {
				for(int b = 0; b < instructorInfoList.size(); b++) {
					if(instructorInfoList.get(b).getUserInfoId() == alphaUserList.get(i).getId()) {
						Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo> temp = new Quintuple(instructorInfoList.get(b), alphaUserList.get(a), alphaCourseList.get(i), sectionList, calendarList);
						quintupleList.add(temp);
						hasCourse = true;
						break;
					}
				}
				if(!hasCourse) {
					Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo> temp2 = new Quintuple(new InstructorInfo(), alphaUserList.get(a), alphaCourseList.get(i), sectionList, calendarList);
					quintupleList.add(temp2);
				}
			}
			
			hasCourse = false;
		}
		
		ArrayList<Quintuple<InstructorInfo, UserInfo, CourseInfo, SectionInfo, CalendarInfo>> sortedQuintuple = new ArrayList<>();
				
		for(int i = 0; i < courseNumbers.size(); i++) {
			for(int b = 0; i < quintupleList.size(); b++) {
				if(courseNumbers.get(i).equals(quintupleList.get(b).getValue3().getCourseNumber())) {
					sortedQuintuple.add(quintupleList.get(b));
				}
			}
		}
		
		for(int i = 0; i < quintupleList.size(); i++) {
			if(quintupleList.get(i).getValue1().getDepartment().isEmpty()) {
				sortedQuintuple.add(quintupleList.get(i));
			}
		}
		
		for(int i = 0; i < quintupleList.size(); i++) {
			view.getCoursesListBox().addItem(quintupleList.get(i).getValue3().getDepartment()
					+" "
					+ quintupleList.get(i).getValue3().getCourseNumber()
					+ " --- "
					+ quintupleList.get(i).getValue4().getSectionNumber()
					+ " "
					+ quintupleList.get(i).getValue5().getDays()
					+ " "
					+ quintupleList.get(i).getValue5().getStartTime()
					+ " "
					+ quintupleList.get(i).getValue5().getEndTime()
					+ " "
					+ quintupleList.get(i).getValue2().getLastName()
					+ " "
					+ quintupleList.get(i).getValue2().getFirstName());
		}
	}
	
	//End of logic for Sorting the CoursesListBox
	
	
	//
	@Override
	public void populateCoursesViewer() {
		if(!populateCoursesInProgress) {
			populateCoursesInProgress = true;
			view.getSortButton().setEnabled(false);
			populateViewer(view.getCoursesListBox().getValue(view.getCoursesListBox().getSelectedIndex()));
			view.getSortButton().setEnabled(true);
			populateCoursesInProgress = false;
		}
	}
	
	//Logic to populate the courses textBoxes
	private void populateViewer(String parsableString) {
		String department = "";
		
		for(int i = 0; i < parsableString.length(); i++) {
			if(parsableString.charAt(i) != ' ') {
				department = department + parsableString.charAt(i);
			} else {
				break;
			}
		}
		
		CourseInfo course = new CourseInfo();
		SectionInfo section = new SectionInfo();
		CalendarInfo calendar = new CalendarInfo();
		
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getDepartment().equals(department) && (courseList.get(i).getCourseNumber().toString().equals(view.getCourseNumberSideTextBox().getSelectedText()))) {
				course = courseList.get(i);
				break;
			}
		}
		
		for(int i = 0; i < sectionList.size(); i++) {
			if((sectionList.get(i).getSectionNumber().equals(termToInt(view.getCourseSectionTextBox().getSelectedText()))) && (sectionList.get(i).getSectionType().equals(view.getSectionTypeTextBox().getSelectedText())) && (sectionList.get(i).getCourseInfoId().equals(course.getId()))) {
				section = sectionList.get(i);
				break;
			}
		}
		
		for (int i = 0; i < calendarList.size(); i++) {
			if(calendarList.get(i).getId().equals(section.getId())) {
				calendar = calendarList.get(i);
				break;
			}
		}
		
		
		view.getDepartmentTextBox().setText(course.getDepartment());
		view.getCourseNumberSideTextBox().setText(course.getCourseNumber().toString());
		view.getCourseSectionTextBox().setText(section.getSectionNumber().toString());
		view.getSectionTypeTextBox().setText(section.getSectionType());
		view.getTermTextBox().setText(termToString(calendar.getTerm()));
		view.getMeetingTimesTextBox().setText(meetingTimes(calendar.getDays(), calendar.getStartTime(), calendar.getEndTime()));
		view.getLocationTextBox().setText(section.getLocation());
	}

	//get Meeting Times string of "Days" " " "start" "-" "end")
	private String meetingTimes(String days, Integer startTime, Integer endTime) {
		
		String meetingTimes = "";
		
		meetingTimes = meetingTimes + days;
		meetingTimes = meetingTimes + " ";
		meetingTimes = meetingTimes + startTime.toString();
		meetingTimes = meetingTimes + "-";
		meetingTimes = meetingTimes + endTime.toString();
		
		return meetingTimes;
		
	}
	
	
	//converting term to String
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
	
	
	//
	@Override
	public void requestSortCourses(ListBox departmentMenuBar, ListBox termMenuBar, TextBox courseNumberTextBox) {
		if(!requestSortCoursesInProgress) {
			
			requestSortCoursesInProgress = true;
			view.getSortButton().setEnabled(false);
			
			String department = departmentMenuBar.getElement().getInnerText();
			String term = termMenuBar.getElement().getInnerText();
			String courseNumber = courseNumberTextBox.toString();
			
			sendSortCourses(department, courseNumber, term);
		}
		
	}
	
	public void sendSortCourses(String department, String courseNumber, String term) {
		
		SendSortCoursesAction sca = new SendSortCoursesAction(department, courseNumber, term);
		SendSortCoursesEvent sce = new SendSortCoursesEvent(sca);
		eventBus.fireEvent(sce);
		
		
	}
	
	
	@Override
	public void requestAddToWishlist(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox) {
		if(!requestAddToWishlistInProgress) {
			
			requestAddToWishlistInProgress = true;
			view.getAddToWishlistButton().setEnabled(false);
			
			String department = departmentTextBox.getText();
			String courseNumber = courseNumberTextBox.getText();
			String courseSection = courseSectionTextBox.getText();
			String sectionType = sectionTypeTextBox.getText();
			String term = termTextBox.getText();
			String meetingTimes = meetingTimesTextBox.getText();
			String location = locationTextBox.getText();
			
			sendAddToWishlist(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		}
		
	}
	
	public void sendAddToWishlist(String department, String courseNumber, String courseSection, String sectionType, String term, String meetingTimes, String location) {
		
		SendAddToWishlistAction satwa = new SendAddToWishlistAction(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		SendAddToWishlistEvent satwe = new SendAddToWishlistEvent(satwa);
		eventBus.fireEvent(satwe);
		
		
	}
	
	@Override
	public void requestSendEditCourses(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox) {
		if(!requestEditCoursesInProgress) {
			
			requestEditCoursesInProgress = true;
			editButtons(true);
			
			String department = departmentTextBox.getText();
			String courseNumber = courseNumberTextBox.getText();
			String courseSection = courseSectionTextBox.getText();
			String sectionType = sectionTypeTextBox.getText();
			String term = termTextBox.getText();
			String meetingTimes = meetingTimesTextBox.getText();
			String location = locationTextBox.getText();
			
			sendEditCourse(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		}
		
	}
	
	public void sendEditCourse(String department, String courseNumber, String courseSection, String sectionType, String term, String meetingTimes, String location) {
		
		SendEditCoursesAction seca = new SendEditCoursesAction(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		SendEditCoursesEvent sece = new SendEditCoursesEvent(seca);
		eventBus.fireEvent(sece);	
		
	}
	
	@Override
	public void requestApplyChanges(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox) {
		if(!requestApplyChangesInProgress) {
			
			requestApplyChangesInProgress = true;
			editButtons(false);
			
			String department = departmentTextBox.getText();
			String courseNumber = courseNumberTextBox.getText();
			String courseSection = courseSectionTextBox.getText();
			String sectionType = sectionTypeTextBox.getText();
			String term = termTextBox.getText();
			String meetingTimes = meetingTimesTextBox.getText();
			String location = locationTextBox.getText();
			
			sendApplyChanges(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		}
		
	}
	
	public void sendApplyChanges(String department, String courseNumber, String courseSection, String sectionType, String term, String meetingTimes, String location) {
		
		SendApplyChangesAction saca = new SendApplyChangesAction(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		SendApplyChangesEvent sace = new SendApplyChangesEvent(saca);
		eventBus.fireEvent(sace);	
		
	}
	
	@Override
	public void requestCancelChanges(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox) {
		if(!requestCancelChangesInProgress) {
			
			requestCancelChangesInProgress = true;
			editButtons(false);
			
			String department = departmentTextBox.getText();
			String courseNumber = courseNumberTextBox.getText();
			String courseSection = courseSectionTextBox.getText();
			String sectionType = sectionTypeTextBox.getText();
			String term = termTextBox.getText();
			String meetingTimes = meetingTimesTextBox.getText();
			String location = locationTextBox.getText();
			
			sendCancelChanges(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		}
		
	}
	
	public void sendCancelChanges(String department, String courseNumber, String courseSection, String sectionType, String term, String meetingTimes, String location) {
		
		SendCancelChangesAction scca = new SendCancelChangesAction(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		SendCancelChangesEvent scce = new SendCancelChangesEvent(scca);
		eventBus.fireEvent(scce);	
		
	}
	
	@Override
	public void requestRemoveCourse(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox) {
		if(!requestRemoveCourseInProgress) {
			
			requestRemoveCourseInProgress = true;
			editButtons(false);
			
			String department = departmentTextBox.getText();
			String courseNumber = courseNumberTextBox.getText();
			String courseSection = courseSectionTextBox.getText();
			String sectionType = sectionTypeTextBox.getText();
			String term = termTextBox.getText();
			String meetingTimes = meetingTimesTextBox.getText();
			String location = locationTextBox.getText();
			
			sendRemoveCourse(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		}
		
	}
	
	public void sendRemoveCourse(String department, String courseNumber, String courseSection, String sectionType, String term, String meetingTimes, String location) {
		
		SendRemoveCourseAction srca = new SendRemoveCourseAction(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		SendRemoveCourseEvent srce = new SendRemoveCourseEvent(srca);
		eventBus.fireEvent(srce);	
		
	}
	
	@Override
	public void requestRemoveSelectedFromWishlist(ListBox wishlistListBox) {
		if(!requestRemoveSelectedFromWishlistInProgress) {
			
			requestRemoveSelectedFromWishlistInProgress = true;
			view.getRemoveSelectedFromWishlistButton().setEnabled(false);
			
			int courseNumberIndex = wishlistListBox.getSelectedIndex();
			String courseNumber = wishlistListBox.getValue(courseNumberIndex);
			
			int meetingTimesIndex = wishlistListBox.getSelectedIndex();
			String meetingTimes = wishlistListBox.getValue(meetingTimesIndex);
			
			sendRemoveSelectedFromWishlist(courseNumber, meetingTimes);
		}
		
	}
	
	public void sendRemoveSelectedFromWishlist(String courseNumber, String meetingTimes){
		
		SendRemoveSelectedFromWishlistAction srsfwa = new SendRemoveSelectedFromWishlistAction(courseNumber, meetingTimes);
		SendRemoveSelectedFromWishlistEvent srsfwe = new SendRemoveSelectedFromWishlistEvent(srsfwa);
		eventBus.fireEvent(srsfwe);	
		
	}
	
	@Override
	public void requestViewFullWishlist(ListBox wishlistListBox) {
		if(!requestViewFullWishlistInProgress) {
			
			requestViewFullWishlistInProgress = true;
			view.getViewFullWishlistButton().setEnabled(false);
			
			int courseNumberIndex = wishlistListBox.getSelectedIndex();
			String courseNumber = wishlistListBox.getValue(courseNumberIndex);
			
			int meetingTimesIndex = wishlistListBox.getSelectedIndex();
			String meetingTimes = wishlistListBox.getValue(meetingTimesIndex);
			
			sendViewFullWishlist(courseNumber, meetingTimes);
		}
		
	}
	
	public void sendViewFullWishlist(String courseNumber, String meetingTimes){
		
		SendViewFullWishlistAction svfwa = new SendViewFullWishlistAction(courseNumber, meetingTimes);
		SendViewFullWishlistEvent svfwe = new SendViewFullWishlistEvent(svfwa);
		eventBus.fireEvent(svfwe);	
		
	}
	
	@Override
	public void requestCreateCourse(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox){
		if(!requestCreateNewCourseInProgress) {
			
			requestCreateNewCourseInProgress = true;
			view.getCreateCourseButton().setEnabled(false);
			
			String department = departmentTextBox.getText();
			String courseNumber = courseNumberTextBox.getText();
			String courseSection = courseSectionTextBox.getText();
			String sectionType = sectionTypeTextBox.getText();
			String term = termTextBox.getText();
			String meetingTimes = meetingTimesTextBox.getText();
			String location = locationTextBox.getText();
			
			sendCreateNewCourse(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		}
		
	}
	
	public void sendCreateNewCourse(String department, String courseNumber, String courseSection, String sectionType, String term, String meetingTimes, String location){
		
		SendCreateCourseAction scca = new SendCreateCourseAction(department, courseNumber, courseSection, sectionType, term, meetingTimes, location);
		SendCreateCourseEvent scce = new SendCreateCourseEvent(scca);
		eventBus.fireEvent(scce);	
		
	}

	@Override
	public void requestSectionType(TextBox sectionTypeTextBox){
		if(!requestSectionTypeInProgress) {
			
			requestSectionTypeInProgress = true;
			editButtons(false);
			
			String sectionType = sectionTypeTextBox.getText();
			
			sendSectionType(sectionType);
		}
		
	}
	
	public void sendSectionType(String sectionType){
		
		SendSectionTypeAction ssta = new SendSectionTypeAction(sectionType);
		SendSectionTypeEvent sste = new SendSectionTypeEvent(ssta);
		eventBus.fireEvent(sste);	
		showPopupPanel1();
		
	}
	
	@Override
	public void requestMeetingTimes(TextBox meetingTimesTextBox){
		if(!requestMeetingTimesInProgress) {
			
			requestMeetingTimesInProgress = true;
			editButtons(false);
			
			String meetingTimes = meetingTimesTextBox.getText();
			
			sendMeetingTimes(meetingTimes);
		}
		
	}
	
	public void sendMeetingTimes(String meetingTimes){
		
		SendMeetingTimesAction smta = new SendMeetingTimesAction(meetingTimes);
		SendMeetingTimesEvent smte = new SendMeetingTimesEvent(smta);
		eventBus.fireEvent(smte);	
		showPopupPanel2();
		
	}
	
	@Override
	public void requestPopup1Apply(RadioButton lectureRadioButton, RadioButton labRadioButton, RadioButton specialRadioButton){
		if(!requestPopup1ApplyInProgress) {
			
			requestPopup1ApplyInProgress = true;
			view.getPopup1ApplyButton().setEnabled(false);
			
			String sectionType = null;
			
			if(lectureRadioButton.getValue() == true)
				sectionType = lectureRadioButton.getText();
			
			if(labRadioButton.getValue() == true)
				sectionType = labRadioButton.getText();
			
			if(specialRadioButton.getValue() == true)
				sectionType = specialRadioButton.getText();
			
			
			sendPopup1Apply(sectionType);
		}
		
	}
	
	public void sendPopup1Apply(String sectionType){
		
		SendPopup1ApplyAction spaa = new SendPopup1ApplyAction(sectionType);
		SendPopup1ApplyEvent spae = new SendPopup1ApplyEvent(spaa);
		eventBus.fireEvent(spae);
		hidePopupPanel1();
		
	}
	
	@Override
	public void requestPopup1Cancel(){
		if(!requestPopup1CancelInProgress) {
			
			requestPopup1CancelInProgress = true;
			view.getPopup1CancelButton().setEnabled(false);
			
			sendPopup1Cancel();
		}
		
	}
	
	public void sendPopup1Cancel(){
		
		SendPopup1CancelAction spaa = new SendPopup1CancelAction();
		SendPopup1CancelEvent spae = new SendPopup1CancelEvent(spaa);
		eventBus.fireEvent(spae);
		hidePopupPanel1();
		
	}
	
	@Override
	public void requestPopup2StartTime(TextBox popup2StartTimeTextBox){
		if(!requestPopup2StartTimeInProgress) {
			
			requestPopup2StartTimeInProgress = true;
			view.getPopup2StartTimeTextBox().setEnabled(false);
			
			String startTime = popup2StartTimeTextBox.getText();			
			
			sendPopup2StartTimeTextBox(startTime);
		}
		
	}
	
	public void sendPopup2StartTimeTextBox(String startTime){
		
		SendPopup2StartTimeAction spsta = new SendPopup2StartTimeAction(startTime);
		SendPopup2StartTimeEvent spste = new SendPopup2StartTimeEvent(spsta);
		eventBus.fireEvent(spste);	
		
	}
	
	@Override
	public void requestPopup2EndTime(TextBox popup2EndTimeTextBox){
		if(!requestPopup2EndTimeInProgress) {
			
			requestPopup2EndTimeInProgress = true;
			view.getPopup2EndTimeTextBox().setEnabled(false);
			
			String endTime = popup2EndTimeTextBox.getText();			
			
			sendPopup2EndTimeTextBox(endTime);
		}
		
	}
	
	public void sendPopup2EndTimeTextBox(String endTime){
		
		SendPopup2StartTimeAction spsta = new SendPopup2StartTimeAction(endTime);
		SendPopup2StartTimeEvent spste = new SendPopup2StartTimeEvent(spsta);
		eventBus.fireEvent(spste);	
		
	}
	
	@Override
	public void requestPopup2Apply(CheckBox popup2SundayCheckbox, CheckBox popup2MondayCheckbox, CheckBox popup2TuesdayCheckbox, CheckBox popup2WednesdayCheckBox, CheckBox popup2ThursdayCheckbox, CheckBox popup2FridayCheckbox, CheckBox popup2SaturdayCheckbox, TextBox popup2StartTimeTextBox, TextBox popup2EndTimeTextBox){
		if(!requestPopup2ApplyInProgress) {
			
			requestPopup2ApplyInProgress = true;
			view.getPopup2ApplyButton().setEnabled(false);
			
			String meetingDays = null;
			String meetingTimes = null;
			
			if(popup2SundayCheckbox.getValue()) {
				meetingDays = meetingDays + "S";
			}
			if(popup2MondayCheckbox.getValue()) {
				meetingDays = meetingDays + "M";
			}
			if(popup2TuesdayCheckbox.getValue()) {
				meetingDays = meetingDays + "T";
			}
			if(popup2WednesdayCheckBox.getValue()) {
				meetingDays = meetingDays + "W";
			}
			if(popup2ThursdayCheckbox.getValue()) {
				meetingDays = meetingDays + "R";
			}
			if(popup2FridayCheckbox.getValue()) {
				meetingDays = meetingDays + "F";
			}
			if(popup2SaturdayCheckbox.getValue()) {
				meetingDays = meetingDays + "S";
			}
		
			
			meetingTimes = meetingTimes + popup2StartTimeTextBox.getText();
			meetingTimes = meetingTimes + "-";
			meetingTimes = meetingTimes + popup2EndTimeTextBox.getText();
			
			sendPopup2Apply(meetingTimes, meetingDays);
		}
		
	}
	
	public void sendPopup2Apply(String meetingTimes, String meetingDays){
		
		SendPopup2ApplyAction spaa = new SendPopup2ApplyAction(meetingTimes, meetingDays);
		SendPopup2ApplyEvent spae = new SendPopup2ApplyEvent(spaa);
		eventBus.fireEvent(spae);	
		hidePopupPanel2();
		
	}
	
	@Override
	public void requestPopup2Cancel(){
		if(!requestPopup2CancelInProgress) {
			
			requestPopup2CancelInProgress = true;
			view.getPopup2CancelButton().setEnabled(false);
			
			sendPopup2Cancel();
		}
		
	}
	
	public void sendPopup2Cancel(){
		
		SendPopup2CancelAction spca = new SendPopup2CancelAction();
		SendPopup2CancelEvent spce = new SendPopup2CancelEvent(spca);
		eventBus.fireEvent(spce);	
		hidePopupPanel2();
		
	}
	
	@Override
	public void requestPopup3Apply(RadioButton popup3YesRadio, RadioButton popup3NoRadio){
		if(!requestPopup3ApplyInProgress) {
			
			requestPopup3ApplyInProgress = true;
			view.getPopup3ApplyButton().setEnabled(false);
			
			String apply = null;
			
			if(popup3YesRadio.getValue() == true)
				apply = popup3YesRadio.getText();
			
			if(popup3NoRadio.getValue() == true)
				apply = popup3NoRadio.getText();
			
			
			sendPopup3Apply(apply);
		}
		
	}
	
	public void sendPopup3Apply(String apply){
		
		SendPopup3ApplyAction spaa = new SendPopup3ApplyAction(apply);
		SendPopup3ApplyEvent spae = new SendPopup3ApplyEvent(spaa);
		eventBus.fireEvent(spae);	
		hidePopupPanel3();
		
	}

	@Override
	public void onSendCourses(SendCoursesEvent evt) {
		go(evt.getAction().getPanel());
	}	
	
	@Override
	public void onReceiveCourses(ReceiveCoursesEvent evt)
	{
		HasWidgets container = evt.getContainer();
		ReceiveCoursesAction rca = evt.getAction();
		courseList = rca.getCourses();
		sectionList = rca.getSections();
		calendarList = rca.getCalendars();
		labList = rca.getLabs();
		go(container);
		Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
	}
	
	
	//Alphabatize by CourseName
	private ArrayList<CourseInfo> alphabatizeCourses(ArrayList<CourseInfo> unsortedCourses){
		ArrayList<CourseInfo> sortedCourses = new ArrayList<>();
		
		ArrayList<String> courseName = new ArrayList<>();
		
		for(int i = 0; i < unsortedCourses.size(); i++) {
			courseName.add(unsortedCourses.get(i).getCourseName());
		}
		
		java.util.Collections.sort(courseName);
		
		for(int i = 0; i < courseName.size(); i++) {
			for(int a = 0; a < unsortedCourses.size(); a++) {
				if(courseName.get(i).equals(unsortedCourses.get(a).getCourseName())) {
					sortedCourses.add(unsortedCourses.get(a));
					break;
				}
			}
		}
		
		return sortedCourses;
	}
	
	//Alphabatize by UserName
	private ArrayList<UserInfo> alphabatizeUsers(ArrayList<UserInfo> unsortedUsers){
		ArrayList<UserInfo> sortedUsers = new ArrayList<>();
		
		ArrayList<String> usernames = new ArrayList<>();
		
		for(int i = 0; i < unsortedUsers.size(); i++) {
			usernames.add(unsortedUsers.get(i).getUserName());
		}
		
		java.util.Collections.sort(usernames);
		
		for(int i = 0; i < usernames.size(); i++) {
			for(int a = 0; a < unsortedUsers.size(); a++) {
				if(usernames.get(i).equals(unsortedUsers.get(a).getUserName())) {
					sortedUsers.add(unsortedUsers.get(a));
					break;
				}
			}
		}
		
		return sortedUsers;
	}
	
	
}
