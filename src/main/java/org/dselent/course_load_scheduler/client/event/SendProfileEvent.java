package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.event_handler.SendProfileEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendProfileEvent extends GwtEvent<SendProfileEventHandler>{
	
	public static Type<SendProfileEventHandler> TYPE = new Type<SendProfileEventHandler>();
	
	private SendProfileAction action;
	
	public SendProfileEvent(SendProfileAction action)
	{
		this.action = action;
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
