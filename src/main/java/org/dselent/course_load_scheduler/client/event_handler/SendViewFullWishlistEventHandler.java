package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendViewFullWishlistEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendViewFullWishlistEventHandler extends EventHandler
{
	public void onSendViewFullWishlist(SendViewFullWishlistEvent evt);

}
