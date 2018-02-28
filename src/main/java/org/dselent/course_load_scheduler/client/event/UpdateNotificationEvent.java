package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.UpdateNotificationAction;
import org.dselent.course_load_scheduler.client.event_handler.UpdateNotificationEventHandler;

public class UpdateNotificationEvent extends BaseEvent<UpdateNotificationAction, UpdateNotificationEventHandler> {

	private static Type<UpdateNotificationEventHandler> TYPE = new Type<UpdateNotificationEventHandler>();
	
	public UpdateNotificationEvent(UpdateNotificationAction action) {
		super(action);
	}

	@Override
	public Type<UpdateNotificationEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateNotificationEventHandler handler) {
		handler.onUpdateNotification(this);
	}

}
