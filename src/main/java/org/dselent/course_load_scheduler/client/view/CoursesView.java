package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.CoursesPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public interface CoursesView extends BaseView<CoursesPresenter>
{
	HTMLPanel getMainPanel();
	void setMainPanel(HTMLPanel mainPanel);
	Label getSortByLabel();
	RadioButton getDepartmentRadioButton();
	ListBox getDepartmentDropDown();
	RadioButton getTermRadioButton();
	ListBox getTermDropDown();
	RadioButton getCourseNumberRadioButton();
	TextBox getCourseNumberTextBox();
	Button getSortButton();
	ListBox getCoursesListBox();
	Label getWishlistLabel();
	ListBox getWishlistListbox();
	Button getCreateCourseButton();
	Button getRemoveSelectedFromWishlistButton();
	Button getViewFullWishlistButton();
	Label getDepartmentLabel();
	TextBox getDepartmentTextBox();
	Label getCourseNumberSideLabel();
	TextBox getCourseNumberSideTextBox();
	Label getCourseSectionLabel();
	TextBox getCourseSectionTextBox();
	Label getSectionTypeLabel();
	TextBox getSectionTypeTextBox();
	Label getTermLabel();
	TextBox getTermTextBox();
	Label getMeetingTimesLabel();
	TextBox getMeetingTimesTextBox();
	Label getLocationLabel();
	TextBox getLocationTextBox();
	Button getAddToWishlistButton();
	Button getEditButton();
	Button getApplyChangesButton();
	Button getCancelChangesButton();
	Button getRemoveCourseButton();

	PopupPanel getPopupPanel1();
	void setPopupPanel1(PopupPanel popupPanel1);
	Label getPopup1SortByLabel();
	RadioButton getPopup1LabRadio();
	RadioButton getPopup1LectureRadio();
	RadioButton getPopup1SpecialRadio();
	Button getPopup1ApplyButton();
	Button getPopup1CancelButton();

	PopupPanel getPopupPanel2();
	void setPopupPanel2(PopupPanel popupPanel2);
	Label getPopup2SelectMeetingDaysLabel();
	Label getPopup2SelectMeetingTimesLabel();
	CheckBox getPopup2SundayCheckbox();
	CheckBox getPopup2MondayCheckbox();
	TextBox getPopup2StartTimeTextBox();
	CheckBox getPopup2TuesdayCheckbox();
	CheckBox getPopup2WednesdayCheckbox();
	TextBox getPopup2EndTimeTextBox();
	CheckBox getPopup2ThursdayCheckbox();
	CheckBox getPopup2FridayCheckbox();
	Button getPopup2ApplyButton();
	CheckBox getPopup2SaturdayCheckbox();
	Button getPopup2CancelButton();
	
	PopupPanel getPopupPanel3();
	void setPopupPanel3(PopupPanel popupPanel3);
	Label getPopup3RemoveCourseLabel();
	RadioButton getPopup3YesRadio();
	RadioButton getPopup3NoRadio();
	Button getPopup3ApplyButton();

}
