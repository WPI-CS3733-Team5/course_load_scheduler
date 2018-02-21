package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAccountsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAccountsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;


public class SendAccountsEvent extends DisplayEvent<SendAccountsAction, SendAccountsEventHandler>{
	
	public static Type<SendAccountsEventHandler> TYPE = new Type<SendAccountsEventHandler>();
	
	private SendAccountsAction action;
	
	public SendAccountsEvent(SendAccountsAction action, HasWidgets panel)
	{
		super(action, panel);
	}
	
	@Override
	public Type<SendAccountsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendAccountsEventHandler handler)
	{
		handler.onSendAccounts(this);
	}
}
