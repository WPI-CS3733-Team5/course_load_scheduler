package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup1ApplyAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup1ApplyEventHandler;

public class SendPopup1ApplyEvent extends BaseEvent<SendPopup1ApplyAction, SendPopup1ApplyEventHandler>{
	
public static Type<SendPopup1ApplyEventHandler> TYPE = new Type<SendPopup1ApplyEventHandler>();

	public SendPopup1ApplyEvent(SendPopup1ApplyAction action)
	{
		super(action);
	}
	 
	@Override
	public Type<SendPopup1ApplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup1ApplyEventHandler handler)
	{
		handler.onSendPopup1Apply(this);
	}


}
