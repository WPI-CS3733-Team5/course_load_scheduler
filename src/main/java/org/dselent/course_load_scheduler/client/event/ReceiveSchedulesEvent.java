package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveSchedulesEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveSchedulesEvent extends DisplayEvent<ReceiveSchedulesEventHandler>
{
	public static Type<ReceiveSchedulesEventHandler> TYPE = new Type<ReceiveSchedulesEventHandler>();
	
	private ReceiveSchedulesAction receiveSchedulesAction;
	
	public ReceiveSchedulesEvent(ReceiveSchedulesAction receiveSchedulesAction, HasWidgets container)
	{
		super(container);
		this.receiveSchedulesAction = receiveSchedulesAction;
	}
	
	@Override
	public Type<ReceiveSchedulesEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	protected void dispatch(ReceiveSchedulesEventHandler handler)
	{
		handler.onReceiveSchedules(this);
	}

	public ReceiveSchedulesAction getReceiveSchedulesAction()
	{
		return receiveSchedulesAction;
	}
}