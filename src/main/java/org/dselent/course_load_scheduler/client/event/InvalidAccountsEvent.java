package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidAccountsEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class InvalidAccountsEvent extends GwtEvent<InvalidAccountsEventHandler>
{
	public static Type<InvalidAccountsEventHandler> TYPE = new Type<InvalidAccountsEventHandler>();
	
	private InvalidGenericAction invalidGenericAction;
	
	public InvalidAccountsEvent(InvalidGenericAction invalidGenericAction)
	{
		this.invalidGenericAction = invalidGenericAction;
		
	}
	
	@Override
	public Type<InvalidAccountsEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	protected void dispatch(InvalidAccountsEventHandler handler)
	{
		handler.onInvalidAccounts(this);
	}

	public InvalidGenericAction getInvalidGenericAction()
	{
		return invalidGenericAction;
	}
	
}
