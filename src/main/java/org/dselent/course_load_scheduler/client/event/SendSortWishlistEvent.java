package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSortWishlistAction;
//import org.dselent.course_load_scheduler.client.event_handler.SendSortEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendSortWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendSortWishlistEvent extends GwtEvent<SendSortWishlistEventHandler>
{
	public static Type<SendSortWishlistEventHandler> TYPE = new Type<SendSortWishlistEventHandler>();
	
	private SendSortWishlistAction sendSortWishlistAction;
	
	public SendSortWishlistEvent(SendSortWishlistAction sendSortWishlistAction)
	{
		this.sendSortWishlistAction = sendSortWishlistAction;
	}
		
	@Override
	public Type<SendSortWishlistEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendSortWishlistEventHandler handler)
	{
		handler.onSendSortWishlist(this);
	}

	public SendSortWishlistAction getSendSortWishlistAction()
	{
		return sendSortWishlistAction;
	}
}