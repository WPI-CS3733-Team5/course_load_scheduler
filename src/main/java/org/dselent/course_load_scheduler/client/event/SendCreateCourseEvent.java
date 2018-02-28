package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCreateCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCreateCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendCreateCourseEvent extends GwtEvent<SendCreateCourseEventHandler>
{
	public static Type<SendCreateCourseEventHandler> TYPE = new Type<SendCreateCourseEventHandler>();
	
	private SendCreateCourseAction sendCreateCourseAction;
	
	public SendCreateCourseEvent(SendCreateCourseAction sendCreateCourseAction)
	{
		this.sendCreateCourseAction = sendCreateCourseAction;
	}

	@Override
	public Type<SendCreateCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendCreateCourseEventHandler handler)
	{
		handler.onSendCreateCourse(this);
	}

	public SendCreateCourseAction getSendCreateCourseAction()
	{
		return sendCreateCourseAction;
	}
}
