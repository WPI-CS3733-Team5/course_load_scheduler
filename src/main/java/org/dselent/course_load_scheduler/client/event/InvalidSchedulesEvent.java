package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidSchedulesEventHandler;

public class InvalidSchedulesEvent extends BaseEvent<InvalidGenericAction, InvalidSchedulesEventHandler>{

public static Type<InvalidSchedulesEventHandler> TYPE = new Type<InvalidSchedulesEventHandler>();
	
	public InvalidSchedulesEvent(InvalidGenericAction action) {
		super(action);
	}
	
	public Type<InvalidSchedulesEventHandler> getAssociatedType(){
		return TYPE;
	}
	
	protected void dispatch(InvalidSchedulesEventHandler handler)
	{
		handler.onInvalidSchedules(this);
	}
}
