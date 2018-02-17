package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendPopup2StartTimeEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendPopup2StartTimeEventHandler extends EventHandler{
	
	public void onSendPopup2StartTime(SendPopup2StartTimeEvent evt);


}
