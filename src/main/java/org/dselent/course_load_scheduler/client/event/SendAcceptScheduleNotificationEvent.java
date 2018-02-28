package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleNotificationAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAcceptScheduleNotificationEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendAcceptScheduleNotificationEvent extends GwtEvent<SendAcceptScheduleNotificationEventHandler>
{
	public static Type<SendAcceptScheduleNotificationEventHandler> TYPE = new Type<SendAcceptScheduleNotificationEventHandler>();

	private SendAcceptScheduleNotificationAction sendAcceptScheduleNotificationAction;
	
	public SendAcceptScheduleNotificationEvent(SendAcceptScheduleNotificationAction sendAcceptScheduleNotificationAction)
	{
		this.sendAcceptScheduleNotificationAction = sendAcceptScheduleNotificationAction;
	}

	@Override
	public Type<SendAcceptScheduleNotificationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendAcceptScheduleNotificationEventHandler handler)
	{
		handler.onSendAcceptScheduleNotificationEvent(this);
	}

	public SendAcceptScheduleNotificationAction getSendAcceptScheduleNotificationAction()
	{
		return sendAcceptScheduleNotificationAction;
	}
}
