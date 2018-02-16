package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendHomeFilterAction;
import org.dselent.course_load_scheduler.client.event_handler.SendHomeFilterEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendHomeFilterEvent extends GwtEvent<SendHomeFilterEventHandler>{
	
	public static Type<SendHomeFilterEventHandler> TYPE = new TYPE<SendHomeFilterEventHandler>();
	
	private SendHomeFilterAction action;
	
	public SendHomeFilterEvent(SendHomeFilterAction action)
	{
		this.action = action;
	}
	
	public SendHomeFilterAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendHomeFilterEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendHomeFilterEventHandler handler)
	{
		handler.onSendHomeFilter(this);
	}
}
