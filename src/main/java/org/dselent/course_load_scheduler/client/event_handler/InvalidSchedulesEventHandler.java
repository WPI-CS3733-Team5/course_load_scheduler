package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidSchedulesEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidSchedulesEventHandler extends EventHandler {
	public void onInvalidSchedules(InvalidSchedulesEvent evt);
}
