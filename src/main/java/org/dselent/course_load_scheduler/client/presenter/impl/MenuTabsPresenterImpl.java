package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.SendAccountsAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.action.SendNotificationsAction;
import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.event.ReceiveCoursesEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveHomeEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendAccountsEvent;
import org.dselent.course_load_scheduler.client.event.SendCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendNotificationsEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import org.dselent.course_load_scheduler.client.view.MenuTabs;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class MenuTabsPresenterImpl extends BasePresenterImpl implements MenuTabsPresenter
{
	
	private MenuTabs view;
	
	private IndexPresenter parentPresenter;
	/*private HomePresenter homePresenter;
	private ProfilePresenter profilePresenter;
	private NotificationsPresenter notificationsPresenter;
	private WishlistPresenter wishlistPresenter;
	private CoursesPresenter coursesPresenter;
	private AccountsPresenter accountsPresenter;
	private ScheduleGeneratorPresenter schedulesPresenter;
	private LoginPresenter loginPresenter;
	*/
	
	private boolean homeInProgress;
	private boolean profileInProgress;
	private boolean notificationsInProgress;
	private boolean wishlistInProgress;
	private boolean coursesInProgress;
	private boolean accountsInProgress;
	private boolean schedulesInProgress;
	private boolean logoutInProgress;
	
	private UserInfo activeUser;
	
	@Inject
	public MenuTabsPresenterImpl( 
			MenuTabs view
			/*
			HomePresenter homePresenter, 
			ProfilePresenter profilePresenter,  
			NotificationsPresenter notificationsPresenter,
			WishlistPresenter wishlistPresenter, 
			CoursesPresenter coursesPresenter,
			AccountsPresenter accountsPresenter,
			ScheduleGeneratorPresenter schedulesPresenter,
			LoginPresenter loginPresenter*/)
	{
		this.view = view;
		view.setPresenter(this);
		
		/*
		this.homePresenter = homePresenter;
		this.profilePresenter = profilePresenter;
		this.notificationsPresenter = notificationsPresenter;
		this.wishlistPresenter = wishlistPresenter;
		this.coursesPresenter = coursesPresenter;
		this.accountsPresenter = accountsPresenter;
		this.schedulesPresenter = schedulesPresenter;
		this.loginPresenter = loginPresenter;
		*/
		
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
		GlobalData globalData = Injector.INSTANCE.getGlobalData();
		activeUser = globalData.getActiveUser();
		
		bind();
	}
	
	@Override
	public void bind()
	{
		HandlerRegistration onReceiveHome;
		onReceiveHome = eventBus.addHandler(ReceiveHomeEvent.TYPE,  this);
		eventBusRegistration.put(ReceiveHomeEvent.TYPE, onReceiveHome);
		
		HandlerRegistration login;
		login = eventBus.addHandler(ReceiveLoginEvent.TYPE, this);
		eventBusRegistration.put(ReceiveLoginEvent.TYPE, login);
	}

	@Override
	public void go(HasWidgets container)
	{	
		if(activeUser != null && activeUser.getUserRole() == 1)
		{
			view.getAccountsButton().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
			view.getSchedulesButton().getElement().getStyle().setVisibility(Style.Visibility.HIDDEN);
			view.getUsername().setText(activeUser.getUserName());
		}
				
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public MenuTabs getView()
	{
		return this.view;
	}

	@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;		
	}
	
	/*
	@Override
	public HomePresenter getHomePresenter()
	{
		return homePresenter;
	}

	@Override
	public ProfilePresenter getProfilePresenter()
	{
		return profilePresenter;
	}

	@Override
	public NotificationsPresenter getNotificationsPresenter()
	{
		return notificationsPresenter;
	}

	@Override
	public WishlistPresenter getWishlistPresenter()
	{
		return wishlistPresenter;
	}

	@Override
	public CoursesPresenter getCoursesPresenter()
	{
		return coursesPresenter;
	}

	@Override
	public AccountsPresenter getAccountsPresenter()
	{
		return accountsPresenter;
	}

	@Override
	public ScheduleGeneratorPresenter getSchedulesPresenter()
	{
		return schedulesPresenter;
	}

	@Override
	public LoginPresenter getLoginPresenter()
	{
		return loginPresenter;
	}
	*/

	@Override
	public void home()
	{ 
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
		SendHomeAction sha = new SendHomeAction();
		SendHomeEvent she = new SendHomeEvent(sha, view.getBaseContainer());
		eventBus.fireEvent(she);
	}

	@Override
	public void profile()
	{
		if(!profileInProgress)
		{
			profileInProgress = true;
			view.getProfileButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendProfile();
		}
	}
	
	private void sendProfile()
	{
		SendProfileAction spa = new SendProfileAction(view.getViewRootPanel(), activeUser.getId());
		//TODO
		SendProfileEvent spe = new SendProfileEvent(spa, null/*profilePresenter.getView().getViewRootPanel()*/);
		eventBus.fireEvent(spe);
	}

	@Override
	public void notifications()
	{
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
		//TODO FIX
		SendNotificationsEvent e = new SendNotificationsEvent(a, /*notificationsPresenter.getView().getViewRootPanel()*/null);
		eventBus.fireEvent(e);
	}

	@Override
	public void wishlist()
	{
		if(!wishlistInProgress)
		{
			wishlistInProgress = true;
			view.getWishlistButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendWishlist();
		}
	}
	
	public void sendWishlist()
	{
		SendWishlistAction swa = new SendWishlistAction(view.getViewRootPanel());
		//TODO
		SendWishlistEvent swe = new SendWishlistEvent(swa, /*wishlistPresenter.getView().getViewRootPanel()*/null);
		eventBus.fireEvent(swe);
	}

	@Override
	public void courses()
	{
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
		SendCoursesEvent sce = new SendCoursesEvent(parentPresenter.getView().getMainPanel());
		eventBus.fireEvent(sce);
	}

	@Override
	public void accounts()
	{
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
		//TODO
		SendAccountsEvent sae = new SendAccountsEvent(saa, null/*accountsPresenter.getView().getViewRootPanel()*/);
		eventBus.fireEvent(sae);
	}

	@Override
	public void schedules()
	{
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
		//TODO
		SendSchedulesEvent sse = new SendSchedulesEvent(ssa, null/*schedulesPresenter.getView().getViewRootPanel()*/);
		eventBus.fireEvent(sse);
	}

	@Override
	public void logout()
	{
		if(!logoutInProgress)
		{
			logoutInProgress = true;
			view.getLogoutButton().setEnabled(false);
			parentPresenter.showLoadScreen();

			sendLogout();
		}
	}
	
	private void sendLogout()
	{
		//TODO
		//loginPresenter.onReceiveLogout(view.getViewRootPanel());
	}

	@Override
	public void showLoadScreen()
	{
		parentPresenter.showLoadScreen();
	}

	@Override
	public void hideLoadScreen()
	{
		parentPresenter.hideLoadScreen();
	}
	
	
	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt)
	{
		view.getHomeButton().removeStyleName("gwt-Button");
		view.getHomeButton().setEnabled(false);
		
		view.getProfileButton().setEnabled(true);
		view.getNotificationsButton().setEnabled(true);
		view.getWishlistButton().setEnabled(true);
		view.getCoursesButton().setEnabled(true);
		view.getAccountsButton().setEnabled(true);
		view.getSchedulesButton().setEnabled(true);
	}
	
	@Override
	public void onReceiveHome(ReceiveHomeEvent evt)
	{
		view.getHomeButton().removeStyleName("gwt-Button");
		view.getHomeButton().setEnabled(false);
		
		view.getNotificationsButton().setEnabled(true);
		view.getWishlistButton().setEnabled(true);
		view.getCoursesButton().setEnabled(true);
		view.getAccountsButton().setEnabled(true);
		view.getSchedulesButton().setEnabled(true);
	}
	
	@Override
	public void onReceiveCourses(ReceiveCoursesEvent evt)
	{
		view.getHomeButton().setEnabled(true);
		view.getProfileButton().setEnabled(true);
		view.getNotificationsButton().setEnabled(true);
		view.getWishlistButton().setEnabled(true);
		view.getCoursesButton().setEnabled(false);
		view.getAccountsButton().setEnabled(true);
		view.getSchedulesButton().setEnabled(true);
	}
	
}
