package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendHomeEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;


public class SendHomeEvent extends GwtEvent<SendHomeEventHandler>{

	public static Type<SendHomeEventHandler> TYPE = new TYPE<SendHomeEventHandler>();
	
	private SendHomeAction action;
	
	public SendHomeEvent(SendHomeAction action)
	{
		this.action = action;
	}
	
	public SendHomeAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendHomeEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendHomeEventHandler handler)
	{
		handler.onSendHome(this);
	}
}
