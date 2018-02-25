package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistForUserAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveWishlistForUserEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveWishlistForUserEvent extends DisplayEvent<ReceiveWishlistForUserAction, ReceiveWishlistForUserEventHandler>{
	public static Type<ReceiveWishlistForUserEventHandler> TYPE = new Type<ReceiveWishlistForUserEventHandler>();
	private ReceiveWishlistForUserAction act;
	
	public ReceiveWishlistForUserEvent(ReceiveWishlistForUserAction act, HasWidgets panel) {
		super(act, panel);
	}

	public ReceiveWishlistForUserAction getAction() {
		return act;
	}

	public Type<ReceiveWishlistForUserEventHandler> getAssociatedType(){
		return TYPE;
	}
	
	public void dispatch(ReceiveWishlistForUserEventHandler handler) {
		handler.onReceiveWishlistForUser(this);
	}
}
