package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidAccountsEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.InvalidHomeEventHandler;

import com.google.gwt.event.shared.GwtEvent.Type;

public class InvalidAccountsEvent extends BaseEvent<InvalidGenericAction, InvalidAccountsEventHandler>
{
	
public static Type<InvalidAccountsEventHandler> TYPE = new Type<InvalidAccountsEventHandler>();
	
	public InvalidAccountsEvent(InvalidGenericAction action) {
		super(action);
	}
	
	public Type<InvalidAccountsEventHandler> getAssociatedType(){
		return TYPE;
	}
	
	protected void dispatch(InvalidAccountsEventHandler handler)
	{
		handler.onInvalidAccounts(this);
	}
}
