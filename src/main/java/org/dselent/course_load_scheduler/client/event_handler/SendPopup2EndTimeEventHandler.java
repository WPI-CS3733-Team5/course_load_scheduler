package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendPopup2EndTimeEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendPopup2EndTimeEventHandler extends EventHandler{
	
	public void onSendPopup2EndTime(SendPopup2EndTimeEvent evt);

}
