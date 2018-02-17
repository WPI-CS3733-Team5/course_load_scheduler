package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendCancelChangesEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendCancelChangesEventHandler extends EventHandler{
	
	public void onSendCancelChanges(SendCancelChangesEvent evt);

}
