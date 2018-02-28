package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup3ApplyAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup3ApplyEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendPopup3ApplyEvent extends GwtEvent<SendPopup3ApplyEventHandler>
{
	public static Type<SendPopup3ApplyEventHandler> TYPE = new Type<SendPopup3ApplyEventHandler>();

	private SendPopup3ApplyAction sendPopup3ApplyAction;
	
	public SendPopup3ApplyEvent(SendPopup3ApplyAction sendPopup3ApplyAction)
	{
		this.sendPopup3ApplyAction = sendPopup3ApplyAction;
	}
	
	@Override
	public Type<SendPopup3ApplyEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup3ApplyEventHandler handler)
	{
		handler.onSendPopup3Apply(this);
	}

	public SendPopup3ApplyAction getSendPopup3ApplyAction()
	{
		return sendPopup3ApplyAction;
	}
}
