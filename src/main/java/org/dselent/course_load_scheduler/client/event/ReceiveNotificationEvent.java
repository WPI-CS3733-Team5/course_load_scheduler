package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveNotificationAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveNotificationEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveNotificationEvent extends DisplayEvent<ReceiveNotificationAction, ReceiveNotificationEventHandler> {

	public ReceiveNotificationEvent(ReceiveNotificationAction action, HasWidgets panel) {
		super(action, panel);
	}

	public static Type<ReceiveNotificationEventHandler> TYPE = new Type<ReceiveNotificationEventHandler>();

	@Override
	public Type<ReceiveNotificationEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveNotificationEventHandler handler) {
		handler.onNotificationListReceipt(this);
	}
}
