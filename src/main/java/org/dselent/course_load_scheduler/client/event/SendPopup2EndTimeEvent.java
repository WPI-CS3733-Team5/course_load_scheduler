package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup2EndTimeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup2EndTimeEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendPopup2EndTimeEvent extends GwtEvent<SendPopup2EndTimeEventHandler>{
	
public static Type<SendPopup2EndTimeEventHandler> TYPE = new Type<SendPopup2EndTimeEventHandler>();
	
	private SendPopup2EndTimeAction action;
	
	public SendPopup2EndTimeEvent(SendPopup2EndTimeAction action)
	{
		this.action = action;
	}
	
	public SendPopup2EndTimeAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendPopup2EndTimeEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendPopup2EndTimeEventHandler handler)
	{
		handler.onSendPopup2EndTime(this);
	}

}
