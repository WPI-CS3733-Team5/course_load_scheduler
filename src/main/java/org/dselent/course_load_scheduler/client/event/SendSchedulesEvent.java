package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSchedulesEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendSchedulesEvent extends GwtEvent<SendSchedulesEventHandler>{
	
	public static Type<SendSchedulesEventHandler> TYPE = new TYPE<SendSchedulesEventHandler>();
	
	private SendSchedulesAction action;
	
	public SendSchedulesEvent(SendSchedulesAction action)
	{
		this.action = action;
	}
	
	public SendSchedulesAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendSchedulesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendSchedulesEventHandler handler)
	{
		handler.onSendSchedules(this);
	}
}
