package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAccountsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAccountsEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendAccountsEvent extends GwtEvent<SendAccountsEventHandler>{
	
	public static Type<SendAccountsEventHandler> TYPE = new Type<SendAccountsEventHandler>();
	
	private SendAccountsAction action;
	
	public SendAccountsEvent(SendAccountsAction action)
	{
		this.action = action;
	}
	
	public SendAccountsAction getAction()
	{
		return action;
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
