package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.HomePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.HomePresenterImpl;
import org.dselent.course_load_scheduler.client.view.HomeView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;

public class HomeViewImpl extends BaseViewImpl<HomePresenter> implements HomeView{

	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);
	interface HomeViewUiBinder extends UiBinder<Widget, HomeViewImpl> {}
	private HomePresenterImpl parent;

	@UiField ListBox termDropDown;
	@UiField ListBox usernameDropDown;
	@UiField Button apply;
	@UiField Grid calendarGrid;
	@UiField ListBox calendarList;
	@UiField Button acceptSchedule;
	@UiField Button requestDifferentSchedule;
	
	public HomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public Button getApply() {
		return this.apply;
	}
	
	public void setApply(Button button) {
		this.apply = button;
	}
	
	public Button getAcceptSchedule() {
		return this.acceptSchedule;
	}
	
	public void setAcceptSchedule(Button button) {
		this.acceptSchedule = button;
	}
	
	public Button getRequestDifferentSchedule() {
		return this.requestDifferentSchedule;
	}
	
	public void setRequestDifferentSchedule(Button button) {
		this.requestDifferentSchedule = button;
	}
	
	public ListBox getTermDropDown() {
		return this.termDropDown;
	}
	
	public void setTermDropDown(ListBox termDropDown) {
		this.termDropDown = termDropDown;
	}

	public ListBox getUserDropDown() {
		return this.usernameDropDown;
	}
	
	public void setUserDropDown(ListBox userDropDown) {
		this.usernameDropDown = userDropDown;
	}
	
	public ListBox getCalendarList() {
		return this.calendarList;
	}
	
	public void setCalendarList(ListBox calendarList) {
		this.calendarList = calendarList;
	}

	@Override
	public void setPresenter(HomePresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Widget getWidgetContainer() {
		return null;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return null;
	}
	
	@UiHandler("apply")
	void onApplyButtonClicked(ClickEvent evt)
	{
		presenter.applyFilter(this.getTermDropDown(), this.getUserDropDown());
	}
	
	@UiHandler("acceptSchedule")
	void onAcceptScheduleButtonClicked(ClickEvent evt)
	{
		presenter.acceptSchedule(this.getTermDropDown(), this.getUserDropDown());
	}
	
	@UiHandler("requestDifferentSchedule")
	void onRequestDifferentScheduleButtonClicked(ClickEvent evt) {
		presenter.requestDifferentSchedule(this.getTermDropDown(), this.getUserDropDown());
	}

	@Override
	public void setParent(HomePresenterImpl homePresenterImpl) {
		this.parent = homePresenterImpl;
	}
}
