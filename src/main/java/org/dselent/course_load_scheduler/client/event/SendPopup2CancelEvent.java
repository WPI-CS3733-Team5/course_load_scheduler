package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2CancelAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2CancelEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendPopup2CancelEvent extends GwtEvent<SendPopup2CancelEventHandler>
{
	public static Type<SendPopup2CancelEventHandler> TYPE = new Type<SendPopup2CancelEventHandler>();
	
	private SendPopup2CancelAction sendPopup2CancelAction;
	
	public SendPopup2CancelEvent(SendPopup2CancelAction sendPopup2CancelAction)
	{
		this.sendPopup2CancelAction = sendPopup2CancelAction;
	}
	
	@Override
	public Type<SendPopup2CancelEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup2CancelEventHandler handler)
	{
		handler.onSendPopup2Cancel(this);
	}

	public SendPopup2CancelAction getSendPopup2CancelAction()
	{
		return sendPopup2CancelAction;
	}
}
