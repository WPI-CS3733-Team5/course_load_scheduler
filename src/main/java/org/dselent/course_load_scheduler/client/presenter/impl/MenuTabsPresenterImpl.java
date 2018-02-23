package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.SendAccountsAction;
import org.dselent.course_load_scheduler.client.action.SendCoursesAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.action.SendLogoutAction;
import org.dselent.course_load_scheduler.client.action.SendNotificationsAction;
import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.event.SendAccountsEvent;
import org.dselent.course_load_scheduler.client.event.SendCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;
import org.dselent.course_load_scheduler.client.event.SendNotificationsEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistEvent;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import org.dselent.course_load_scheduler.client.view.MenuTabs;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class MenuTabsPresenterImpl extends BasePresenterImpl implements MenuTabsPresenter{
	
	private IndexPresenter parentPresenter;
	private MenuTabs view;
	private HomePresenterImpl home;
	private ProfilePresenterImpl profile;
	private NotificationsPresenterImpl notifications;
	private WishlistPresenterImpl wishlist;
	private CoursesPresenterImpl courses;
	private AccountsPresenterImpl accounts;
	private ScheduleGeneratorPresenterImpl schedules;
	private LoginPresenterImpl login;
	private boolean homeInProgress;
	private boolean profileInProgress;
	private boolean notificationsInProgress;
	private boolean wishlistInProgress;
	private boolean coursesInProgress;
	private boolean accountsInProgress;
	private boolean schedulesInProgress;
	private boolean logoutInProgress;
	
	@Inject
	public MenuTabsPresenterImpl(IndexPresenter parentPresenter, 
			MenuTabs view, 
			HomePresenterImpl home, 
			ProfilePresenterImpl profile,  
			NotificationsPresenterImpl notifications,
			WishlistPresenterImpl wishlist, 
			CoursesPresenterImpl courses,
			AccountsPresenterImpl accounts,
			ScheduleGeneratorPresenterImpl schedules,
			LoginPresenterImpl login)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		this.home = home;
		this.profile = profile;
		this.profile.setMenuTabs(this);
		this.notifications = notifications;
		this.wishlist = wishlist;
		this.courses = courses;
		this.accounts = accounts;
		this.schedules = schedules;
		this.login = login;
		this.login.setMenuTabs(this);
		homeInProgress = false;
		profileInProgress = false;
		notificationsInProgress = false;
		wishlistInProgress = false;
		coursesInProgress = false;
		accountsInProgress = false;
		schedulesInProgress = false;
		logoutInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public void bind()
	{

		
	}

	@Override
	public void go(HasWidgets container) {
		if(parentPresenter.getActiveUser().getUserRole() == 1) {
			view.getAccountsButton().setVisible(false);
			view.getSchedulesButton().setVisible(false);
		}
		view.getUsername().setText(parentPresenter.getActiveUser().getUserName());
		
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public MenuTabs getView() {
		return this.view;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;		
	}

	@Override
	public void home() { 
		if(!homeInProgress)
		{
			homeInProgress = true;
			view.getHomeButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			sendHome();
		}
	}
	
	public void sendHome()
	{
		SendHomeAction sha = new SendHomeAction(view.getViewRootPanel());
		SendHomeEvent she = new SendHomeEvent(sha, home.getView().getViewRootPanel());
		eventBus.fireEvent(she);
	}

	@Override
	public void profile() {
		if(!profileInProgress)
		{
			profileInProgress = true;
			view.getProfileButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendProfile();
		}
	}
	
	private void sendProfile() {
		SendProfileAction spa = new SendProfileAction(view.getViewRootPanel());
		SendProfileEvent spe = new SendProfileEvent(spa, profile.getView().getViewRootPanel());
		eventBus.fireEvent(spe);
	}

	@Override
	public void notifications() {
		if(!notificationsInProgress)
		{
			notificationsInProgress = true;
			view.getNotificationsButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendNotifications();
		}
	}
	
	private void sendNotifications() 
	{
		SendNotificationsAction a = new SendNotificationsAction(view.getViewRootPanel());
		SendNotificationsEvent e = new SendNotificationsEvent(a, notifications.getView().getViewRootPanel());
		eventBus.fireEvent(e);
	}

	@Override
	public void wishlist() {
		if(!wishlistInProgress)
		{
			wishlistInProgress = true;
			view.getWishlistButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendWishlist();
		}
	}
	
	public void sendWishlist() {
		SendWishlistAction swa = new SendWishlistAction(view.getViewRootPanel());
		SendWishlistEvent swe = new SendWishlistEvent(swa, wishlist.getView().getViewRootPanel());
		eventBus.fireEvent(swe);
	}

	@Override
	public void courses() {
		if(!coursesInProgress)
		{
			coursesInProgress = true;
			view.getCoursesButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendCourses();
		}
	}
	
	private void sendCourses()
	{
		SendCoursesAction sca = new SendCoursesAction(view.getViewRootPanel());
		SendCoursesEvent sce = new SendCoursesEvent(sca, courses.getView().getViewRootPanel());
		eventBus.fireEvent(sce);
	}

	@Override
	public void accounts() {
		if(!accountsInProgress)
		{
			accountsInProgress = true;
			view.getAccountsButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendAccounts();
		}
	}
	
	private void sendAccounts()
	{
		SendAccountsAction saa = new SendAccountsAction(view.getViewRootPanel());
		SendAccountsEvent sae = new SendAccountsEvent(saa, accounts.getView().getViewRootPanel());
		eventBus.fireEvent(sae);
	}

	@Override
	public void schedules() {
		if(!schedulesInProgress)
		{
			schedulesInProgress = true;
			view.getSchedulesButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendSchedules();
		}
	}
	
	private void sendSchedules()
	{
		SendSchedulesAction ssa = new SendSchedulesAction(view.getViewRootPanel());
		SendSchedulesEvent sse = new SendSchedulesEvent(ssa, schedules.getView().getViewRootPanel());
		eventBus.fireEvent(sse);
	}

	@Override
	public void logout() {
		if(!logoutInProgress)
		{
			logoutInProgress = true;
			view.getLogoutButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendLogout();
		}
	}
	
	private void sendLogout() {
		this.parentPresenter.setActiveUserState(0);
		SendLogoutAction sla = new SendLogoutAction(view.getViewRootPanel());
		SendLogoutEvent sle = new SendLogoutEvent(sla, login.getView().getViewRootPanel());
		eventBus.fireEvent(sle);
	}		
}
