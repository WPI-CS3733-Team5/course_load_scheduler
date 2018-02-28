package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidWishlistEvent extends GwtEvent<InvalidWishlistEventHandler>{

	public static Type<InvalidWishlistEventHandler> TYPE = new Type<InvalidWishlistEventHandler>();
	
	private InvalidGenericAction invalidGenericAction;
	
	public InvalidWishlistEvent(InvalidGenericAction invalidGenericAction)
	{
		this.invalidGenericAction = invalidGenericAction;
	}

	@Override
	public Type<InvalidWishlistEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(InvalidWishlistEventHandler handler)
	{
		handler.onInvalidWishlist(this);
	}

	public InvalidGenericAction getInvalidGenericAction()
	{
		return invalidGenericAction;
	}
}
