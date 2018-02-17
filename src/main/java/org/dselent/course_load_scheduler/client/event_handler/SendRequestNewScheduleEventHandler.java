package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendRequestNewScheduleEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendRequestNewScheduleEventHandler extends EventHandler {
	
	public void onSendRequestNewSchedule(SendRequestNewScheduleEvent evt);

}
