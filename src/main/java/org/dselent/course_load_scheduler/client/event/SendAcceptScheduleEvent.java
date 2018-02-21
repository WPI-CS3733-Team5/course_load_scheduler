package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAcceptScheduleEventHandler;


public class SendAcceptScheduleEvent extends BaseEvent<SendAcceptScheduleAction, SendAcceptScheduleEventHandler>{
	
	public static Type<SendAcceptScheduleEventHandler> TYPE = new Type<SendAcceptScheduleEventHandler>();
	
	public SendAcceptScheduleEvent(SendAcceptScheduleAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendAcceptScheduleEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendAcceptScheduleEventHandler handler)
	{
		handler.onSendAcceptSchedule(this);
	}
}
