package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveNotificationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveNotificationEventHandler extends EventHandler {
	
	void onNotificationListReceipt(ReceiveNotificationEvent evt);

}
