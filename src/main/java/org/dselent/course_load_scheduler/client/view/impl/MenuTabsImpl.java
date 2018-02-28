package org.dselent.course_load_scheduler.client.view.impl;
import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import org.dselent.course_load_scheduler.client.view.MenuTabs;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.dom.client.Style;

public class MenuTabsImpl extends BaseViewImpl<MenuTabsPresenter> implements MenuTabs
{
	private static MenuTabsUiBinder uiBinder = GWT.create(MenuTabsUiBinder.class);
	interface MenuTabsUiBinder extends UiBinder<Widget, MenuTabsImpl> {}

	@UiField HTMLPanel rootPanel;
	@UiField Grid menuGrid;
	@UiField HTMLPanel baseContainer;
	@UiField Button homeButton;
	@UiField Button profileButton;
	@UiField Button notificationsButton;
	@UiField Button wishlistButton;
	@UiField Button coursesButton;
	@UiField Button accountsButton;
	@UiField Button schedulesButton;
	@UiField Label username;
	@UiField Button logoutButton;

	public MenuTabsImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
		homeButton.setEnabled(false);
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
	public void setPresenter(MenuTabsPresenter presenter)
	{
		this.presenter = presenter;		
	}

	public HTMLPanel getBaseContainer()
	{
		return baseContainer;
	}

	public void setBaseContainer(HTMLPanel baseContainer)
	{
		this.baseContainer = baseContainer;
	}
	
	
	@Override
	public Button getHomeButton()
	{
		return this.homeButton;
	}
	
	@Override
	public void setHomeButton(Button button)
	{
		this.homeButton = button;
	}
	
	@Override
	public Button getProfileButton()
	{
		return this.profileButton;
	}
	
	@Override
	public void setProfileButton(Button button)
	{
		this.profileButton = button;
	}
	
	@Override
	public Button getNotificationsButton()
	{
		return this.notificationsButton;
	}
	
	@Override
	public void setNotificationsButton(Button button)
	{
		this.notificationsButton = button;
	}
	
	@Override
	public Button getWishlistButton()
	{
		return this.wishlistButton;
	}
	
	@Override
	public void setWishlistButton(Button button)
	{
		this.wishlistButton = button;
	}
	
	@Override
	public Button getCoursesButton()
	{
		return this.homeButton;
	}
	
	@Override
	public void setCoursesButton(Button button)
	{
		this.coursesButton = button;
	}
	
	@Override
	public Button getAccountsButton()
	{
		return this.accountsButton;
	}
	
	@Override
	public void setAccountsButton(Button button)
	{
		this.accountsButton = button;
	}
	
	@Override
	public Button getSchedulesButton()
	{
		return this.schedulesButton;
	}
	
	@Override
	public void setShedulesButton(Button button)
	{
		this.schedulesButton = button;
	}
	
	@Override
	public Button getLogoutButton()
	{
		return this.logoutButton;
	}
	
	@Override
	public void setLogoutButton(Button button)
	{
		this.logoutButton = button;
	}
	
	@Override
	public void setUsername(Label username)
	{
		this.username = username;
	}
	
	@Override
	public Label getUsername()
	{
		return this.username;
	}

	
	@UiHandler("homeButton")
	void onHomeClicked(ClickEvent evt)
	{
		presenter.home();
	}
	
	@UiHandler("profileButton")
	void onProfileClicked(ClickEvent evt)
	{
		presenter.profile();
	}
	
	@UiHandler("notificationsButton")
	void onNotificationsClicked(ClickEvent evt)
	{
		presenter.notifications();
	}
	
	@UiHandler("wishlistButton")
	void onWishlistClicked(ClickEvent evt)
	{
		presenter.wishlist();
	}
	
	@UiHandler("coursesButton")
	void onCoursesClicked(ClickEvent evt)
	{
		presenter.courses();
	}
	
	@UiHandler("accountsButton")
	void onAccountsClicked(ClickEvent evt)
	{
		presenter.accounts();
	}
	
	@UiHandler("schedulesButton")
	void onSchedulesClicked(ClickEvent evt)
	{
		presenter.schedules();
	}
	

}
