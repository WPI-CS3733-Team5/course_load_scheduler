package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveSchedulesEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveSchedulesEventHandler extends EventHandler{

	public void onReceiveSchedules(ReceiveSchedulesEvent evt);
}
