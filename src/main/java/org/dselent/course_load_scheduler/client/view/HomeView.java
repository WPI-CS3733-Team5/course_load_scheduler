package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.HomePresenter;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public interface HomeView extends BaseView<HomePresenter>
{
	Widget getWidgetContainer();
	HasWidgets getViewRootPanel();
	Button getApply();
	void setApply(Button button) ;
	Button getAcceptSchedule();
	void setAcceptSchedule(Button button);
	Button getRequestDifferentSchedule() ;
	void setRequestDifferentSchedule(Button button);
	ListBox getTermDropDown();
	void setTermDropDown(ListBox termDropDown);
	ListBox getUserDropDown();
	void setUserDropDown(ListBox userDropDown) ;
	ListBox getCalendarList();
	void setCalendarList(ListBox calendarList);
}
