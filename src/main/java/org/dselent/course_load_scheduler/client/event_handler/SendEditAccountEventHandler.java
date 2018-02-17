package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendEditAccountEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendEditAccountEventHandler extends EventHandler{
	public void onSendEditAccount(SendEditAccountEvent evt);
}
