package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRemoveAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRemoveAccountEventHandler;

public class SendRemoveAccountEvent extends BaseEvent<SendRemoveAccountAction, SendRemoveAccountEventHandler>{

	public static Type<SendRemoveAccountEventHandler> TYPE = new Type<SendRemoveAccountEventHandler>();
	
	public SendRemoveAccountEvent(SendRemoveAccountAction action)
	{
		super(action);	
	}
	
	@Override
	public Type<SendRemoveAccountEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SendRemoveAccountEventHandler handler) {

		handler.onSendRemoveAccount(this);
	}

}
