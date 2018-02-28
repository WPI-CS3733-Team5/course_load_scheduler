package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidHomeEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidHomeEvent extends GwtEvent<InvalidHomeEventHandler>
{
	public static Type<InvalidHomeEventHandler> TYPE = new Type<InvalidHomeEventHandler>();
	
	private InvalidGenericAction invalidGenericAction;
	
	public InvalidHomeEvent(InvalidGenericAction invalidGenericAction)
	{
		this.invalidGenericAction = invalidGenericAction;
	}
	
	@Override
	public Type<InvalidHomeEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	protected void dispatch(InvalidHomeEventHandler handler)
	{
		handler.onInvalidHome(this);
	}

	public InvalidGenericAction getInvalidGenericAction()
	{
		return invalidGenericAction;
	}	
}
