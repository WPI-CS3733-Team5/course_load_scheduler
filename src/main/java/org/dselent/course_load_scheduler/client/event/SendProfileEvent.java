package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.event_handler.SendProfileEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendProfileEvent extends DisplayEvent<SendProfileAction, SendProfileEventHandler>{
	
	public static Type<SendProfileEventHandler> TYPE = new Type<SendProfileEventHandler>();
	
	public SendProfileEvent(SendProfileAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendProfileEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendProfileEventHandler handler)
	{
		handler.onSendProfile(this);
	}
}
