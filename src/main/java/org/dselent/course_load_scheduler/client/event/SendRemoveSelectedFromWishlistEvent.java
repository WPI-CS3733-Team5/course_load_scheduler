package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRemoveSelectedFromWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRemoveSelectedFromWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendRemoveSelectedFromWishlistEvent extends GwtEvent<SendRemoveSelectedFromWishlistEventHandler>
{
	public static Type<SendRemoveSelectedFromWishlistEventHandler> TYPE = new Type<SendRemoveSelectedFromWishlistEventHandler>();
	
	private SendRemoveSelectedFromWishlistAction sendRemoveSelectedFromWishlistAction;
	
	public SendRemoveSelectedFromWishlistEvent(SendRemoveSelectedFromWishlistAction sendRemoveSelectedFromWishlistAction)
	{
		this.sendRemoveSelectedFromWishlistAction = sendRemoveSelectedFromWishlistAction;
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

	public SendRemoveSelectedFromWishlistAction getSendRemoveSelectedFromWishlistAction()
	{
		return sendRemoveSelectedFromWishlistAction;
	}
}
