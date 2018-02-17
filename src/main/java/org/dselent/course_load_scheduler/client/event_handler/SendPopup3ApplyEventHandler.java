package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendPopup3ApplyEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendPopup3ApplyEventHandler extends EventHandler {
	
	public void onSendPopup3Apply(SendPopup3ApplyEvent evt);

}
