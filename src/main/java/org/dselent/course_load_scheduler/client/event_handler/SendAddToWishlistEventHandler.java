package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendAddToWishlistEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendAddToWishlistEventHandler extends EventHandler {
	
	public void onSendAddToWishlist(SendAddToWishlistEvent evt);

}
