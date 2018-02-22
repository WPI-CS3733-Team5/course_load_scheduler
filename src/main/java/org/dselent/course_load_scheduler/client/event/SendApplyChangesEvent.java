package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendApplyChangesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendApplyChangesEventHandler;

public class SendApplyChangesEvent extends BaseEvent<SendApplyChangesAction, SendApplyChangesEventHandler>{

public static Type<SendApplyChangesEventHandler> TYPE = new Type<SendApplyChangesEventHandler>();
	
	private SendApplyChangesAction action;
	
	public SendApplyChangesEvent(SendApplyChangesAction action)
	{
		super(action);
	}
	
	public SendApplyChangesAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendApplyChangesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendApplyChangesEventHandler handler)
	{
		handler.onSendApplyChanges(this);
	}
	
}
