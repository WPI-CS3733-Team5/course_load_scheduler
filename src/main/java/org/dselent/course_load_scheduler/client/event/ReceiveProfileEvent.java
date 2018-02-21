package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveProfileAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveProfileEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveProfileEvent extends DisplayEvent<ReceiveProfileAction, ReceiveProfileEventHandler>{

	public static Type<ReceiveProfileEventHandler> TYPE = new Type<ReceiveProfileEventHandler>();
	
	public ReceiveProfileEvent(ReceiveProfileAction action, HasWidgets container) {
		super(action, container);
	}

	@Override
	public Type<ReceiveProfileEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveProfileEventHandler handler) {
		handler.onReceiveProfile(this);
	}
	
}
