package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidHomeEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidHomeEventHandler extends EventHandler {
	public void onInvalidHome(InvalidHomeEvent evt);
}
