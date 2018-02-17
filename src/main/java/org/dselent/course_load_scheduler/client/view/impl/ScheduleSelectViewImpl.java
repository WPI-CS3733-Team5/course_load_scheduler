package org.dselent.course_load_scheduler.client.view.impl;

//created by David M.

import org.dselent.course_load_scheduler.client.presenter.ScheduleSelectPresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleSelectView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;

public class ScheduleSelectViewImpl extends BaseViewImpl<ScheduleSelectPresenter> implements ScheduleSelectView{

	private static ScheduleSelectViewImplUiBinder uiBinder = GWT.create(ScheduleSelectViewImplUiBinder.class);
	
	interface ScheduleSelectViewImplUiBinder extends UiBinder<Widget, ScheduleSelectViewImpl> {}
	
	@UiField Grid mainPanel;
	@UiField ListBox scheduleListBox;
	@UiField Label numSchedulesLabel;
	@UiField Grid bottomButtonPanel;
	@UiField Button backButton;
	@UiField Button deleteButton;
	@UiField Button acceptButton;
	@UiField Grid calendarPanel;
	@UiField ListBox courseListBox;
	@UiField Label displayTermLabel;
	@UiField Grid displaySelectPanel;
	@UiField IntegerBox yearBox;
	@UiField ListBox termCombo;


	public ScheduleSelectViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public ListBox getScheduleListBox() {
		return scheduleListBox;
	}

	@Override
	public void setScheduleListBox(ListBox scheduleListBox) {
		this.scheduleListBox = scheduleListBox;
	}

	@Override
	public Button getBackButton() {
		return backButton;
	}

	@Override
	public Button getDeleteButton() {
		return deleteButton;
	}

	@Override
	public Button getAcceptButton() {
		return acceptButton;
	}

	@Override
	public ListBox getCourseListBox() {
		return courseListBox;
	}

	@Override
	public void setCourseListBox(ListBox courseListBox) {
		this.courseListBox = courseListBox;
	}

	@Override
	public IntegerBox getYearBox() {
		return yearBox;
	}

	@Override
	public void setYearBox(IntegerBox yearBox) {
		this.yearBox = yearBox;
	}

	@Override
	public ListBox getTermCombo() {
		return termCombo;
	}

	@Override
	public void setTermCombo(ListBox termCombo) {
		this.termCombo = termCombo;
	}
	
	@Override
	public void setPresenter(ScheduleSelectPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}
	
	//@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	//@Override
	public HasWidgets getViewRootPanel()
	{
		return mainPanel;
	}

}
