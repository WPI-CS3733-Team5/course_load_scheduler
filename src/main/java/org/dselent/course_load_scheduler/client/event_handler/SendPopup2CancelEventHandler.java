package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendPopup2CancelEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendPopup2CancelEventHandler extends EventHandler{
	
	public void onSendPopup2Cancel(SendPopup2CancelEvent evt);

}
