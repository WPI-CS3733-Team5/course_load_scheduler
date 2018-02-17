package org.dselent.course_load_scheduler.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.ListBox;

public class WishlistViewImpl extends Composite {

	private static WishlistViewUiBinder uiBinder = GWT.create(WishlistViewUiBinder.class);
	
	interface WishlistViewUiBinder extends UiBinder<Widget, WishlistViewImpl> {
	}
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



	public WishlistViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public static WishlistViewUiBinder getUiBinder() {
		return uiBinder;
	}

	public static void setUiBinder(WishlistViewUiBinder uiBinder) {
		WishlistViewImpl.uiBinder = uiBinder;
	}

	public RadioButton getSortDeptRadioButton() {
		return sortDeptRadioButton;
	}

	public void setSortDeptRadioButton(RadioButton sortDeptRadioButton) {
		this.sortDeptRadioButton = sortDeptRadioButton;
	}

	public ListBox getDeptCmbx() {
		return deptCmbx;
	}

	public void setDeptCmbx(ListBox deptCmbx) {
		this.deptCmbx = deptCmbx;
	}

	public RadioButton getSortTermRadioButton() {
		return sortTermRadioButton;
	}

	public void setSortTermRadioButton(RadioButton sortTermRadioButton) {
		this.sortTermRadioButton = sortTermRadioButton;
	}

	public ListBox getTermCmbx() {
		return termCmbx;
	}

	public void setTermCmbx(ListBox termCmbx) {
		this.termCmbx = termCmbx;
	}

	public RadioButton getSortCourseNumberRadioButton() {
		return sortCourseNumberRadioButton;
	}

	public void setSortCourseNumberRadioButton(RadioButton sortCourseNumberRadioButton) {
		this.sortCourseNumberRadioButton = sortCourseNumberRadioButton;
	}

	public ListBox getCourseNumberCmbx() {
		return courseNumberCmbx;
	}

	public void setCourseNumberCmbx(ListBox courseNumberCmbx) {
		this.courseNumberCmbx = courseNumberCmbx;
	}

	public Button getSortButton() {
		return sortButton;
	}

	public void setSortButton(Button sortButton) {
		this.sortButton = sortButton;
	}

	public ListBox getCourseListBox() {
		return courseListBox;
	}

	public void setCourseListBox(ListBox courseListBox) {
		this.courseListBox = courseListBox;
	}

	public ListBox getTimesListBox() {
		return timesListBox;
	}

	public void setTimesListBox(ListBox timesListBox) {
		this.timesListBox = timesListBox;
	}

	public ListBox getLocationListBox() {
		return locationListBox;
	}

	public void setLocationListBox(ListBox locationListBox) {
		this.locationListBox = locationListBox;
	}

	public ListBox getTermListBox() {
		return termListBox;
	}

	public void setTermListBox(ListBox termListBox) {
		this.termListBox = termListBox;
	}

	public Button getViewCourseDetailsButton() {
		return viewCourseDetailsButton;
	}

	public void setViewCourseDetailsButton(Button viewCourseDetailsButton) {
		this.viewCourseDetailsButton = viewCourseDetailsButton;
	}

	public Button getEditWishlistButton() {
		return editWishlistButton;
	}

	public void setEditWishlistButton(Button editWishlistButton) {
		this.editWishlistButton = editWishlistButton;
	}

	public Button getRequestNewScheduleButton() {
		return requestNewScheduleButton;
	}

	public void setRequestNewScheduleButton(Button requestNewScheduleButton) {
		this.requestNewScheduleButton = requestNewScheduleButton;
	}
	
	
}