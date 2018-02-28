package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendEditWishlistEvent extends GwtEvent<SendEditWishlistEventHandler>
{
	public static Type<SendEditWishlistEventHandler> TYPE = new Type<SendEditWishlistEventHandler>();
	
	private SendEditWishlistAction sendEditWishlistAction;
	
	public SendEditWishlistEvent(SendEditWishlistAction sendEditWishlistAction)
	{
		this.sendEditWishlistAction = sendEditWishlistAction;
	}

	@Override
	public Type<SendEditWishlistEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendEditWishlistEventHandler handler)
	{
		handler.onSendEditWishlist(this);
	}

	public SendEditWishlistAction getSendEditWishlistAction()
	{
		return sendEditWishlistAction;
	}
}