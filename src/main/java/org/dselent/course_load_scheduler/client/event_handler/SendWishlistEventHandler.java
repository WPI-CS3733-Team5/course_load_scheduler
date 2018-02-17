package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendWishlistEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendWishlistEventHandler extends EventHandler{
	public void onSendWishlist(SendWishlistEvent evt);
}
