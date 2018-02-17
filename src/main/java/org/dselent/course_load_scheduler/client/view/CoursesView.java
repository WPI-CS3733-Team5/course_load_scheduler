package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.CoursesPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public interface CoursesView extends BaseView<CoursesPresenter> {

	public HTMLPanel getMainPanel();
	public void setMainPanel(HTMLPanel mainPanel);
	public Label getSortByLabel();
	public RadioButton getDepartmentRadioButton();
	public MenuBar getDepartmentMenuBar();
	public MenuItem getDepartmentMenuItem();
	public MenuItem getCSMenuItem();
	public MenuItem getECEMenuItem();
	public MenuItem getIMGDMenuItem();
	public MenuItem getRBEMenuItem();
	public MenuItem getMAMenuItem();
	public RadioButton getTermRadioButton();
	public MenuBar getTermMenuBar();
	public MenuItem getTermMenuItem();
	public MenuItem getTermA();
	public MenuItem getTermB();
	public MenuItem getTermC();
	public MenuItem getTermD();
	public MenuItem getTermE1();
	public MenuItem getTermE2();
	public RadioButton getCourseNumberRadioButton();
	public Label getCourseNumberLabel();
	public Button getSortButton();
	public ListBox getCoursesListBox();
	public Label getWishlistLabel();
	public ListBox getWishlistListbox();
	public Button getCreateCourseButton();
	public Button getRemoveSelectedFromWishlistButton();
	public Button getViewFullWishlistButton();
	public Label getDepartmentLabel();
	public TextBox getDepartmentTextBox();
	public Label getCourseNumberSideLabel();
	public TextBox getCourseNumberSideTextBox();
	public Label getCourseSectionLabel();
	public TextBox getCourseSectionTextBox();
	public Label getSectionTypeLabel();
	public TextBox getSectionTypeTextBox();
	public Label getTermLabel();
	public TextBox getTermTextBox();
	public Label getMeetingTimesLabel();
	public TextBox getMeetingTimesTextBox();
	public Label getLocationLabel();
	public TextBox getLocationTextBox();
	public Button getAddToWishlistButton();
	public Button getEditButton();
	public Button getApplyChangesButton();
	public Button getCancelChangesButton();
	public Button getRemoveCourseButton();

	public PopupPanel getPopupPanel1();
	public void setPopupPanel1(PopupPanel popupPanel1);
	public Label getPopup1SortByLabel();
	public RadioButton getPopup1LabRadio();
	public RadioButton getPopup1LectureRadio();
	public RadioButton getPopup1SpecialRadio();
	public Button getPopup1ApplyButton();
	public Button getPopup1CancelButton();

	public PopupPanel getPopupPanel2();
	public void setPopupPanel2(PopupPanel popupPanel2);
	public Label getPopup2SelectMeetingDaysLabel();
	public Label getPopup2SelectMeetingTimesLabel();
	public CheckBox getPopup2SundayCheckbox();
	public CheckBox getPopup2MondayCheckbox();
	public TextBox getPopup2StartTimeTextBox();
	public CheckBox getPopup2TuesdayCheckbox();
	public CheckBox getPopup2WednesdayCheckbox();
	public TextBox getPopup2EndTimeTextBox();
	public CheckBox getPopup2ThursdayCheckbox();
	public CheckBox getPopup2FridayCheckbox();
	public Button getPopup2ApplyButton();
	public CheckBox getPopup2SaturdayCheckbox();
	public Button getPopup2CancelButton();
	
	public PopupPanel getPopupPanel3();
	public void setPopupPanel3(PopupPanel popupPanel3);
	public Label getPopup3RemoveCourseLabel();
	public RadioButton getPopup3YesRadio();
	public RadioButton getPopup3NoRadio();
	public Button getPopup3ApplyButton();


}
