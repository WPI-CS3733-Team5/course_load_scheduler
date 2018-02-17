package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendPopup1CancelEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendPopup1CancelEventHandler extends EventHandler {
	
	public void onSendPopup1Cancel(SendPopup1CancelEvent evt);

}
