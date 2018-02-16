package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAcceptScheduleEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendAcceptScheduleEvent extends GwtEvent<SendAcceptScheduleEventHandler>{
	
	public static Type<SendAcceptScheduleEventHandler> TYPE = new TYPE<SendAcceptScheduleEventHandler>();
	
	private SendAcceptScheduleAction action;
	
	public SendAcceptScheduleEvent(SendAcceptScheduleAction action)
	{
		this.action = action;
	}
	
	public SendAcceptScheduleAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendAcceptScheduleEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendAcceptScheduleEventHandler handler)
	{
		handler.onSendAcceptSchedule(this);
	}
}
