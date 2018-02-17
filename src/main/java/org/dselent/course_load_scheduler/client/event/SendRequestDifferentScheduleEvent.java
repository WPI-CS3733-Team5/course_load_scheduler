package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRequestDifferentScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRequestDifferentScheduleEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendRequestDifferentScheduleEvent extends GwtEvent<SendRequestDifferentScheduleEventHandler>{
	
public static Type<SendRequestDifferentScheduleEventHandler> TYPE = new Type<SendRequestDifferentScheduleEventHandler>();
	
	private SendRequestDifferentScheduleAction action;
	
	public SendRequestDifferentScheduleEvent(SendRequestDifferentScheduleAction action)
	{
		this.action = action;
	}
	
	public SendRequestDifferentScheduleAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendRequestDifferentScheduleEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendRequestDifferentScheduleEventHandler handler)
	{
		handler.onSendRequestDifferentSchedule(this);
	}
}
