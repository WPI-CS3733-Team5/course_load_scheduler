package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendNotificationsEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendNotificationsEventHandler extends EventHandler
{
	public void onSendNotifications(SendNotificationsEvent evt);
}
