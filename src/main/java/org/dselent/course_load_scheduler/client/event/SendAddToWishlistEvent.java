package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAddToWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAddToWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendAddToWishlistEvent extends GwtEvent<SendAddToWishlistEventHandler>{
	
public static Type<SendAddToWishlistEventHandler> TYPE = new Type<SendAddToWishlistEventHandler>();
	
	private SendAddToWishlistAction action;
	
	public SendAddToWishlistEvent(SendAddToWishlistAction action)
	{
		this.action = action;
	}
	
	public SendAddToWishlistAction getAction()
	{
		return action;
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
