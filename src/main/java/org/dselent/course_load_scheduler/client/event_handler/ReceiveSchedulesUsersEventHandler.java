package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveSchedulesUsersEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveSchedulesUsersEventHandler extends EventHandler{

	public void onReceiveSchedulesUsers(ReceiveSchedulesUsersEvent evt);
}
