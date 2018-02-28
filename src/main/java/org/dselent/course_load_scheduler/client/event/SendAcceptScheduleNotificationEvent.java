package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleNotificationAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAcceptScheduleNotificationEventHandler;

public class SendAcceptScheduleNotificationEvent extends BaseEvent<SendAcceptScheduleNotificationAction, SendAcceptScheduleNotificationEventHandler> {

	public SendAcceptScheduleNotificationEvent(SendAcceptScheduleNotificationAction action) {
		super(action);
	}

	public static Type<SendAcceptScheduleNotificationEventHandler> TYPE = new Type<SendAcceptScheduleNotificationEventHandler>();

	@Override
	public Type<SendAcceptScheduleNotificationEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SendAcceptScheduleNotificationEventHandler handler) {
		handler.onSendAcceptScheduleNotificationEvent(this);
	}
}
