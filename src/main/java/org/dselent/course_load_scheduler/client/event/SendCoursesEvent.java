package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCoursesEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendCoursesEvent extends DisplayEvent<SendCoursesAction, SendCoursesEventHandler>{
	
	public static Type<SendCoursesEventHandler> TYPE = new Type<SendCoursesEventHandler>();
	
	private SendCoursesAction action;
	
	public SendCoursesEvent(SendCoursesAction action, HasWidgets panel)
	{
		super(action, panel);
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
