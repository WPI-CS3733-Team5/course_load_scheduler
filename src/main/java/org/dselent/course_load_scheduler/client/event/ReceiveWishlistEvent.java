package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveWishlistEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveWishlistEvent extends DisplayEvent<ReceiveWishlistEventHandler>
{
	public static Type<ReceiveWishlistEventHandler> TYPE = new Type<ReceiveWishlistEventHandler>();
	
	private ReceiveWishlistAction receiveWishlistAction;
	
	public ReceiveWishlistEvent(ReceiveWishlistAction receiveWishlistAction, HasWidgets container)
	{
		super(container);
		this.receiveWishlistAction = receiveWishlistAction;
	}

	@Override
	public Type<ReceiveWishlistEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveWishlistEventHandler handler)
	{
		handler.onReceiveWishlist(this);
	}

	public ReceiveWishlistAction getReceiveWishlistAction()
	{
		return receiveWishlistAction;
	}
}
