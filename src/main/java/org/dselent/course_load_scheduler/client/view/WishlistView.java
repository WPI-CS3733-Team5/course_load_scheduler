package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.WishlistPresenter;
//import org.dselent.course_load_scheduler.client.presenter.WishlistPresenter;
import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.ListBox;

public interface WishlistView extends BaseView<WishlistPresenter>
{
	
	//radio buttons
	RadioButton getSortDeptRadioButton();
	void setSortDeptRadioButton(RadioButton sortDeptRadioButton);
	
	RadioButton getSortTermRadioButton();
	void setSortTermRadioButton(RadioButton sortTermRadioButton);
	
	RadioButton getSortCourseNumberRadioButton();
	void setSortCourseNumberRadioButton(RadioButton sortTermCourseNumberRadioButton);
	
	//List Boxes
	ListBox getDeptCmbx();
	void setDeptCmbx(ListBox deptCmbx);
	
	ListBox getTermCmbx();
	void setTermCmbx(ListBox termCmbx);
	
	void setSortButton(Button sortButton);
	
	ListBox getCourseNumberCmbx();
	void setCourseNumberCmbx(ListBox courseNumberCmbx);
	
	ListBox getCourseListBox();
	void setCourseListBox(ListBox courseListBox);
	
	ListBox getTimesListBox();
	void setTimesListBox(ListBox timesListBox);
	
	ListBox getLocationListBox();
	void setLocationListBox(ListBox locationListBox);
	
	ListBox getTermListBox();
	void setTermListBox(ListBox termListBox);
		
	//Buttons. The "String errorMessage" may need to be changed to more appropriate names
	Button getSortButton();
	void showSortButtonErrorMessage(String INVALID_SEARCH_BUTTON);
	
	Button getViewCourseDetailsButton();
	void showViewCourseDetailsButtonErrorMessage(String VIEW_COURSE_DETAILS_BUTTON);
	
	Button getEditWishlistButton();
	void showEditWishlistButtonErrorMessage(String EDIT_WISHLISTBUTTON);
	
	Button getRequestNewScheduleButton();
	void showRequestNewScheduleButton(String REQUEST_NEW_SCHEDULE_BUTOTN);
	
	Widget getWidgetContainer();
	
}

















