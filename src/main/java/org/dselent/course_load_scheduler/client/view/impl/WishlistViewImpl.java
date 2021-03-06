package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.WishlistPresenter;
import org.dselent.course_load_scheduler.client.view.WishlistView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;


import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;

public class WishlistViewImpl extends BaseViewImpl<WishlistPresenter> implements WishlistView
{

	private static WishlistViewUiBinder uiBinder = GWT.create(WishlistViewUiBinder.class);
	
	interface WishlistViewUiBinder extends UiBinder<Widget, WishlistViewImpl> {}
		
	@UiField HTMLPanel rootPanel;
	@UiField RadioButton sortDeptRadioButton;
	@UiField RadioButton sortTermRadioButton;
	@UiField RadioButton sortCourseNumberRadioButton;
	
	@UiField ListBox deptCmbx;
	@UiField ListBox termCmbx;
	@UiField ListBox courseNumberCmbx;
	@UiField ListBox courseListBox;
	@UiField ListBox timesListBox;
	@UiField ListBox locationListBox;
	@UiField ListBox termListBox;
	
	@UiField Button sortButton;
	@UiField Button viewCourseDetailsButton;
	@UiField Button editWishlistButton;
	@UiField Button requestNewScheduleButton;
	
	@UiField TextBox courseNumber;

	public WishlistViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	@Override
	public HasWidgets getViewRootPanel()
	{
		return rootPanel;
	}
	
	@Override
	public void setPresenter(WishlistPresenter presenter)
	{
		this.presenter = presenter;
		
	}

	@Override
	public RadioButton getSortDeptRadioButton()
	{
		return sortDeptRadioButton;
	}

	@Override
	public void setSortDeptRadioButton(RadioButton sortDeptRadioButton)
	{
		this.sortDeptRadioButton = sortDeptRadioButton;
	}

	@Override
	public ListBox getDeptCmbx()
	{
		return deptCmbx;
	}

	@Override
	public void setDeptCmbx(ListBox deptCmbx)
	{
		this.deptCmbx = deptCmbx;
	}

	@Override
	public RadioButton getSortTermRadioButton()
	{
		return sortTermRadioButton;
	}

	@Override
	public void setSortTermRadioButton(RadioButton sortTermRadioButton)
	{
		this.sortTermRadioButton = sortTermRadioButton;
	}

	@Override
	public ListBox getTermCmbx()
	{
		return termCmbx;
	}

	@Override
	public void setTermCmbx(ListBox termCmbx)
	{
		this.termCmbx = termCmbx;
	}

	@Override
	public RadioButton getSortCourseNumberRadioButton()
	{
		return sortCourseNumberRadioButton;
	}

	@Override
	public void setSortCourseNumberRadioButton(RadioButton sortCourseNumberRadioButton)
	{
		this.sortCourseNumberRadioButton = sortCourseNumberRadioButton;
	}

	@Override
	public ListBox getCourseNumberCmbx()
	{
		return courseNumberCmbx;
	}

	@Override
	public void setCourseNumberCmbx(ListBox courseNumberCmbx)
	{
		this.courseNumberCmbx = courseNumberCmbx;
	}

	@Override
	public Button getSortButton()
	{
		return sortButton;
	}

	@Override
	public void setSortButton(Button sortButton)
	{
		this.sortButton = sortButton;
	}

	@Override
	public ListBox getCourseListBox()
	{
		return courseListBox;
	}

	@Override
	public void setCourseListBox(ListBox courseListBox)
	{
		this.courseListBox = courseListBox;
	}

	public ListBox getTimesListBox()
	{
		return timesListBox;
	}

	public void setTimesListBox(ListBox timesListBox)
	{
		this.timesListBox = timesListBox;
	}

	public ListBox getLocationListBox()
	{
		return locationListBox;
	}

	public void setLocationListBox(ListBox locationListBox)
	{
		this.locationListBox = locationListBox;
	}

	public ListBox getTermListBox()
	{
		return termListBox;
	}

	public void setTermListBox(ListBox termListBox)
	{
		this.termListBox = termListBox;
	}

	public Button getViewCourseDetailsButton()
	{
		return viewCourseDetailsButton;
	}

	public void setViewCourseDetailsButton(Button viewCourseDetailsButton)
	{
		this.viewCourseDetailsButton = viewCourseDetailsButton;
	}

	public Button getEditWishlistButton()
	{
		return editWishlistButton;
	}

	public void setEditWishlistButton(Button editWishlistButton)
	{
		this.editWishlistButton = editWishlistButton;
	}

	public Button getRequestNewScheduleButton()
	{
		return requestNewScheduleButton;
	}

	public void setRequestNewScheduleButton(Button requestNewScheduleButton)
	{

		this.requestNewScheduleButton = requestNewScheduleButton;
	}
	
	public TextBox getCourseNumberTextBox()
	{
		
		return courseNumber;
		
	}
	
	public void setCourseNumberTextBox(TextBox courseNumberTextBox)
	{
		
		this.courseNumber = courseNumberTextBox;
		
	}
	
	
	//////////

	@Override
	public void showSortButtonErrorMessage(String INVALID_SEARCH_BUTTON)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showViewCourseDetailsButtonErrorMessage(String VIEW_COURSE_DETAILS_BUTTON)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showEditWishlistButtonErrorMessage(String EDIT_WISHLISTBUTTON)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void sortButtonClicked(ClickEvent evt)
	{
		presenter.sort(getSortTermRadioButton(), getCourseListBox(), getTermListBox(), getCourseNumberTextBox());
	}
	
	public void viewCourseDetailsButton(ClickEvent evt)
	{
		presenter.viewCourseDetails(getCourseListBox());
	}
	
	public void editWishlist()
	{
		presenter.editWishlist();
	}
	
	public void requestNewScheduleButton(ClickEvent evt)
	{
		presenter.requestNewSchedule();
	}

	@Override
	public void showRequestNewScheduleButton(String REQUEST_NEW_SCHEDULE_BUTOTN)
	{
		presenter.requestNewSchedule();
	}	
}
