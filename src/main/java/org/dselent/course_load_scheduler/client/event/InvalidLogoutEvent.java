package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidLogoutEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidLogoutEvent extends GwtEvent<InvalidLogoutEventHandler>
{
	public static Type<InvalidLogoutEventHandler> TYPE = new Type<InvalidLogoutEventHandler>();

	private InvalidGenericAction invalidGenericAction;
	
	public InvalidLogoutEvent(InvalidGenericAction invalidGenericAction)
	{
		this.invalidGenericAction = invalidGenericAction;
	}

	@Override
	public Type<InvalidLogoutEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidLogoutEventHandler handler)
	{
		handler.onInvalidLogout(this);
	}

	public InvalidGenericAction getInvalidGenericAction()
	{
		return invalidGenericAction;
	}
}
