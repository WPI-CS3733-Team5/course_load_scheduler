package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidLoginEventHandler;


/**
 * Events are "fired" and sent on the event bus to be sent to an applicable event handler
 * This event is for processing an invalid login
 * 
 * @author dselent
 *
 */
public class InvalidLoginEvent extends BaseEvent<InvalidGenericAction, InvalidLoginEventHandler>
{
	public static Type<InvalidLoginEventHandler> TYPE = new Type<InvalidLoginEventHandler>();
	
	public InvalidLoginEvent(InvalidGenericAction action)
	{
		super(action);
	}

	public Type<InvalidLoginEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	protected void dispatch(InvalidLoginEventHandler handler)
	{
		handler.onInvalidLogin(this);
	}
}