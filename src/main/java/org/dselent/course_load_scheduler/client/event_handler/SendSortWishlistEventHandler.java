package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendSortWishlistEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendSortWishlistEventHandler extends EventHandler {
	
	public void onSendSortWishlist(SendSortWishlistEvent evt);

}
