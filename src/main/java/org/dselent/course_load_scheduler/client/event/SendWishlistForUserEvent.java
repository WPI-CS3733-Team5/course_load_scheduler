package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendWishlistForUserAction;
import org.dselent.course_load_scheduler.client.event_handler.SendWishlistForUserEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendWishlistForUserEvent extends DisplayEvent<SendWishlistForUserEventHandler>
{
	public static Type<SendWishlistForUserEventHandler> TYPE = new Type<SendWishlistForUserEventHandler>();
	
	private SendWishlistForUserAction sendWishlistForUserAction;
	
	public SendWishlistForUserEvent(SendWishlistForUserAction sendWishlistForUserAction, HasWidgets panel)
	{
		super(panel);
		this.sendWishlistForUserAction = sendWishlistForUserAction;
	}
	
	@Override
	public Type<SendWishlistForUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	public void dispatch(SendWishlistForUserEventHandler handler)
	{
		handler.onSendWishlistForUser(this);
	}

	public SendWishlistForUserAction getSendWishlistForUserAction()
	{
		return sendWishlistForUserAction;
	}
}
