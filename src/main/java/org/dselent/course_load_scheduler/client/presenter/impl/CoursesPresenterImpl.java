package org.dselent.course_load_scheduler.client.presenter.impl;

import javax.inject.Inject;

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
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.CoursesPresenter;
import org.dselent.course_load_scheduler.client.view.CoursesView;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public class CoursesPresenterImpl extends BasePresenterImpl implements CoursesPresenter {
	
	private CoursesView view;
	private UserInfo user;
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



	@Inject
	public CoursesPresenterImpl(CoursesView view)
	{
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
	public UserInfo getUser() {
		return user;
	}
	
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
		
		if(user.getUserRole() == 1) {
			view.getEditButton().setVisible(false);
			view.getApplyChangesButton().setVisible(false);
			view.getRemoveCourseButton().setVisible(false);
			view.getCreateCourseButton().setVisible(false);
			//view.getSectionTypeTextBox().setVisible(false);
			//view.getMeetingTimesTextBox().setVisible(false);
		}
	}
	
	
	//
	@Override
	public void requestSortCourses(MenuBar departmentMenuBar, MenuBar termMenuBar, Label courseNumberLabel) {
		if(!requestSortCoursesInProgress) {
			
			requestSortCoursesInProgress = true;
			view.getSortButton().setEnabled(false);
			
			String department = departmentMenuBar.getElement().getInnerText();
			String term = termMenuBar.getElement().getInnerText();
			String courseNumber = courseNumberLabel.toString();
			
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
			view.getEditButton().setEnabled(false);
			
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
			view.getApplyChangesButton().setEnabled(false);
			
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
			view.getCancelChangesButton().setEnabled(false);
			
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
			view.getRemoveCourseButton().setEnabled(false);
			
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
			view.getSectionTypeTextBox().setEnabled(false);//TODO
			
			String sectionType = sectionTypeTextBox.getText();
			
			sendSectionType(sectionType);
		}
		
	}
	
	public void sendSectionType(String sectionType){
		
		SendSectionTypeAction ssta = new SendSectionTypeAction(sectionType);
		SendSectionTypeEvent sste = new SendSectionTypeEvent(ssta);
		eventBus.fireEvent(sste);	
		
	}
	
	@Override
	public void requestMeetingTimes(TextBox meetingTimesTextBox){
		if(!requestMeetingTimesInProgress) {
			
			requestMeetingTimesInProgress = true;
			view.getMeetingTimesTextBox().setEnabled(false);//TODO
			
			String meetingTimes = meetingTimesTextBox.getText();
			
			sendMeetingTimes(meetingTimes);
		}
		
	}
	
	public void sendMeetingTimes(String meetingTimes){
		
		SendMeetingTimesAction smta = new SendMeetingTimesAction(meetingTimes);
		SendMeetingTimesEvent smte = new SendMeetingTimesEvent(smta);
		eventBus.fireEvent(smte);	
		
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
		
	}
	
	@Override
	public void requestPopup2StartTime(TextBox popup2StartTimeTextBox){
		if(!requestPopup2StartTimeInProgress) {
			
			requestPopup2StartTimeInProgress = true;
			view.getPopup2StartTimeTextBox().setEnabled(false);//TODO
			
			String startTime = null;			
			
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
			view.getPopup2EndTimeTextBox().setEnabled(false);//TODO
			
			String endTime = null;			
			
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
			view.getPopup2ApplyButton().setEnabled(false);//TODO
			
			String meetingDays = null;
			String meetingTimes = null;
			
				
			
			sendPopup2Apply(meetingTimes, meetingDays);
		}
		
	}
	
	public void sendPopup2Apply(String meetingTimes, String meetingDays){
		
		SendPopup2ApplyAction spaa = new SendPopup2ApplyAction(meetingTimes, meetingDays);
		SendPopup2ApplyEvent spae = new SendPopup2ApplyEvent(spaa);
		eventBus.fireEvent(spae);	
		
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
		
	}
	
	@Override
	public void requestPopup3Apply(RadioButton popup3YesRadio, RadioButton popup3NoRadio){
		if(!requestPopup3ApplyInProgress) {
			
			requestPopup3ApplyInProgress = true;
			view.getPopup3ApplyButton().setEnabled(false);
			
			String apply = null;
			
			if(popup3YesRadio.getValue() == true)
				apply = popup3YesRadio.getText();
			
			if(popup3NoRadio.getValue() == false)
				apply = popup3NoRadio.getText();
			
			
			sendPopup3Apply(apply);
		}
		
	}
	
	public void sendPopup3Apply(String apply){
		
		SendPopup3ApplyAction spaa = new SendPopup3ApplyAction(apply);
		SendPopup3ApplyEvent spae = new SendPopup3ApplyEvent(spaa);
		eventBus.fireEvent(spae);	
		
	}

	@Override
	public void onSendCourses(SendCoursesEvent evt) {
		go(evt.getAction().getPanel());
	}	

}
