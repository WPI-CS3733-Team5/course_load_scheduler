package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveHomeEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveHomeEvent extends DisplayEvent<ReceiveHomeAction, ReceiveHomeEventHandler>{

	public static Type<ReceiveHomeEventHandler> TYPE = new Type<ReceiveHomeEventHandler>();
	
	public ReceiveHomeEvent(ReceiveHomeAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	public Type<ReceiveHomeEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	protected void dispatch(ReceiveHomeEventHandler handler)
	{
		handler.onReceiveHome(this);
	}
}
