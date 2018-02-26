package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidWishlistEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidWishlistEventHandler extends EventHandler {
	public void onInvalidWishlist(InvalidWishlistEvent evt);
}
