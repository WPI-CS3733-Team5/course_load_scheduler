package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup3ApplyAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup3ApplyEventHandler;

public class SendPopup3ApplyEvent extends BaseEvent<SendPopup3ApplyAction, SendPopup3ApplyEventHandler>{
	
public static Type<SendPopup3ApplyEventHandler> TYPE = new Type<SendPopup3ApplyEventHandler>();

	public SendPopup3ApplyEvent(SendPopup3ApplyAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendPopup3ApplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup3ApplyEventHandler handler)
	{
		handler.onSendPopup3Apply(this);
	}

}
