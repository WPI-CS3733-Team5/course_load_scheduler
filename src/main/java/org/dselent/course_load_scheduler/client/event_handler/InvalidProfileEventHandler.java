package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidProfileEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidProfileEventHandler extends EventHandler{

	public void onInvalidProfile(InvalidProfileEvent evt);
}
