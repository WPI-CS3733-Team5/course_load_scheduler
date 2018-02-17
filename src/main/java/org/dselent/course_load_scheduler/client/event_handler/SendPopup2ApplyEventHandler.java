package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendPopup2ApplyEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendPopup2ApplyEventHandler extends EventHandler{
	
	public void onSendPopup2Apply(SendPopup2ApplyEvent evt);

}