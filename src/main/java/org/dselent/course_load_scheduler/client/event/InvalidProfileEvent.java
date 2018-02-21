package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidProfileAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidProfileEventHandler;

public class InvalidProfileEvent extends BaseEvent<InvalidProfileAction, InvalidProfileEventHandler> {

	public static Type<InvalidProfileEventHandler> TYPE = new Type<InvalidProfileEventHandler>();
		
	public InvalidProfileEvent(InvalidProfileAction action) {
		super(action);
	}

	@Override
	public Type<InvalidProfileEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidProfileEventHandler handler) {
		handler.onInvalidProfile(this);
	}

}
