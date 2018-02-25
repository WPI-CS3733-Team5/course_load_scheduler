package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendWishlistForUserEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendWishlistForUserEventHandler extends EventHandler{
	public void onSendWishlistForUser(SendWishlistForUserEvent evt);

}
