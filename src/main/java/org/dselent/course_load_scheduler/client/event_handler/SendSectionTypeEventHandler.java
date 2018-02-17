package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendSectionTypeEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendSectionTypeEventHandler extends EventHandler {
	
	public void onSendSectionType(SendSectionTypeEvent evt);

}
