package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendRemoveSelectedFromWishlistEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendRemoveSelectedFromWishlistEventHandler extends EventHandler
{
	public void onSendRemoveSelectedFromWishlist(SendRemoveSelectedFromWishlistEvent evt);

}
