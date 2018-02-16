package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCoursesEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendCoursesEvent extends GwtEvent<SendCoursesEventHandler>{
	
	public static Type<SendCoursesEventHandler> TYPE = new TYPE<SendCoursesEventHandler>();
	
	private SendCoursesAction action;
	
	public SendCoursesEvent(SendCoursesAction action)
	{
		this.action = action;
	}
	
	public SendCoursesAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendCoursesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendCoursesEventHandler handler)
	{
		handler.onSendCourses(this);
	}
}
