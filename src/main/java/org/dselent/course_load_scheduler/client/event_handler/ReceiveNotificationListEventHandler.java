package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveNotificationListEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveNotificationListEventHandler extends EventHandler {
	
	void onNotificationListReceipt(ReceiveNotificationListEvent evt);

}
