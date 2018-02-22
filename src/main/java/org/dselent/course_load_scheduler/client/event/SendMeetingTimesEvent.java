package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendMeetingTimesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendMeetingTimesEventHandler;

public class SendMeetingTimesEvent extends BaseEvent<SendMeetingTimesAction, SendMeetingTimesEventHandler>{
	
public static Type<SendMeetingTimesEventHandler> TYPE = new Type<SendMeetingTimesEventHandler>();
	 
	public SendMeetingTimesEvent(SendMeetingTimesAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendMeetingTimesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendMeetingTimesEventHandler handler)
	{
		handler.onSendMeetingTimes(this);
	}

}
