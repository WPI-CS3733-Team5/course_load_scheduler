package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAccountsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAccountsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;


public class SendAccountsEvent extends DisplayEvent<SendAccountsEventHandler>
{
	public static Type<SendAccountsEventHandler> TYPE = new Type<SendAccountsEventHandler>();
	
	private SendAccountsAction sendAccountsAction;
	
	public SendAccountsEvent(SendAccountsAction sendAccountsAction, HasWidgets panel)
	{
		super(panel);
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

	public SendAccountsAction getSendAccountsAction()
	{
		return sendAccountsAction;
	}
}

