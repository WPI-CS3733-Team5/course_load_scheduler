package org.dselent.course_load_scheduler.client.view.impl;
import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.MenuTabsPresenterImpl;
import org.dselent.course_load_scheduler.client.view.MenuTabs;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public class MenuTabsImpl extends BaseViewImpl<MenuTabsPresenter> implements MenuTabs{

	private static MenuTabsUiBinder uiBinder = GWT.create(MenuTabsUiBinder.class);
	interface MenuTabsUiBinder extends UiBinder<Widget, MenuTabsImpl> {}
	private MenuTabsPresenterImpl parent;

	@UiField Grid menuGrid;
	@UiField Button homeButton;
	@UiField Button profileButton;
	@UiField Button notificationsButton;
	@UiField Button wishlistButton;
	@UiField Button coursesButton;
	@UiField Button accountsButton;
	@UiField Button schedulesButton;
	@UiField Label username;
	@UiField Button logoutButton;

	public MenuTabsImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public Button getHomeButton() {
		return this.homeButton;
	}
	
	public void setHomeButton(Button button) {
		this.homeButton = button;
	}
	
	public Button getProfileButton() {
		return this.profileButton;
	}
	
	public void setProfileButton(Button button) {
		this.profileButton = button;
	}
	
	public Button getNotificationsButton() {
		return this.notificationsButton;
	}
	
	public void setNotificationsButton(Button button) {
		this.notificationsButton = button;
	}
	
	public Button getWishlistButton() {
		return this.wishlistButton;
	}
	
	public void setWishlistButton(Button button) {
		this.wishlistButton = button;
	}
	
	public Button getCoursesButton() {
		return this.homeButton;
	}
	
	public void setCoursesButton(Button button) {
		this.coursesButton = button;
	}
	
	public Button getAccountsButton() {
		return this.accountsButton;
	}
	
	public void setAccountsButton(Button button) {
		this.accountsButton = button;
	}
	
	public Button getSchedulesButton() {
		return this.schedulesButton;
	}
	
	public void setShedulesButton(Button button) {
		this.schedulesButton = button;
	}
	
	public Button getLogoutButton() {
		return this.logoutButton;
	}
	
	public void setLogoutButton(Button button) {
		this.logoutButton = button;
	}
	
	public void setUsername(Label username) {
		this.username = username;
	}
	
	public Label getUsername() {
		return this.username;
	}

	@Override
	public void setPresenter(MenuTabsPresenter presenter) {
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

}
