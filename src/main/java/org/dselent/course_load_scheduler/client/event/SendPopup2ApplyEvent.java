package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2ApplyAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2ApplyEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendPopup2ApplyEvent extends GwtEvent<SendPopup2ApplyEventHandler>
{
	
	public static Type<SendPopup2ApplyEventHandler> TYPE = new Type<SendPopup2ApplyEventHandler>();
	
	private SendPopup2ApplyAction sendPopup2ApplyAction;
	
	public SendPopup2ApplyEvent(SendPopup2ApplyAction sendPopup2ApplyAction)
	{
		this.sendPopup2ApplyAction = sendPopup2ApplyAction;
	}
	
	@Override
	public Type<SendPopup2ApplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup2ApplyEventHandler handler)
	{
		handler.onSendPopup2Apply(this);
	}

	public SendPopup2ApplyAction getSendPopup2ApplyAction()
	{
		return sendPopup2ApplyAction;
	}
}
