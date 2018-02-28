package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidProfileEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidProfileEvent extends GwtEvent<InvalidProfileEventHandler>
{
	public static Type<InvalidProfileEventHandler> TYPE = new Type<InvalidProfileEventHandler>();
		
	private InvalidGenericAction invalidGenericAction;
	
	public InvalidProfileEvent(InvalidGenericAction invalidGenericAction)
	{
		this.invalidGenericAction = invalidGenericAction;
	}

	@Override
	public Type<InvalidProfileEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidProfileEventHandler handler)
	{
		handler.onInvalidProfile(this);
	}

	public InvalidGenericAction getInvalidGenericAction()
	{
		return invalidGenericAction;
	}
}
