package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendHomeFilterEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendHomeFilterEventHandler extends EventHandler 
{
	public void onSendHomeFilter(SendHomeFilterEvent evt);
}
