package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistForUserAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveWishlistForUserEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveWishlistForUserEvent extends DisplayEvent<ReceiveWishlistForUserEventHandler>
{
	public static Type<ReceiveWishlistForUserEventHandler> TYPE = new Type<ReceiveWishlistForUserEventHandler>();
	private ReceiveWishlistForUserAction receiveWishlistForUserAction;
	
	public ReceiveWishlistForUserEvent(ReceiveWishlistForUserAction receiveWishlistForUserAction, HasWidgets panel)
	{
		super(panel);
		this.receiveWishlistForUserAction = receiveWishlistForUserAction;
	}

	public ReceiveWishlistForUserAction getAction()
	{
		return receiveWishlistForUserAction;
	}

	@Override
	public Type<ReceiveWishlistForUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	public void dispatch(ReceiveWishlistForUserEventHandler handler)
	{
		handler.onReceiveWishlistForUser(this);
	}
}
