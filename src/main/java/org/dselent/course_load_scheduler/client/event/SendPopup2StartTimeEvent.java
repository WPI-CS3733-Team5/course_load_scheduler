package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2StartTimeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2StartTimeEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendPopup2StartTimeEvent extends GwtEvent<SendPopup2StartTimeEventHandler>
{
	public static Type<SendPopup2StartTimeEventHandler> TYPE = new Type<SendPopup2StartTimeEventHandler>();
	
	private SendPopup2StartTimeAction sendPopup2StartTimeAction;
	
	public SendPopup2StartTimeEvent(SendPopup2StartTimeAction sendPopup2StartTimeAction)
	{
		this.sendPopup2StartTimeAction = sendPopup2StartTimeAction;
	}
	
	@Override
	public Type<SendPopup2StartTimeEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup2StartTimeEventHandler handler)
	{
		handler.onSendPopup2StartTime(this);
	}

	public SendPopup2StartTimeAction getSendPopup2StartTimeAction()
	{
		return sendPopup2StartTimeAction;
	}
}
