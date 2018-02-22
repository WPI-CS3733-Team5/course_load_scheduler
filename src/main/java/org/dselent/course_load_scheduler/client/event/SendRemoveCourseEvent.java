package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRemoveCourseAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRemoveCourseEventHandler;

public class SendRemoveCourseEvent extends BaseEvent<SendRemoveCourseAction, SendRemoveCourseEventHandler>{
	
public static Type<SendRemoveCourseEventHandler> TYPE = new Type<SendRemoveCourseEventHandler>();
	
	public SendRemoveCourseEvent(SendRemoveCourseAction action)
	{
		super(action);
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


}
