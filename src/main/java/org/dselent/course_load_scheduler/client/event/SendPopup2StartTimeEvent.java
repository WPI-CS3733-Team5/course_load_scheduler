package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2StartTimeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2StartTimeEventHandler;

public class SendPopup2StartTimeEvent extends BaseEvent<SendPopup2StartTimeAction, SendPopup2StartTimeEventHandler>{

public static Type<SendPopup2StartTimeEventHandler> TYPE = new Type<SendPopup2StartTimeEventHandler>();
	
	public SendPopup2StartTimeEvent(SendPopup2StartTimeAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendPopup2StartTimeEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup2StartTimeEventHandler handler)
	{
		handler.onSendPopup2StartTime(this);
	}
	
	
}
