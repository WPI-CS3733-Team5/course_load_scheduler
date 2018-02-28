package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAddToWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAddToWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendAddToWishlistEvent extends GwtEvent<SendAddToWishlistEventHandler>
{
	
	public static Type<SendAddToWishlistEventHandler> TYPE = new Type<SendAddToWishlistEventHandler>();
	
	private SendAddToWishlistAction sendAddToWishlistAction;
	
	public SendAddToWishlistEvent(SendAddToWishlistAction sendAddToWishlistAction)
	{
		this.sendAddToWishlistAction = sendAddToWishlistAction;
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

	public SendAddToWishlistAction getSendAddToWishlistAction()
	{
		return sendAddToWishlistAction;
	}
}
