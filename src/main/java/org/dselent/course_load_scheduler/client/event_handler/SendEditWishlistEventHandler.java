package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendEditWishlistEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendEditWishlistEventHandler extends EventHandler {
	
	public void onSendEditWishlist(SendEditWishlistEvent evt);

}
