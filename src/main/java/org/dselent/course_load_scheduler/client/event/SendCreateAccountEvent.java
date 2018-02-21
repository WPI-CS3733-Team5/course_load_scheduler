package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCreateAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCreateAccountEventHandler;

public class SendCreateAccountEvent extends BaseEvent<SendCreateAccountAction, SendCreateAccountEventHandler>{

	public static Type<SendCreateAccountEventHandler> TYPE = new Type<SendCreateAccountEventHandler>();
	
	public SendCreateAccountEvent(SendCreateAccountAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendCreateAccountEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SendCreateAccountEventHandler handler) {
		handler.onSendCreateAccount(this);
	}

}
