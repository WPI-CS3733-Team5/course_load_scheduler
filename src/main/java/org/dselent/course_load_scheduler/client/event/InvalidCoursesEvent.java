package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidCoursesEventHandler;

public class InvalidCoursesEvent extends BaseEvent<InvalidCoursesAction, InvalidCoursesEventHandler>
{

	public static Type<InvalidCoursesEventHandler> TYPE = new Type<InvalidCoursesEventHandler>();
	
	public InvalidCoursesEvent(InvalidCoursesAction action) {
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
