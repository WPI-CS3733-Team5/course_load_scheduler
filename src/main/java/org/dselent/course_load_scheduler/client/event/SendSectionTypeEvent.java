package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSectionTypeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSectionTypeEventHandler;

public class SendSectionTypeEvent extends BaseEvent<SendSectionTypeAction, SendSectionTypeEventHandler>{
	
public static Type<SendSectionTypeEventHandler> TYPE = new Type<SendSectionTypeEventHandler>();
		
	public SendSectionTypeEvent(SendSectionTypeAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendSectionTypeEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendSectionTypeEventHandler handler)
	{
		handler.onSendSectionType(this);
	}


}
