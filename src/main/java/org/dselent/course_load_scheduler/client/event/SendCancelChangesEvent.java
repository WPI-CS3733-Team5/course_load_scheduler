package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCancelChangesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCancelChangesEventHandler;

public class SendCancelChangesEvent extends BaseEvent<SendCancelChangesAction, SendCancelChangesEventHandler>{
	
public static Type<SendCancelChangesEventHandler> TYPE = new Type<SendCancelChangesEventHandler>();
	
	public SendCancelChangesEvent(SendCancelChangesAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendCancelChangesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendCancelChangesEventHandler handler)
	{
		handler.onSendCancelChanges(this);
	}


}
