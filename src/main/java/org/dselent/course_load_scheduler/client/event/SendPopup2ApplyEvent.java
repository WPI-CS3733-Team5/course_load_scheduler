package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2ApplyAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2ApplyEventHandler;

public class SendPopup2ApplyEvent extends BaseEvent<SendPopup2ApplyAction, SendPopup2ApplyEventHandler> {
	
public static Type<SendPopup2ApplyEventHandler> TYPE = new Type<SendPopup2ApplyEventHandler>();
	
	public SendPopup2ApplyEvent(SendPopup2ApplyAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendPopup2ApplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup2ApplyEventHandler handler)
	{
		handler.onSendPopup2Apply(this);
	}

}
