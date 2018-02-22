package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2CancelAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2CancelEventHandler;

public class SendPopup2CancelEvent extends BaseEvent<SendPopup2CancelAction, SendPopup2CancelEventHandler>{
	
public static Type<SendPopup2CancelEventHandler> TYPE = new Type<SendPopup2CancelEventHandler>();
	
	
	public SendPopup2CancelEvent(SendPopup2CancelAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendPopup2CancelEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup2CancelEventHandler handler)
	{
		handler.onSendPopup2Cancel(this);
	}

}
