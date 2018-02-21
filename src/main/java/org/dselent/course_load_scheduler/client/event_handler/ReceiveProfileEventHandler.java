package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveProfileEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveProfileEventHandler extends EventHandler {

	public void onReceiveProfile(ReceiveProfileEvent evt);
}
