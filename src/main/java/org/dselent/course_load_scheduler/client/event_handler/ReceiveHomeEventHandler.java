package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveHomeEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveHomeEventHandler extends EventHandler{

	public void onReceiveHome(ReceiveHomeEvent evt);
}
