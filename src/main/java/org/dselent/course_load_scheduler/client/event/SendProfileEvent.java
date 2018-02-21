package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.event_handler.SendHomeEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendProfileEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendProfileEvent extends DisplayEvent<SendProfileAction, SendProfileEventHandler>{
	
	public static Type<SendProfileEventHandler> TYPE = new Type<SendProfileEventHandler>();
	
	private SendProfileAction action;
	
	public SendProfileEvent(SendProfileAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	public SendProfileAction getAction()
	{
		return action;
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
