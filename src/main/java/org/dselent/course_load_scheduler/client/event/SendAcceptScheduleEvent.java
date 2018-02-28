package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAcceptScheduleEventHandler;

import com.google.gwt.event.shared.GwtEvent;


public class SendAcceptScheduleEvent extends GwtEvent<SendAcceptScheduleEventHandler>{
	
	public static Type<SendAcceptScheduleEventHandler> TYPE = new Type<SendAcceptScheduleEventHandler>();
	
	private SendAcceptScheduleAction sendAcceptScheduleAction;
	
	public SendAcceptScheduleEvent(SendAcceptScheduleAction sendAcceptScheduleAction)
	{
		this.sendAcceptScheduleAction = sendAcceptScheduleAction;
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

	public SendAcceptScheduleAction getSendAcceptScheduleAction()
	{
		return sendAcceptScheduleAction;
	}	
}
