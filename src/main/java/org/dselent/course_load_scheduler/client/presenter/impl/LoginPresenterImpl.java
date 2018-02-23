package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLogoutAction;
import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.errorstring.InvalidLoginStrings;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLogoutEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.ActiveUser;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.view.impl.MenuTabsImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class LoginPresenterImpl extends BasePresenterImpl implements LoginPresenter
{
	private IndexPresenter parentPresenter;
	private MenuTabsPresenterImpl menuTabs;
	private LoginView view;
	private boolean loginClickInProgress;

	@Inject
	public LoginPresenterImpl(IndexPresenter parentPresenter, LoginView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		loginClickInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		registration = eventBus.addHandler(InvalidLoginEvent.TYPE, this);
		eventBusRegistration.put(InvalidLoginEvent.TYPE, registration);
	}
		
	@Override
	public void go(HasWidgets container)
	{
		parentPresenter.hideMenuTabs();
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public LoginView getView()
	{
		return view;
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
	
	@Override
	public void setMenuTabs(MenuTabsPresenterImpl menuTabs)
	{
		this.menuTabs = menuTabs;
	}
	
	@Override
	public void login()
	{
		if(!loginClickInProgress)
		{
			loginClickInProgress = true;
			view.getLoginButton().setEnabled(false);
			parentPresenter.showLoadScreen();
			
			String userName = view.getNameTextBox().getText();
			String password = view.getPasswordTextBox().getText();
			
			boolean validUserName = true;
			boolean validPassword = true;

			List<String> invalidReasonList = new ArrayList<>();
			
			try
			{
				validateLoginUserName(userName);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidLoginStrings.NULL_USER_NAME);
				validUserName = false;
			}

			try
			{
				validateLoginPassword(password);
			}
			catch(EmptyStringException e)
			{
				invalidReasonList.add(InvalidLoginStrings.NULL_PASSWORD);
				validPassword = false;
			}
			
			if(validUserName && validPassword)
			{
				sendLogin(userName, password);
			}
			else
			{
				InvalidGenericAction ila = new InvalidGenericAction(invalidReasonList);
				InvalidLoginEvent ile = new InvalidLoginEvent(ila);
				eventBus.fireEvent(ile);
			}
		}
	}
	
	private void sendLogin(String userName, String password)
	{
		HasWidgets container = parentPresenter.getView().getViewRootPanel();
		SendLoginAction sla = new SendLoginAction(userName, password);
		SendLoginEvent sle = new SendLoginEvent(sla, container);
		eventBus.fireEvent(sle);
	}
	
	private void validateLoginUserName(String userName) throws EmptyStringException
	{
		checkEmptyString(userName);
	}
	
	private void validateLoginPassword(String password) throws EmptyStringException
	{
		checkEmptyString(password);
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	/*
	 * Currently only sent by itself
	 * Probably did not need the event bus for this
	 * Useful for example purposes without involving server-side
	*/
	@Override
	public void onInvalidLogin(InvalidLoginEvent evt)
	{
		parentPresenter.hideLoadScreen();
		view.getLoginButton().setEnabled(true);
		loginClickInProgress = false;
		
		InvalidGenericAction ila = evt.getAction();
		view.showErrorMessages(ila.toString());
	}
	
	@Override
	public void onReceiveLogout(ReceiveLogoutEvent evt) {
		HasWidgets container = evt.getContainer();
		ReceiveLogoutAction rha = evt.getAction();
		go(container);
		Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
	}
	
	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt) {
		HasWidgets container = evt.getContainer();
		ReceiveLoginAction rla = evt.getAction();
		UserInfo user = rla.getModel();
		ActiveUser activeUser = new ActiveUser();
		activeUser.setId(user.getId());
		activeUser.setUserRole(user.getUserRole());
		activeUser.setFirstName(user.getFirstName());
		activeUser.setLastName(user.getLastName());
		activeUser.setEmail(user.getEmail());
		activeUser.setAccountState(1);
		parentPresenter.setActiveUser(activeUser);
		menuTabs.sendHome();
	}
}
