package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveSchedulesEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveSchedulesEvent extends DisplayEvent<ReceiveSchedulesAction, ReceiveSchedulesEventHandler> {

	public static Type<ReceiveSchedulesEventHandler> TYPE = new Type<ReceiveSchedulesEventHandler>();
	
	public ReceiveSchedulesEvent(ReceiveSchedulesAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	public Type<ReceiveSchedulesEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	protected void dispatch(ReceiveSchedulesEventHandler handler)
	{
		handler.onReceiveSchedules(this);
	}
}