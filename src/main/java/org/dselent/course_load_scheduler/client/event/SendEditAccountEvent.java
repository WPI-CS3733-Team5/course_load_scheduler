package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditAccountEventHandler;

public class SendEditAccountEvent extends BaseEvent<SendEditAccountAction, SendEditAccountEventHandler>{

	public static Type<SendEditAccountEventHandler> TYPE = new Type<SendEditAccountEventHandler>();
	
	public SendEditAccountEvent(SendEditAccountAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendEditAccountEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SendEditAccountEventHandler handler) {
		handler.onSendEditAccount(this);
	}

}
