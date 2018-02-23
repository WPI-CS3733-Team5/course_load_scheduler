package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidCoursesEventHandler;

public class InvalidCoursesEvent extends BaseEvent<InvalidGenericAction, InvalidCoursesEventHandler>
{

	public static Type<InvalidCoursesEventHandler> TYPE = new Type<InvalidCoursesEventHandler>();
	
	public InvalidCoursesEvent(InvalidGenericAction action) {
		super(action);
	}

	@Override
	public Type<InvalidCoursesEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidCoursesEventHandler handler) {
		handler.onInvalidCourses(this);		
	}
	
}
