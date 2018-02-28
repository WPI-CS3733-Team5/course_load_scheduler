package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditAccountEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendEditAccountEvent extends GwtEvent<SendEditAccountEventHandler>{

	public static Type<SendEditAccountEventHandler> TYPE = new Type<SendEditAccountEventHandler>();
	
	private SendEditAccountAction sendEditAccountAction;
	
	public SendEditAccountEvent(SendEditAccountAction sendEditAccountAction)
	{
		this.sendEditAccountAction = sendEditAccountAction;
	}
	
	@Override
	public Type<SendEditAccountEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendEditAccountEventHandler handler)
	{
		handler.onSendEditAccount(this);
	}

	public SendEditAccountAction getSendEditAccountAction()
	{
		return sendEditAccountAction;
	}
}
