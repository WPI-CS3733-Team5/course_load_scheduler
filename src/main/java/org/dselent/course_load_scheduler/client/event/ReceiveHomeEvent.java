package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveHomeEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveHomeEvent extends DisplayEvent<ReceiveHomeEventHandler>
{

	public static Type<ReceiveHomeEventHandler> TYPE = new Type<ReceiveHomeEventHandler>();
	
	private ReceiveHomeAction receiveHomeAction;
	
	public ReceiveHomeEvent(ReceiveHomeAction receiveHomeAction, HasWidgets container)
	{
		super(container);
		this.receiveHomeAction = receiveHomeAction;
	}
	
	public Type<ReceiveHomeEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	protected void dispatch(ReceiveHomeEventHandler handler)
	{
		handler.onReceiveHome(this);
	}

	public ReceiveHomeAction getReceiveHomeAction()
	{
		return receiveHomeAction;
	}
}
