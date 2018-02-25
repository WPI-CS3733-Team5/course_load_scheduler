package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendWishlistForUserAction;
import org.dselent.course_load_scheduler.client.event_handler.SendWishlistForUserEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendWishlistForUserEvent extends DisplayEvent<SendWishlistForUserAction, SendWishlistForUserEventHandler>{
	public static Type<SendWishlistForUserEventHandler> TYPE = new Type<SendWishlistForUserEventHandler>();
	private SendWishlistForUserAction action;
	
	public SendWishlistForUserEvent(SendWishlistForUserAction action, HasWidgets panel) {
		super(action, panel);
	}
	
	public SendWishlistForUserAction getAction() {
		return action;
	}

	public Type<SendWishlistForUserEventHandler> getAssociatedType(){
		return TYPE;
	}
	
	public void dispatch(SendWishlistForUserEventHandler handler) {
		handler.onSendWishlistForUser(this);
	}
}
