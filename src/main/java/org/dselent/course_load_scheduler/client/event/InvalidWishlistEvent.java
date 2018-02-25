package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidWishlistEventHandler;

public class InvalidWishlistEvent extends BaseEvent<InvalidGenericAction, InvalidWishlistEventHandler>{

	public static Type<InvalidWishlistEventHandler> TYPE = new Type<InvalidWishlistEventHandler>();
	
	public InvalidWishlistEvent(InvalidGenericAction action) {
		super(action);
	}

	@Override
	public Type<InvalidWishlistEventHandler> getAssociatedType() {
		
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidWishlistEventHandler handler) {
		handler.onInvalidWishlist(this);
		
	}

}
