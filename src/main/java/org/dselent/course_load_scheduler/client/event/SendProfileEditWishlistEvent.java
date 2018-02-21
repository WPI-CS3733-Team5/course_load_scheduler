package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendProfileEditWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendProfileEditWishlistEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class SendProfileEditWishlistEvent extends GwtEvent<SendProfileEditWishlistEventHandler>{

	public static Type<SendProfileEditWishlistEventHandler> TYPE = new Type<SendProfileEditWishlistEventHandler>();

	private SendProfileEditWishlistAction action;

	public SendProfileEditWishlistEvent(SendProfileEditWishlistAction action) {
		this.setAction(action);
	}

	public SendProfileEditWishlistAction getAction() {
		return action;
	}

	public void setAction(SendProfileEditWishlistAction action) {
		this.action = action;
	}

	public Type<SendProfileEditWishlistEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	protected void dispatch(SendProfileEditWishlistEventHandler handler)
	{
		handler.onSendProfileEditWishlist(this);
	}


}
