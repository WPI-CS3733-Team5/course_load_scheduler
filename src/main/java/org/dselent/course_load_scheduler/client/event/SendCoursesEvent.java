package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.event_handler.SendCoursesEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendCoursesEvent extends DisplayEvent<SendCoursesEventHandler>
{
	public static Type<SendCoursesEventHandler> TYPE = new Type<SendCoursesEventHandler>();
	
	public SendCoursesEvent(HasWidgets panel)
	{
		super(panel);
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
