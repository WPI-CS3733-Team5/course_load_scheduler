package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup1ApplyAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup1ApplyEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendPopup1ApplyEvent extends GwtEvent<SendPopup1ApplyEventHandler>
{
	public static Type<SendPopup1ApplyEventHandler> TYPE = new Type<SendPopup1ApplyEventHandler>();

	private SendPopup1ApplyAction sendPopup1ApplyAction;
	
	public SendPopup1ApplyEvent(SendPopup1ApplyAction sendPopup1ApplyAction)
	{
		this.sendPopup1ApplyAction = sendPopup1ApplyAction;
	}
	 
	@Override
	public Type<SendPopup1ApplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup1ApplyEventHandler handler)
	{
		handler.onSendPopup1Apply(this);
	}

	public SendPopup1ApplyAction getSendPopup1ApplyAction()
	{
		return sendPopup1ApplyAction;
	}
}
