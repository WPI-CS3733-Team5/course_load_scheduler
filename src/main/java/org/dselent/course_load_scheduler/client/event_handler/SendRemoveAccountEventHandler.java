package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendRemoveAccountEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendRemoveAccountEventHandler extends EventHandler{
	public void onSendRemoveAccount(SendRemoveAccountEvent evt);
}
