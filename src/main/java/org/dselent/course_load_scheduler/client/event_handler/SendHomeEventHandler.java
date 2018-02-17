package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendHomeEventHandler extends EventHandler{
	public void onSendHome(SendHomeEvent evt);
}
