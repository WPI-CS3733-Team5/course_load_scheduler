package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendAcceptScheduleNotificationEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendAcceptScheduleNotificationEventHandler extends EventHandler {

	void onSendAcceptScheduleNotificationEvent(SendAcceptScheduleNotificationEvent evt);
}
