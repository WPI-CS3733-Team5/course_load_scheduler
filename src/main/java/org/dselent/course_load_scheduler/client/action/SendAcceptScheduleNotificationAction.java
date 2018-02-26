package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.Notifications;

public class SendAcceptScheduleNotificationAction extends Action {
	private final Notifications notification;

	public SendAcceptScheduleNotificationAction(Notifications notification) {
		super();
		this.notification = notification;
	}

	public Notifications getNotification() {
		return notification;
	}
	
}
