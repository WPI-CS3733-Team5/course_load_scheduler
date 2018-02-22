package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendWishlistEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendWishlistEvent  extends DisplayEvent<SendWishlistAction, SendWishlistEventHandler>{
	
	public static Type<SendWishlistEventHandler> TYPE = new Type<SendWishlistEventHandler>();
	
	
	public SendWishlistEvent(SendWishlistAction action, HasWidgets panel)
	{
		super(action, panel);
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
