package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.NotificationsPresenter;
import org.dselent.course_load_scheduler.client.presenter.WishlistPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.WishlistPresenterImpl;

//import org.dselent.course_load_scheduler.client.presenter.WishlistPresenter;
import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.ListBox;

public interface WishlistView extends BaseView<WishlistPresenter>{
	
	//radio buttons
	public RadioButton getSortDeptRadioButton();
	public void setSortDeptRadioButton(RadioButton sortDeptRadioButton);
	
	public RadioButton getSortTermRadioButton();
	public void setSortTermRadioButton(RadioButton sortTermRadioButton);
	
	public RadioButton getSortCourseNumberRadioButton();
	public void setSortCourseNumberRadioButton(RadioButton sortTermCourseNumberRadioButton);
	
	//List Boxes
	public ListBox getDeptCmbx();
	public void setDeptCmbx(ListBox deptCmbx);
	
	public ListBox getTermCmbx();
	public void setTermCmbx(ListBox termCmbx);
	
	public ListBox getCourseNumberCmbx();
	public void setCourseNumberCmbx(ListBox courseNumberCmbx);
	
	public ListBox getCourseListBox();
	public void setCourseListBox(ListBox courseListBox);
	
	public ListBox getTimesListBox();
	public void setTimesListBox(ListBox timesListBox);
	
	public ListBox getLocationListBox();
	public void setLocationListBox(ListBox locationListBox);
	
	public ListBox getTermListBox();
	public void setTermListBox(ListBox termListBox);
	
	public void setParent(WishlistPresenterImpl wishlistPresenterImpl);
	
	//Buttons. The "String errorMessage" may need to be changed to more appropriate names
	public Button getSortButton();
	public void showSortButtonErrorMessage(String INVALID_SEARCH_BUTTON);
	
	public Button getViewCourseDetailsButton();
	public void showViewCourseDetailsButtonErrorMessage(String VIEW_COURSE_DETAILS_BUTTON);
	
	public Button getEditWishlistButton();
	void showEditWishlistButtonErrorMessage(String EDIT_WISHLISTBUTTON);
	
	public Button getRequestNewScheduleButton();
	public void showRequestNewScheduleButton(String REQUEST_NEW_SCHEDULE_BUTOTN);
	
	Widget getWidgetContainer();
	
}

















