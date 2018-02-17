package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendPopup1ApplyEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendPopup1ApplyEventHandler extends EventHandler {
	
	public void onSendPopup1Apply(SendPopup1ApplyEvent evt);

}
