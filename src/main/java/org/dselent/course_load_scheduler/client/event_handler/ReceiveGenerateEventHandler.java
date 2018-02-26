package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveGenerateEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveGenerateEventHandler extends EventHandler {
	public void onReceiveGenerate(ReceiveGenerateEvent evt);
}
