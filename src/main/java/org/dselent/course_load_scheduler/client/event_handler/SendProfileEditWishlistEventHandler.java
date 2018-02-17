package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendProfileEditWishlistEvent;
import com.google.gwt.event.shared.EventHandler;

public interface SendProfileEditWishlistEventHandler extends EventHandler 
{
	public void onSendProfileEditWishlist(SendProfileEditWishlistEvent evt);
}
