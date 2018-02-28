package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidSchedulesEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidSchedulesEvent extends GwtEvent<InvalidSchedulesEventHandler>
{

	public static Type<InvalidSchedulesEventHandler> TYPE = new Type<InvalidSchedulesEventHandler>();
	
	private InvalidGenericAction invalidGenericAction;
	
	public InvalidSchedulesEvent(InvalidGenericAction invalidGenericAction)
	{
		this.invalidGenericAction = invalidGenericAction;
	}
	
	@Override
	public Type<InvalidSchedulesEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	protected void dispatch(InvalidSchedulesEventHandler handler)
	{
		handler.onInvalidSchedules(this);
	}

	public InvalidGenericAction getInvalidGenericAction()
	{
		return invalidGenericAction;
	}
}
