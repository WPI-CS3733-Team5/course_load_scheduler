package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendGenerateEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SendGenerateEventHandler extends EventHandler{
	public void onSendGenerate(SendGenerateEvent evt);

}
