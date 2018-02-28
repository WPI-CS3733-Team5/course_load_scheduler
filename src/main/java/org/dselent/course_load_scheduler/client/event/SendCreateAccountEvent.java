package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCreateAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCreateAccountEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendCreateAccountEvent extends GwtEvent<SendCreateAccountEventHandler>{

	public static Type<SendCreateAccountEventHandler> TYPE = new Type<SendCreateAccountEventHandler>();
	
	private SendCreateAccountAction sendCreateAccountAction;
	
	public SendCreateAccountEvent(SendCreateAccountAction sendCreateAccountAction)
	{
		this.sendCreateAccountAction = sendCreateAccountAction;
	}
	
	@Override
	public Type<SendCreateAccountEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendCreateAccountEventHandler handler)
	{
		handler.onSendCreateAccount(this);
	}

	public SendCreateAccountAction getSendCreateAccountAction()
	{
		return sendCreateAccountAction;
	}
}
