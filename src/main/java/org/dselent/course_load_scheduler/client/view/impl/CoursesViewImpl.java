package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.CoursesPresenter;
import org.dselent.course_load_scheduler.client.view.CoursesView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.CheckBox;

public class CoursesViewImpl  extends BaseViewImpl<CoursesPresenter> implements CoursesView {
	
	private static CoursesViewImplUiBinder uiBinder = GWT.create(CoursesViewImplUiBinder.class);

	interface CoursesViewImplUiBinder extends UiBinder<Widget, CoursesViewImpl> {
	}
	
	@UiField HTMLPanel mainPanel;
	@UiField Label sortByLabel;
	@UiField RadioButton departmentRadioButton;
	@UiField MenuBar departmentMenuBar;
	@UiField MenuItem departmentMenuItem;
	@UiField MenuItem CSMenuItem;
	@UiField MenuItem ECEMenuItem;
	@UiField MenuItem IMGDMenuItem;
	@UiField MenuItem RBEMenuItem;
	@UiField MenuItem MAMenuItem;
	@UiField RadioButton termRadioButton;
	@UiField MenuBar termMenuBar;
	@UiField MenuItem termMenuItem;
	@UiField MenuItem termA;
	@UiField MenuItem termB;
	@UiField MenuItem termC;
	@UiField MenuItem termD;
	@UiField MenuItem termE1;
	@UiField MenuItem termE2;
	@UiField RadioButton courseNumberRadioButton;
	@UiField Label courseNumberLabel;
	@UiField Button sortButton;
	@UiField ListBox coursesListBox;
	@UiField Label wishlistLabel;
	@UiField ListBox wishlistListbox;
	@UiField Button createCourseButton;
	@UiField Button removeSelectedFromWishlistButton;
	@UiField Button viewFullWishlistButton;
	@UiField Label departmentLabel;
	@UiField TextBox departmentTextBox;
	@UiField Label courseNumberSideLabel;
	@UiField TextBox courseNumberSideTextBox;
	@UiField Label courseSectionLabel;
	@UiField TextBox courseSectionTextBox;
	@UiField Label sectionTypeLabel;
	@UiField TextBox sectionTypeTextBox;
	@UiField Label termLabel;
	@UiField TextBox termTextBox;
	@UiField Label meetingTimesLabel;
	@UiField TextBox meetingTimesTextBox;
	@UiField Label locationLabel;
	@UiField TextBox locationTextBox;
	@UiField Button addToWishlistButton;
	@UiField Button editButton;
	@UiField Button applyChangesButton;
	@UiField Button cancelChangesButton;
	@UiField Button removeCourseButton;
	
	@UiField PopupPanel popupPanel1;
	@UiField Label popup1SortByLabel;
	@UiField RadioButton popup1LabRadio;
	@UiField RadioButton popup1LectureRadio;
	@UiField RadioButton popup1SpecialRadio;
	@UiField Button popup1ApplyButton;
	@UiField Button popup1CancelButton;
	
	@UiField PopupPanel popupPanel2;
	@UiField Label popup2SelectMeetingDaysLabel;
	@UiField Label popup2SelectMeetingTimesLabel;
	@UiField CheckBox popup2SundayCheckbox;
	@UiField CheckBox popup2MondayCheckbox;
	@UiField TextBox popup2StartTimeTextBox;
	@UiField CheckBox popup2TuesdayCheckbox;
	@UiField CheckBox popup2WednesdayCheckbox;
	@UiField TextBox popup2EndTimeTextBox;
	@UiField CheckBox popup2ThursdayCheckbox;
	@UiField CheckBox popup2FridayCheckbox;
	@UiField Button popup2ApplyButton;
	@UiField CheckBox popup2SaturdayCheckbox;
	@UiField Button popup2CancelButton;
	
	@UiField PopupPanel popupPanel3;	
	@UiField Label popup3RemoveCourseLabel;
	@UiField RadioButton popup3YesRadio;
	@UiField RadioButton popup3NoRadio;
	@UiField Button popup3ApplyButton;
	
	//getters and setters
	
	public Label getSortByLabel() {
		return sortByLabel;
	}

	public RadioButton getDepartmentRadioButton() {
		return departmentRadioButton;
	}

	public MenuBar getDepartmentMenuBar() {
		return departmentMenuBar;
	}

	public MenuItem getDepartmentMenuItem() {
		return departmentMenuItem;
	}

	public MenuItem getCSMenuItem() {
		return CSMenuItem;
	}

	public MenuItem getECEMenuItem() {
		return ECEMenuItem;
	}

	public MenuItem getIMGDMenuItem() {
		return IMGDMenuItem;
	}

	public MenuItem getRBEMenuItem() {
		return RBEMenuItem;
	}

	public MenuItem getMAMenuItem() {
		return MAMenuItem;
	}

	public RadioButton getTermRadioButton() {
		return termRadioButton;
	}

	public MenuBar getTermMenuBar() {
		return termMenuBar;
	}

	public MenuItem getTermMenuItem() {
		return termMenuItem;
	}

	public MenuItem getTermA() {
		return termA;
	}

	public MenuItem getTermB() {
		return termB;
	}

	public MenuItem getTermC() {
		return termC;
	}

	public MenuItem getTermD() {
		return termD;
	}

	public MenuItem getTermE1() {
		return termE1;
	}

	public MenuItem getTermE2() {
		return termE2;
	}

	public RadioButton getCourseNumberRadioButton() {
		return courseNumberRadioButton;
	}

	public Label getCourseNumberLabel() {
		return courseNumberLabel;
	}

	public Button getSortButton() {
		return sortButton;
	}

	public ListBox getCoursesListBox() {
		return coursesListBox;
	}

	public Label getWishlistLabel() {
		return wishlistLabel;
	}

	public ListBox getWishlistListbox() {
		return wishlistListbox;
	}

	public Button getCreateCourseButton() {
		return createCourseButton;
	}

	public Button getRemoveSelectedFromWishlistButton() {
		return removeSelectedFromWishlistButton;
	}

	public Button getViewFullWishlistButton() {
		return viewFullWishlistButton;
	}

	public Label getDepartmentLabel() {
		return departmentLabel;
	}

	public TextBox getDepartmentTextBox() {
		return departmentTextBox;
	}

	public Label getCourseNumberSideLabel() {
		return courseNumberSideLabel;
	}

	public TextBox getCourseNumberSideTextBox() {
		return courseNumberSideTextBox;
	}

	public Label getCourseSectionLabel() {
		return courseSectionLabel;
	}

	public TextBox getCourseSectionTextBox() {
		return courseSectionTextBox;
	}

	public Label getSectionTypeLabel() {
		return sectionTypeLabel;
	}

	public TextBox getSectionTypeTextBox() {
		return sectionTypeTextBox;
	}

	public Label getTermLabel() {
		return termLabel;
	}

	public TextBox getTermTextBox() {
		return termTextBox;
	}

	public Label getMeetingTimesLabel() {
		return meetingTimesLabel;
	}

	public TextBox getMeetingTimesTextBox() {
		return meetingTimesTextBox;
	}

	public Label getLocationLabel() {
		return locationLabel;
	}

	public TextBox getLocationTextBox() {
		return locationTextBox;
	}

	public Button getAddToWishlistButton() {
		return addToWishlistButton;
	}

	public Button getEditButton() {
		return editButton;
	}

	public Button getApplyChangesButton() {
		return applyChangesButton;
	}

	public Button getCancelChangesButton() {
		return cancelChangesButton;
	}

	public Button getRemoveCourseButton() {
		return removeCourseButton;
	}

	public void setDepartmentRadioButton(RadioButton departmentRadioButton) {
		this.departmentRadioButton = departmentRadioButton;
	}

	public void setDepartmentMenuBar(MenuBar departmentMenuBar) {
		this.departmentMenuBar = departmentMenuBar;
	}

	public void setDepartmentMenuItem(MenuItem departmentMenuItem) {
		this.departmentMenuItem = departmentMenuItem;
	}

	public void setCSMenuItem(MenuItem cSMenuItem) {
		CSMenuItem = cSMenuItem;
	}

	public void setECEMenuItem(MenuItem eCEMenuItem) {
		ECEMenuItem = eCEMenuItem;
	}

	public void setIMGDMenuItem(MenuItem iMGDMenuItem) {
		IMGDMenuItem = iMGDMenuItem;
	}

	public void setRBEMenuItem(MenuItem rBEMenuItem) {
		RBEMenuItem = rBEMenuItem;
	}

	public void setMAMenuItem(MenuItem mAMenuItem) {
		MAMenuItem = mAMenuItem;
	}

	public void setTermRadioButton(RadioButton termRadioButton) {
		this.termRadioButton = termRadioButton;
	}

	public void setTermMenuBar(MenuBar termMenuBar) {
		this.termMenuBar = termMenuBar;
	}

	public void setTermMenuItem(MenuItem termMenuItem) {
		this.termMenuItem = termMenuItem;
	}

	public void setTermA(MenuItem termA) {
		this.termA = termA;
	}

	public void setTermB(MenuItem termB) {
		this.termB = termB;
	}

	public void setTermC(MenuItem termC) {
		this.termC = termC;
	}

	public void setTermD(MenuItem termD) {
		this.termD = termD;
	}

	public void setTermE1(MenuItem termE1) {
		this.termE1 = termE1;
	}

	public void setTermE2(MenuItem termE2) {
		this.termE2 = termE2;
	}

	public void setCourseNumberRadioButton(RadioButton courseNumberRadioButton) {
		this.courseNumberRadioButton = courseNumberRadioButton;
	}

	public void setSortButton(Button sortButton) {
		this.sortButton = sortButton;
	}

	public void setCoursesListBox(ListBox coursesListBox) {
		this.coursesListBox = coursesListBox;
	}

	public void setWishlistListbox(ListBox wishlistListbox) {
		this.wishlistListbox = wishlistListbox;
	}

	public void setCreateCourseButton(Button createCourseButton) {
		this.createCourseButton = createCourseButton;
	}

	public void setRemoveSelectedFromWishlistButton(Button removeSelectedFromWishlistButton) {
		this.removeSelectedFromWishlistButton = removeSelectedFromWishlistButton;
	}

	public void setViewFullWishlistButton(Button viewFullWishlistButton) {
		this.viewFullWishlistButton = viewFullWishlistButton;
	}

	public void setDepartmentTextBox(TextBox departmentTextBox) {
		this.departmentTextBox = departmentTextBox;
	}

	public void setCourseNumberSideTextBox(TextBox courseNumberSideTextBox) {
		this.courseNumberSideTextBox = courseNumberSideTextBox;
	}

	public void setCourseSectionTextBox(TextBox courseSectionTextBox) {
		this.courseSectionTextBox = courseSectionTextBox;
	}

	public void setSectionTypeTextBox(TextBox sectionTypeTextBox) {
		this.sectionTypeTextBox = sectionTypeTextBox;
	}

	public void setTermTextBox(TextBox termTextBox) {
		this.termTextBox = termTextBox;
	}

	public void setMeetingTimesTextBox(TextBox meetingTimesTextBox) {
		this.meetingTimesTextBox = meetingTimesTextBox;
	}

	public void setLocationTextBox(TextBox locationTextBox) {
		this.locationTextBox = locationTextBox;
	}

	public void setAddToWishlistButton(Button addToWishlistButton) {
		this.addToWishlistButton = addToWishlistButton;
	}

	public void setEditButton(Button editButton) {
		this.editButton = editButton;
	}

	public void setApplyChangesButton(Button applyChangesButton) {
		this.applyChangesButton = applyChangesButton;
	}

	public void setCancelChangesButton(Button cancelChangesButton) {
		this.cancelChangesButton = cancelChangesButton;
	}

	public void setRemoveCourseButton(Button removeCourseButton) {
		this.removeCourseButton = removeCourseButton;
	}
	
	
	//

	public Label getPopup1SortByLabel() {
		return popup1SortByLabel;
	}

	public RadioButton getPopup1LabRadio() {
		return popup1LabRadio;
	}

	public RadioButton getPopup1LectureRadio() {
		return popup1LectureRadio;
	}

	public RadioButton getPopup1SpecialRadio() {
		return popup1SpecialRadio;
	}

	public Button getPopup1ApplyButton() {
		return popup1ApplyButton;
	}

	public Button getPopup1CancelButton() {
		return popup1CancelButton;
	}

	public Label getPopup2SelectMeetingDaysLabel() {
		return popup2SelectMeetingDaysLabel;
	}

	public Label getPopup2SelectMeetingTimesLabel() {
		return popup2SelectMeetingTimesLabel;
	}

	public CheckBox getPopup2SundayCheckbox() {
		return popup2SundayCheckbox;
	}

	public CheckBox getPopup2MondayCheckbox() {
		return popup2MondayCheckbox;
	}

	public TextBox getPopup2StartTimeTextBox() {
		return popup2StartTimeTextBox;
	}

	public CheckBox getPopup2TuesdayCheckbox() {
		return popup2TuesdayCheckbox;
	}

	public CheckBox getPopup2WednesdayCheckbox() {
		return popup2WednesdayCheckbox;
	}

	public TextBox getPopup2EndTimeTextBox() {
		return popup2EndTimeTextBox;
	}

	public CheckBox getPopup2ThursdayCheckbox() {
		return popup2ThursdayCheckbox;
	}

	public CheckBox getPopup2FridayCheckbox() {
		return popup2FridayCheckbox;
	}

	public Button getPopup2ApplyButton() {
		return popup2ApplyButton;
	}

	public CheckBox getPopup2SaturdayCheckbox() {
		return popup2SaturdayCheckbox;
	}

	public Button getPopup2CancelButton() {
		return popup2CancelButton;
	}

	public Label getPopup3RemoveCourseLabel() {
		return popup3RemoveCourseLabel;
	}

	public RadioButton getPopup3YesRadio() {
		return popup3YesRadio;
	}

	public RadioButton getPopup3NoRadio() {
		return popup3NoRadio;
	}

	public Button getPopup3ApplyButton() {
		return popup3ApplyButton;
	}

	public void setPopup1LabRadio(RadioButton popup1LabRadio) {
		this.popup1LabRadio = popup1LabRadio;
	}

	public void setPopup1LectureRadio(RadioButton popup1LectureRadio) {
		this.popup1LectureRadio = popup1LectureRadio;
	}

	public void setPopup1SpecialRadio(RadioButton popup1SpecialRadio) {
		this.popup1SpecialRadio = popup1SpecialRadio;
	}

	public void setPopup1ApplyButton(Button popup1ApplyButton) {
		this.popup1ApplyButton = popup1ApplyButton;
	}

	public void setPopup1CancelButton(Button popup1CancelButton) {
		this.popup1CancelButton = popup1CancelButton;
	}

	public void setPopup2SelectMeetingDaysLabel(Label popup2SelectMeetingDaysLabel) {
		this.popup2SelectMeetingDaysLabel = popup2SelectMeetingDaysLabel;
	}

	public void setPopup2SelectMeetingTimesLabel(Label popup2SelectMeetingTimesLabel) {
		this.popup2SelectMeetingTimesLabel = popup2SelectMeetingTimesLabel;
	}

	public void setPopup2SundayCheckbox(CheckBox popup2SundayCheckbox) {
		this.popup2SundayCheckbox = popup2SundayCheckbox;
	}

	public void setPopup2MondayCheckbox(CheckBox popup2MondayCheckbox) {
		this.popup2MondayCheckbox = popup2MondayCheckbox;
	}

	public void setPopup2StartTimeTextBox(TextBox popup2StartTimeTextBox) {
		this.popup2StartTimeTextBox = popup2StartTimeTextBox;
	}

	public void setPopup2TuesdayCheckbox(CheckBox popup2TuesdayCheckbox) {
		this.popup2TuesdayCheckbox = popup2TuesdayCheckbox;
	}

	public void setPopup2WednesdayCheckbox(CheckBox popup2WednesdayCheckbox) {
		this.popup2WednesdayCheckbox = popup2WednesdayCheckbox;
	}

	public void setPopup2EndTimeTextBox(TextBox popup2EndTimeTextBox) {
		this.popup2EndTimeTextBox = popup2EndTimeTextBox;
	}

	public void setPopup2ThursdayCheckbox(CheckBox popup2ThursdayCheckbox) {
		this.popup2ThursdayCheckbox = popup2ThursdayCheckbox;
	}

	public void setPopup2FridayCheckbox(CheckBox popup2FridayCheckbox) {
		this.popup2FridayCheckbox = popup2FridayCheckbox;
	}

	public void setPopup2ApplyButton(Button popup2ApplyButton) {
		this.popup2ApplyButton = popup2ApplyButton;
	}

	public void setPopup2SaturdayCheckbox(CheckBox popup2SaturdayCheckbox) {
		this.popup2SaturdayCheckbox = popup2SaturdayCheckbox;
	}

	public void setPopup2CancelButton(Button popup2CancelButton) {
		this.popup2CancelButton = popup2CancelButton;
	}

	public void setPopup3YesRadio(RadioButton popup3YesRadio) {
		this.popup3YesRadio = popup3YesRadio;
	}

	public void setPopup3NoRadio(RadioButton popup3NoRadio) {
		this.popup3NoRadio = popup3NoRadio;
	}

	public void setPopup3ApplyButton(Button popup3ApplyButton) {
		this.popup3ApplyButton = popup3ApplyButton;
	}

	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	public HasWidgets getViewRootPanel() {
		
		return mainPanel;
		
	}
	
	
	//end of generic getters and setters
	
	
	public CoursesViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public HTMLPanel getMainPanel()
	{
		return mainPanel;
	}

	@Override
	public void setMainPanel(HTMLPanel mainPanel)
	{
		this.mainPanel = mainPanel;
	}


	@Override
	public void setPresenter(CoursesPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	@Override
	public PopupPanel getPopupPanel1() {
		return popupPanel1;
	}
	
	@Override
	public void setPopupPanel1(PopupPanel popupPanel1) {
		this.popupPanel1 = popupPanel1;
	}

	@Override
	public PopupPanel getPopupPanel2() {
		
		return popupPanel2;
	}
	
	@Override
	public void setPopupPanel2(PopupPanel popupPanel2) {
		
		this.popupPanel2 = popupPanel2;
	}

	@Override
	public PopupPanel getPopupPanel3() {
		
		return popupPanel3;
	}
	
	@Override
	public void setPopupPanel3(PopupPanel popupPanel3) {
		
		this.popupPanel3 = popupPanel3;
	}

}