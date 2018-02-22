package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveAccountsAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveAccountsEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveAccountsEvent extends DisplayEvent<ReceiveAccountsAction, ReceiveAccountsEventHandler>{
	
	public static Type<ReceiveAccountsEventHandler> TYPE = new Type<ReceiveAccountsEventHandler>();
	
	public ReceiveAccountsEvent(ReceiveAccountsAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	public Type<ReceiveAccountsEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	protected void dispatch(ReceiveAccountsEventHandler handler)
	{
		handler.onReceiveAccounts(this);
	}
}
