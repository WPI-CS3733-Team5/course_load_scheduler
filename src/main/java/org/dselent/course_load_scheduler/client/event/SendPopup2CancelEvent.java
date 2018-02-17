package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2CancelAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2CancelEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendPopup2CancelEvent extends GwtEvent<SendPopup2CancelEventHandler>{
	
public static Type<SendPopup2CancelEventHandler> TYPE = new Type<SendPopup2CancelEventHandler>();
	
	private SendPopup2CancelAction action;
	
	public SendPopup2CancelEvent(SendPopup2CancelAction action)
	{
		this.action = action;
	}
	
	public SendPopup2CancelAction getAction()
	{
		return action;
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

}
