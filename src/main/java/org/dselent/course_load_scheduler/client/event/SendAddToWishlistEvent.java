package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAddToWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAddToWishlistEventHandler;

public class SendAddToWishlistEvent extends BaseEvent<SendAddToWishlistAction, SendAddToWishlistEventHandler>{
	
public static Type<SendAddToWishlistEventHandler> TYPE = new Type<SendAddToWishlistEventHandler>();
	
	public SendAddToWishlistEvent(SendAddToWishlistAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendAddToWishlistEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendAddToWishlistEventHandler handler)
	{
		handler.onSendAddToWishlist(this);
	}

}
