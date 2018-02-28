package org.dselent.course_load_scheduler.client.action;

public class UpdateNotificationAction extends Action {
	private int notificationId;

	public int getNotificationId() {
		return notificationId;
	}

	public UpdateNotificationAction(int notificationId) {
		super();
		this.notificationId = notificationId;
	}
}
