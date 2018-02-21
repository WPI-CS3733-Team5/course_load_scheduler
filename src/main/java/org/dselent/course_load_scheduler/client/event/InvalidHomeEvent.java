package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidHomeAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidHomeEventHandler;

public class InvalidHomeEvent extends BaseEvent<InvalidHomeAction, InvalidHomeEventHandler>
{

	public static Type<InvalidHomeEventHandler> TYPE = new Type<InvalidHomeEventHandler>();
	
	public InvalidHomeEvent(InvalidHomeAction action) {
		super(action);
	}
	
	public Type<InvalidHomeEventHandler> getAssociatedType(){
		return TYPE;
	}
	
	protected void dispatch(InvalidHomeEventHandler handler)
	{
		handler.onInvalidHome(this);
	}
	
}
