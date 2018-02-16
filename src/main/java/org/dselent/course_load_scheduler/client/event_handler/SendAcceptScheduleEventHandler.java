package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendAcceptScheduleEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendAcceptScheduleEventHandler extends EventHandler
{
	public void onSendAcceptSchedule(SendAcceptScheduleEvent evt);
}
