package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidCoursesEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidCoursesEvent extends GwtEvent<InvalidCoursesEventHandler>
{
	public static Type<InvalidCoursesEventHandler> TYPE = new Type<InvalidCoursesEventHandler>();
	
	private InvalidGenericAction invalidGenericAction;
	
	public InvalidCoursesEvent(InvalidGenericAction invalidGenericAction)
	{
		this.invalidGenericAction = invalidGenericAction;
	}

	@Override
	public Type<InvalidCoursesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidCoursesEventHandler handler)
	{
		handler.onInvalidCourses(this);		
	}

	public InvalidGenericAction getInvalidGenericAction()
	{
		return invalidGenericAction;
	}
}
