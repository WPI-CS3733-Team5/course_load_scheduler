package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRequestDifferentScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRequestDifferentScheduleEventHandler;

public class SendRequestDifferentScheduleEvent extends BaseEvent<SendRequestDifferentScheduleAction, SendRequestDifferentScheduleEventHandler>{
	
public static Type<SendRequestDifferentScheduleEventHandler> TYPE = new Type<SendRequestDifferentScheduleEventHandler>();
		
	public SendRequestDifferentScheduleEvent(SendRequestDifferentScheduleAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendRequestDifferentScheduleEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendRequestDifferentScheduleEventHandler handler)
	{
		handler.onSendRequestDifferentSchedule(this);
	}
}
