package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveWishlistEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveWishlistEvent extends DisplayEvent<ReceiveWishlistAction, ReceiveWishlistEventHandler>{

	public static Type<ReceiveWishlistEventHandler> TYPE = new Type<ReceiveWishlistEventHandler>();
	
	public ReceiveWishlistEvent(ReceiveWishlistAction action, HasWidgets container) {
		super(action, container);
	}

	@Override
	public Type<ReceiveWishlistEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveWishlistEventHandler handler) {
		handler.onReceiveWishlist(this);
	}
	
}
