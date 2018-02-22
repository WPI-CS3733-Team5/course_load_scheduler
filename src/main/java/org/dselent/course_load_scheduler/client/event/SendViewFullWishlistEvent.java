package org.dselent.course_load_scheduler.client.event;

//Same as SendWishlistEvent, TODO is to deprecate this and change all calls to SendWishlistEvent

import org.dselent.course_load_scheduler.client.action.SendViewFullWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendViewFullWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendViewFullWishlistEvent extends GwtEvent<SendViewFullWishlistEventHandler>{
	
public static Type<SendViewFullWishlistEventHandler> TYPE = new Type<SendViewFullWishlistEventHandler>();
	
	private SendViewFullWishlistAction action;
	
	public SendViewFullWishlistEvent(SendViewFullWishlistAction action)
	{
		this.action = action;
	}
	
	public SendViewFullWishlistAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendViewFullWishlistEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendViewFullWishlistEventHandler handler)
	{
		handler.onSendViewFullWishlist(this);
	}
}
