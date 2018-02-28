package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRemoveCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRemoveCourseEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendRemoveCourseEvent extends GwtEvent<SendRemoveCourseEventHandler>
{
	public static Type<SendRemoveCourseEventHandler> TYPE = new Type<SendRemoveCourseEventHandler>();
	
	private SendRemoveCourseAction sendRemoveCourseAction;
	
	public SendRemoveCourseEvent(SendRemoveCourseAction sendRemoveCourseAction)
	{
		this.sendRemoveCourseAction = sendRemoveCourseAction;
	}
	
	@Override
	public Type<SendRemoveCourseEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendRemoveCourseEventHandler handler)
	{
		handler.onSendRemoveCourse(this);
	}

	public SendRemoveCourseAction getSendRemoveCourseAction()
	{
		return sendRemoveCourseAction;
	}
}
