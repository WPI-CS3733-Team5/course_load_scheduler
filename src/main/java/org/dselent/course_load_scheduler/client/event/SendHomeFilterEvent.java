package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendHomeFilterAction;
import org.dselent.course_load_scheduler.client.event_handler.SendHomeFilterEventHandler;

public class SendHomeFilterEvent extends BaseEvent<SendHomeFilterAction, SendHomeFilterEventHandler>{
	
	public static Type<SendHomeFilterEventHandler> TYPE = new Type<SendHomeFilterEventHandler>();
	
	public SendHomeFilterEvent(SendHomeFilterAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendHomeFilterEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendHomeFilterEventHandler handler)
	{
		handler.onSendHomeFilter(this);
	}
}