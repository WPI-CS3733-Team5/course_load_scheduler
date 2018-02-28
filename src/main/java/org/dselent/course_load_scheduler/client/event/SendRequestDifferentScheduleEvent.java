package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRequestDifferentScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRequestDifferentScheduleEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendRequestDifferentScheduleEvent extends GwtEvent<SendRequestDifferentScheduleEventHandler>
{	
	public static Type<SendRequestDifferentScheduleEventHandler> TYPE = new Type<SendRequestDifferentScheduleEventHandler>();
	
	private SendRequestDifferentScheduleAction sendRequestDifferentScheduleAction;
	
	public SendRequestDifferentScheduleEvent(SendRequestDifferentScheduleAction sendRequestDifferentScheduleAction)
	{
		this.sendRequestDifferentScheduleAction = sendRequestDifferentScheduleAction;
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

	public SendRequestDifferentScheduleAction getSendRequestDifferentScheduleAction()
	{
		return sendRequestDifferentScheduleAction;
	}
}
