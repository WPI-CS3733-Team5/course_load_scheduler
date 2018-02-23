package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidLogoutEventHandler;

public class InvalidLogoutEvent extends BaseEvent<InvalidGenericAction, InvalidLogoutEventHandler>
{
	public static Type<InvalidLogoutEventHandler> TYPE = new Type<InvalidLogoutEventHandler>();

	public InvalidLogoutEvent(InvalidGenericAction action) {
		super(action);
	}

	@Override
	public Type<InvalidLogoutEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidLogoutEventHandler handler) {
		handler.onInvalidLogout(this);
	}
	
}
