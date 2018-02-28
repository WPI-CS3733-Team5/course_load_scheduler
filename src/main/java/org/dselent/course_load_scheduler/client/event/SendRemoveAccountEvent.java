package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRemoveAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRemoveAccountEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendRemoveAccountEvent extends GwtEvent<SendRemoveAccountEventHandler>{

	public static Type<SendRemoveAccountEventHandler> TYPE = new Type<SendRemoveAccountEventHandler>();
	
	private SendRemoveAccountAction sendRemoveAccountAction;
	
	public SendRemoveAccountEvent(SendRemoveAccountAction sendRemoveAccountAction)
	{
		this.sendRemoveAccountAction = sendRemoveAccountAction;
	}
	
	@Override
	public Type<SendRemoveAccountEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendRemoveAccountEventHandler handler)
	{
		handler.onSendRemoveAccount(this);
	}

	public SendRemoveAccountAction getSendRemoveAccountAction()
	{
		return sendRemoveAccountAction;
	}	
}
