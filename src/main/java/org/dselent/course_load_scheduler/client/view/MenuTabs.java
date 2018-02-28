package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public interface MenuTabs extends BaseView<MenuTabsPresenter>
{
	Widget getWidgetContainer();
	HasWidgets getViewRootPanel();
	HTMLPanel getBaseContainer();
	void setBaseContainer(HTMLPanel baseContainer);
	Button getHomeButton();
	void setHomeButton(Button button);
	Button getProfileButton() ;
	void setProfileButton(Button button);
	Button getNotificationsButton();
	void setNotificationsButton(Button button);
	Button getWishlistButton();
	void setWishlistButton(Button button);
	Button getCoursesButton();
	void setCoursesButton(Button button);
	Button getAccountsButton() ;
	void setAccountsButton(Button button);
	Button getSchedulesButton();
	void setShedulesButton(Button button) ;
	Button getLogoutButton();
	void setLogoutButton(Button button);
	void setUsername(Label username);
	Label getUsername();
}
