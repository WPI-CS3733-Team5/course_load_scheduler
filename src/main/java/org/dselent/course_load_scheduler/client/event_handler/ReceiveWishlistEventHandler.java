package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveWishlistEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveWishlistEventHandler extends EventHandler {

	void onReceiveWishlist(ReceiveWishlistEvent receiveWishlistEvent);

}
