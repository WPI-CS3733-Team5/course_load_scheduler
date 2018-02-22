package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRemoveSelectedFromWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRemoveSelectedFromWishlistEventHandler;

public class SendRemoveSelectedFromWishlistEvent extends BaseEvent<SendRemoveSelectedFromWishlistAction, SendRemoveSelectedFromWishlistEventHandler>{
	
public static Type<SendRemoveSelectedFromWishlistEventHandler> TYPE = new Type<SendRemoveSelectedFromWishlistEventHandler>();
		
	public SendRemoveSelectedFromWishlistEvent(SendRemoveSelectedFromWishlistAction action)
	{
		super(action);
	}
	
	@Override
	public Type<SendRemoveSelectedFromWishlistEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendRemoveSelectedFromWishlistEventHandler handler)
	{
		handler.onSendRemoveSelectedFromWishlist(this);
	}

}
