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
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.MenuTabs;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class MenuTabsPresenterImpl extends BasePresenterImpl implements MenuTabsPresenter{
	
	private IndexPresenter parentPresenter;
	private MenuTabs view;
	private int userID;
	private boolean homeInProgress;
	private boolean profileInProgress;
	private boolean notificationsInProgress;
	private boolean wishlistInProgress;
	private boolean coursesInProgress;
	private boolean accountsInProgress;
	private boolean schedulesInProgress;
	private boolean logoutInProgress;

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public BaseView<? extends BasePresenter> getView() {
		return (BaseView<? extends BasePresenter>) this.view;
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
		SendHomeAction sha = new SendHomeAction();
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
		SendProfileAction spa = new SendProfileAction();
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
			SendFetchListAction sfla = new SendFetchListAction(userID);
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
		SendWishlistAction swa = new SendWishlistAction();
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
		SendAccountsAction saa = new SendAccountsAction();
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
		SendSchedulesAction ssa = new SendSchedulesAction();
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
		SendLogoutAction sla = new SendLogoutAction();
		SendLogoutEvent sle = new SendLogoutEvent(sla);
		eventBus.fireEvent(sle);
	}

}
