package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.Notifications;

public class ReceiveNotificationListAction {
	private ArrayList<Notifications> notificationList;

	public ArrayList<Notifications> getNotificationList() {
		return notificationList;
	}

	public ReceiveNotificationListAction(ArrayList<Notifications> notificationList) {
		super();
		this.notificationList = notificationList;
	}

}
