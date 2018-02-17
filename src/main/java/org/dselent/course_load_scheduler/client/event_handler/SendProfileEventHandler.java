package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendProfileEventHandler extends EventHandler{
	public void onSendProfile(SendProfileEvent evt);
}
