package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendProfileEditInfoEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SendProfileEditInfoEventHandler extends EventHandler
{
	public void onSendProfileEditInfo(SendProfileEditInfoEvent evt);
}
