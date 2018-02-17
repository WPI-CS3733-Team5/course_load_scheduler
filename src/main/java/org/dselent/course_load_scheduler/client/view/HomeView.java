package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.HomePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.HomePresenterImpl;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;

public interface HomeView {
	
	public Button getApply();
	
	public void setApply(Button button) ;
	
	public Button getAcceptSchedule();
	
	public void setAcceptSchedule(Button button);
	
	public Button getRequestDifferentSchedule() ;
	
	public void setRequestDifferentSchedule(Button button);
	
	public ListBox getTermDropDown();
	
	public void setTermDropDown(ListBox termDropDown);

	public ListBox getUserDropDown();
	
	public void setUserDropDown(ListBox userDropDown) ;
	
	public ListBox getCalendarList() ;
	
	public void setCalendarList(ListBox calendarList);
	
	public  Widget getWidgetContainer();

	public void setParent(HomePresenterImpl homePresenterImpl);

	public HasWidgets getViewRootPanel();

}
