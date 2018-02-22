package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2EndTimeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2EndTimeEventHandler;

public class SendPopup2EndTimeEvent extends BaseEvent<SendPopup2EndTimeAction, SendPopup2EndTimeEventHandler>{
	
public static Type<SendPopup2EndTimeEventHandler> TYPE = new Type<SendPopup2EndTimeEventHandler>();
	
	
	public SendPopup2EndTimeEvent(SendPopup2EndTimeAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendPopup2EndTimeEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup2EndTimeEventHandler handler)
	{
		handler.onSendPopup2EndTime(this);
	}

}
