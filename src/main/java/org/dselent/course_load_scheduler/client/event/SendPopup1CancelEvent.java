package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup1CancelAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup1CancelEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendPopup1CancelEvent extends GwtEvent<SendPopup1CancelEventHandler>
{
		
	public static Type<SendPopup1CancelEventHandler> TYPE = new Type<SendPopup1CancelEventHandler>();
	
	private SendPopup1CancelAction sendPopup1CancelAction;
			
	public SendPopup1CancelEvent(SendPopup1CancelAction sendPopup1CancelAction)
	{
		this.sendPopup1CancelAction = sendPopup1CancelAction;
	}
			 	
	@Override
	public Type<SendPopup1CancelEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup1CancelEventHandler handler)
	{
		handler.onSendPopup1Cancel(this);
	}

	public SendPopup1CancelAction getSendPopup1CancelAction()
	{
		return sendPopup1CancelAction;
	}

}
