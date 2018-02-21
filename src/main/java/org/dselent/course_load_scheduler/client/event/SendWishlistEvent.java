package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendWishlistEventHandler;

public class SendWishlistEvent  extends BaseEvent<SendWishlistAction, SendWishlistEventHandler>{
	
	public static Type<SendWishlistEventHandler> TYPE = new Type<SendWishlistEventHandler>();
	
	
	public SendWishlistEvent(SendWishlistAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendWishlistEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendWishlistEventHandler handler)
	{
		handler.onSendWishlist(this);
	}
}
