package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;

import com.google.gwt.event.shared.EventHandler;
public interface SendSchedulesEventHandler extends EventHandler{
	
	public void onSendSchedules(SendSchedulesEvent evt);

}
