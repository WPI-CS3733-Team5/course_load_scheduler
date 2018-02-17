package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.MenuTabsPresenterImpl;
import org.dselent.course_load_scheduler.client.view.impl.BaseViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public interface MenuTabs extends BaseView<MenuTabsPresenter>{
		
	public Button getHomeButton();
	
	public void setHomeButton(Button button);
	
	public Button getProfileButton() ;
	
	public void setProfileButton(Button button);
	
	public Button getNotificationsButton();
	
	public void setNotificationsButton(Button button);
	
	public Button getWishlistButton();
	
	public void setWishlistButton(Button button);
	
	public Button getCoursesButton();
	
	public void setCoursesButton(Button button);
	
	public Button getAccountsButton() ;
	
	public void setAccountsButton(Button button);
	
	public Button getSchedulesButton();
	
	public void setShedulesButton(Button button) ;
	
	public Button getLogoutButton();
	
	public void setLogoutButton(Button button);
	
	public void setUsername(Label username);
	
	public Label getUsername();

	public Widget getWidgetContainer();
	
	public HasWidgets getViewRootPanel();

	public void setPresenter(MenuTabsPresenterImpl menuTabsPresenterImpl);
	
	public HTMLPanel getBaseContainer() ;

	public void setBaseContainer(HTMLPanel baseContainer);

}
