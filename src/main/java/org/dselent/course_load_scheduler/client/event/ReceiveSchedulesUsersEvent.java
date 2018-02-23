package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesUsersAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveSchedulesUsersEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveSchedulesUsersEvent extends DisplayEvent<ReceiveSchedulesUsersAction, ReceiveSchedulesUsersEventHandler>{

public static Type<ReceiveSchedulesUsersEventHandler> TYPE = new Type<ReceiveSchedulesUsersEventHandler>();
	
	public ReceiveSchedulesUsersEvent(ReceiveSchedulesUsersAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	public Type<ReceiveSchedulesUsersEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	protected void dispatch(ReceiveSchedulesUsersEventHandler handler)
	{
		handler.onReceiveSchedulesUsers(this);
	}
}
