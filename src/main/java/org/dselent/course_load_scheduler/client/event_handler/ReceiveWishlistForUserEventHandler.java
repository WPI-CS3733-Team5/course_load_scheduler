package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveWishlistForUserEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveWishlistForUserEventHandler extends EventHandler{
	public void onReceiveWishlistForUser(ReceiveWishlistForUserEvent evt);
}
