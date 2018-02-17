package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendWishlistEvent  extends GwtEvent<SendWishlistEventHandler>{
	
	public static Type<SendWishlistEventHandler> TYPE = new Type<SendWishlistEventHandler>();
	
	private SendWishlistAction action;
	
	public SendWishlistEvent(SendWishlistAction action)
	{
		this.action = action;
	}
	
	public SendWishlistAction getAction()
	{
		return action;
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
