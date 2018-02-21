package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.SendAccountsAction;
import org.dselent.course_load_scheduler.client.action.SendCoursesAction;
import org.dselent.course_load_scheduler.client.action.SendFetchListAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.action.SendLogoutAction;
import org.dselent.course_load_scheduler.client.action.SendNotificationsAction;
import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.event.DisplayEvent;
import org.dselent.course_load_scheduler.client.event.SendAccountsEvent;
import org.dselent.course_load_scheduler.client.event.SendCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendFetchListEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;
import org.dselent.course_load_scheduler.client.event.SendNotificationsEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistEvent;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.MenuTabs;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class MenuTabsPresenterImpl extends BasePresenterImpl implements MenuTabsPresenter{
	
	private IndexPresenter parentPresenter;
	private MenuTabs view;
	private HomePresenterImpl home;
	private ProfilePresenterImpl profile;
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
		this.wishlist = wishlist;
		this.courses = courses;
		this.accounts = accounts;
		this.schedules = schedules;
		this.login = login;
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
	public void home() { //TODO walk through exact process from button click to home screen being displayed
		if(!homeInProgress)
		{
			homeInProgress = true;
			view.getHomeButton().setEnabled(false);
			sendHome();
		}
	}
	
	private void sendHome()
	{
		SendHomeAction sha = new SendHomeAction(view.getViewRootPanel());
		SendHomeEvent she = new SendHomeEvent(sha, this.home.getView().getViewRootPanel());
		eventBus.fireEvent(she);
	}

	@Override
	public void profile() {
		if(!profileInProgress)
		{
			profileInProgress = true;
			view.getProfileButton().setEnabled(false);
			
			sendProfile();
		}
	}
	
	private void sendProfile() {
		SendProfileAction spa = new SendProfileAction(view.getViewRootPanel());
		SendProfileEvent spe = new SendProfileEvent(spa);
		eventBus.fireEvent(spe);
	}

	@Override
	public void notifications() {
		if(!notificationsInProgress)
		{
			notificationsInProgress = true;
			view.getNotificationsButton().setEnabled(false);
			
			sendNotifications();
		}
	}
	
	private void sendNotifications() 
	{
		SendFetchListAction sfla = new SendFetchListAction(parentPresenter.getActiveUser().getId());
		SendFetchListEvent sfle = new SendFetchListEvent(sfla, this);
		eventBus.fireEvent(sfle);
	}

	@Override
	public void wishlist() {
		if(!wishlistInProgress)
		{
			wishlistInProgress = true;
			view.getWishlistButton().setEnabled(false);
			
			sendWishlist();
		}
	}
	
	private void sendWishlist() {
		SendWishlistAction swa = new SendWishlistAction(view.getViewRootPanel());
		SendWishlistEvent swe = new SendWishlistEvent(swa);
		eventBus.fireEvent(swe);
	}

	@Override
	public void courses() {
		if(!coursesInProgress)
		{
			coursesInProgress = true;
			view.getCoursesButton().setEnabled(false);
			
			sendCourses();
		}
	}
	
	private void sendCourses()
	{
		SendCoursesAction sca = new SendCoursesAction();
		SendCoursesEvent sce = new SendCoursesEvent(sca, view.getViewRootPanel());
		eventBus.fireEvent(sce);
	}

	@Override
	public void accounts() {
		if(!accountsInProgress)
		{
			accountsInProgress = true;
			view.getAccountsButton().setEnabled(false);
			
			sendAccounts();
		}
	}
	
	private void sendAccounts()
	{
		SendAccountsAction saa = new SendAccountsAction();
		SendAccountsEvent sae = new SendAccountsEvent(saa, view.getViewRootPanel());
		eventBus.fireEvent(sae);
	}

	@Override
	public void schedules() {
		if(!schedulesInProgress)
		{
			schedulesInProgress = true;
			view.getSchedulesButton().setEnabled(false);
			
			sendSchedules();
		}
	}
	
	private void sendSchedules()
	{
		SendSchedulesAction ssa = new SendSchedulesAction(view.getViewRootPanel());
		SendSchedulesEvent sse = new SendSchedulesEvent(ssa);
		eventBus.fireEvent(sse);
	}

	@Override
	public void logout() {
		if(!logoutInProgress)
		{
			logoutInProgress = true;
			view.getLogoutButton().setEnabled(false);
			
			sendLogout();
		}
	}
	
	private void sendLogout() {
		SendLogoutAction sla = new SendLogoutAction(view.getViewRootPanel());
		SendLogoutEvent sle = new SendLogoutEvent(sla);
		eventBus.fireEvent(sle);
	}		
}
