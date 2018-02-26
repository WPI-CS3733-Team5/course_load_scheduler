package org.dselent.course_load_scheduler.client.presenter;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public interface CoursesPresenter extends BasePresenter {
	
	public void showPopupPanel1();
	public void hidePopupPanel1();
	public void showPopupPanel2();
	public void hidePopupPanel2();
	public void showPopupPanel3();
	public void hidePopupPanel3();
	
	public void requestSortCourses(ListBox departmentMenuBar, ListBox termMenuBar, TextBox courseNumberTextBox);
	public void requestAddToWishlist(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	public void requestSendEditCourses(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	public void requestApplyChanges(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	public void requestCancelChanges(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	public void requestRemoveCourse(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	public void requestRemoveSelectedFromWishlist(ListBox wishlistListBox);
	public void requestViewFullWishlist(ListBox wishlistListBox);
	public void requestCreateCourse(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	public void requestSectionType(TextBox sectionTypeTextBox);
	public void requestMeetingTimes(TextBox meetingTimesTextBox);
	public void requestPopup1Apply(RadioButton lectureRadioButton, RadioButton labRadioButton, RadioButton specialRadioButton);
	public void requestPopup1Cancel();
	public void requestPopup2StartTime(TextBox popup2StartTimeTextBox);
	public void requestPopup2EndTime(TextBox popup2EndTimeTextBox);
	public void requestPopup2Apply(CheckBox popup2SundayCheckbox, CheckBox popup2MondayCheckbox, CheckBox popup2TuesdayCheckbox, CheckBox popup2WednesdayCheckBox, CheckBox popup2ThursdayCheckbox, CheckBox popup2FridayCheckbox, CheckBox popup2SaturdayCheckbox, TextBox popup2StartTimeTextBox, TextBox popup2EndTimeTextBox);
	public void requestPopup2Cancel();
	public void requestPopup3Apply(RadioButton popup3YesRadio, RadioButton popup3NoRadio);
	
	public void populateCoursesViewer();
	
}
