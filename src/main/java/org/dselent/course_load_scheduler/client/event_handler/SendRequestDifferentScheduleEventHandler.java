package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendRequestDifferentScheduleEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendRequestDifferentScheduleEventHandler extends EventHandler
{
	public void onSendRequestDifferentSchedule(SendRequestDifferentScheduleEvent evt);
}
