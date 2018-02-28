package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.UpdateNotificationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface UpdateNotificationEventHandler extends EventHandler {
	
	public void onUpdateNotification(UpdateNotificationEvent evt);

}
