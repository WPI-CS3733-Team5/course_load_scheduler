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
	private UserInfo user;
	private boolean homeInProgress;
	private boolean profileInProgress;
	private boolean notificationsInProgress;
	private boolean wishlistInProgress;
	private boolean coursesInProgress;
	private boolean accountsInProgress;
	private boolean schedulesInProgress;
	private boolean logoutInProgress;
	
	@Inject
	public MenuTabsPresenterImpl(IndexPresenter parentPresenter, MenuTabs view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
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
		HandlerRegistration homeRegistration;
		homeRegistration = eventBus.addHandler(SendHomeEvent.TYPE, this);
		eventBusRegistration.put(SendHomeEvent.TYPE, homeRegistration);
		
		HandlerRegistration profileRegistration;
		profileRegistration = eventBus.addHandler(SendProfileEvent.TYPE, this);
		eventBusRegistration.put(SendProfileEvent.TYPE, profileRegistration);
		
		HandlerRegistration notificationsRegistration;
		notificationsRegistration = eventBus.addHandler(SendFetchListEvent.TYPE, this);
		eventBusRegistration.put(SendFetchListEvent.TYPE, notificationsRegistration);
		
		HandlerRegistration wishlistRegistration;
		wishlistRegistration = eventBus.addHandler(SendWishlistEvent.TYPE, this);
		eventBusRegistration.put(SendWishlistEvent.TYPE, wishlistRegistration);
		
		HandlerRegistration coursesRegistration;
		coursesRegistration = eventBus.addHandler(SendCoursesEvent.TYPE, this);
		eventBusRegistration.put(SendCoursesEvent.TYPE, coursesRegistration);
		
		HandlerRegistration accountsRegistration;
		accountsRegistration = eventBus.addHandler(SendAccountsEvent.TYPE, this);
		eventBusRegistration.put(SendAccountsEvent.TYPE, accountsRegistration);
		
		HandlerRegistration schedulesRegistration;
		schedulesRegistration = eventBus.addHandler(SendSchedulesEvent.TYPE, this);
		eventBusRegistration.put(SendSchedulesEvent.TYPE, schedulesRegistration);
		
		HandlerRegistration logoutRegistration;
		logoutRegistration = eventBus.addHandler(SendLogoutEvent.TYPE, this);
		eventBusRegistration.put(SendLogoutEvent.TYPE, logoutRegistration);
	}

	@Override
	public void go(HasWidgets container) {
		if(user.getUserRole() == 1) {
			view.getAccountsButton().setVisible(false);
			view.getSchedulesButton().setVisible(false);
		}
		
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
			sendHome();
		}
	}
	
	private void sendHome()
	{
		SendHomeAction sha = new SendHomeAction(HomePresenterImpl.getView().getViewRootPanel());
		SendHomeEvent she = new SendHomeEvent(sha);
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
		SendProfileAction spa = new SendProfileAction(ProfilePresenterImpl.getView().getViewRootPanel());
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
		SendFetchListAction sfla = new SendFetchListAction(user.getId());
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
		SendWishlistAction swa = new SendWishlistAction(WishlistPresenterImpl.getView().getViewRootPanel());
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
		SendCoursesAction sca = new SendCoursesAction(CoursesPresenterImpl.getView().getViewRootPanel());
		SendCoursesEvent sce = new SendCoursesEvent(sca);
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
		SendAccountsAction saa = new SendAccountsAction(AccountsPresenterImpl.getView().getViewRootPanel());
		SendAccountsEvent sae = new SendAccountsEvent(saa);
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
		SendSchedulesAction ssa = new SendSchedulesAction(SchedulesPresenterImpl.getView().getViewRootPanel());
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
		SendLogoutAction sla = new SendLogoutAction(LoginPresenterImpl.getView().getViewRootPanel());
		SendLogoutEvent sle = new SendLogoutEvent(sla);
		eventBus.fireEvent(sle);
	}
	
	//TODO move to ProfilePresenterImpl
	@Override
	public void onSendProfile(SendProfileEvent evt) {
		go(evt.getAction().getPanel());
	}
	
	//TODO move to NotificationsPresenterImpl
	@Override
	public void onSendNotifications(SendNotificationsEvent evt) {
		go(evt.getAction().getPanel());
	}
	
	//TODO move to WishlistPresenterImpl
	@Override
	public void onSendWishlist(SendWishlistEvent evt) {
		go(evt.getAction().getPanel());
	}
	
	//TODO move to CoursesPresenterImpl
	@Override
	public void onSendCourses(SendCoursesEvent evt) {
		go(evt.getAction().getPanel());
	}
	
	//TODO move to AccountsPresenterImpl
	@Override
	public void onSendAccounts(SendAccountsEvent evt) {
		go(evt.getAction().getPanel());
	}
	
	//TODO move to SchedulesPresenterImpl
	@Override
	public void onSendSchedules(SendSchedulesEvent evt) {
		go(evt.getAction().getPanel());
	}
	
	//TODO move to LoginPresenterImpl
	@Override
	public void onSendLogout(SendLogoutEvent evt) {
		go(evt.getAction().getPanel());
	}
}
