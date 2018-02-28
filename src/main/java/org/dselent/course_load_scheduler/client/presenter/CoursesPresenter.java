package org.dselent.course_load_scheduler.client.presenter;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public interface CoursesPresenter extends BasePresenter
{
	
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	void showPopupPanel1();
	void hidePopupPanel1();
	void showPopupPanel2();
	void hidePopupPanel2();
	void showPopupPanel3();
	void hidePopupPanel3();
	
	void requestSortCourses(ListBox departmentMenuBar, ListBox termMenuBar, TextBox courseNumberTextBox);
	void requestAddToWishlist(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	void requestSendEditCourses(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	void requestApplyChanges(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	void requestCancelChanges(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	void requestRemoveCourse(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	void requestRemoveSelectedFromWishlist(ListBox wishlistListBox);
	void requestViewFullWishlist(ListBox wishlistListBox);
	void requestCreateCourse(TextBox departmentTextBox, TextBox courseNumberTextBox, TextBox courseSectionTextBox, TextBox sectionTypeTextBox, TextBox termTextBox, TextBox meetingTimesTextBox, TextBox locationTextBox);
	void requestSectionType(TextBox sectionTypeTextBox);
	void requestMeetingTimes(TextBox meetingTimesTextBox);
	void requestPopup1Apply(RadioButton lectureRadioButton, RadioButton labRadioButton, RadioButton specialRadioButton);
	void requestPopup1Cancel();
	void requestPopup2StartTime(TextBox popup2StartTimeTextBox);
	void requestPopup2EndTime(TextBox popup2EndTimeTextBox);
	void requestPopup2Apply(CheckBox popup2SundayCheckbox, CheckBox popup2MondayCheckbox, CheckBox popup2TuesdayCheckbox, CheckBox popup2WednesdayCheckBox, CheckBox popup2ThursdayCheckbox, CheckBox popup2FridayCheckbox, CheckBox popup2SaturdayCheckbox, TextBox popup2StartTimeTextBox, TextBox popup2EndTimeTextBox);
	void requestPopup2Cancel();
	void requestPopup3Apply(RadioButton popup3YesRadio, RadioButton popup3NoRadio);
	
	void populateCoursesViewer();
	
}
