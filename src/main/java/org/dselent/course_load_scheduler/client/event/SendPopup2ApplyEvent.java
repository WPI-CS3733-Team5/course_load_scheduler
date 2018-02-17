package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2ApplyAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2ApplyEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendPopup2ApplyEvent extends GwtEvent<SendPopup2ApplyEventHandler> {
	
public static Type<SendPopup2ApplyEventHandler> TYPE = new Type<SendPopup2ApplyEventHandler>();
	
	private SendPopup2ApplyAction action;
	
	public SendPopup2ApplyEvent(SendPopup2ApplyAction action)
	{
		this.action = action;
	}
	
	public SendPopup2ApplyAction getAction()
	{
		return action;
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

}
