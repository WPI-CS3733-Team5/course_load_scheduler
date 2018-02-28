package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveAccountsAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveAccountsEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveAccountsEvent extends DisplayEvent<ReceiveAccountsEventHandler>
{
	public static Type<ReceiveAccountsEventHandler> TYPE = new Type<ReceiveAccountsEventHandler>();
	
	private ReceiveAccountsAction receiveAccountsAction;
	
	public ReceiveAccountsEvent(ReceiveAccountsAction receiveAccountsAction, HasWidgets container)
	{
		super(container);
		this.receiveAccountsAction = receiveAccountsAction;
	}
	
	@Override
	public Type<ReceiveAccountsEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	protected void dispatch(ReceiveAccountsEventHandler handler)
	{
		handler.onReceiveAccounts(this);
	}

	public ReceiveAccountsAction getReceiveAccountsAction()
	{
		return receiveAccountsAction;
	}
}
