package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendHomeFilterAction;
import org.dselent.course_load_scheduler.client.event_handler.SendHomeFilterEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendHomeFilterEvent extends GwtEvent<SendHomeFilterEventHandler>{
	
	public static Type<SendHomeFilterEventHandler> TYPE = new Type<SendHomeFilterEventHandler>();
	
	private SendHomeFilterAction sendHomeFilterAction;
	
	public SendHomeFilterEvent(SendHomeFilterAction sendHomeFilterAction)
	{
		this.sendHomeFilterAction = sendHomeFilterAction;
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

	public SendHomeFilterAction getSendHomeFilterAction()
	{
		return sendHomeFilterAction;
	}	
}