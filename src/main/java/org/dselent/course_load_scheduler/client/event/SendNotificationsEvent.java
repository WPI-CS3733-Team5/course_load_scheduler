package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendNotificationsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendNotificationsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendNotificationsEvent extends DisplayEvent<SendNotificationsAction, SendNotificationsEventHandler>{
	
	public static Type<SendNotificationsEventHandler> TYPE = new Type<SendNotificationsEventHandler>();
	
	
	public SendNotificationsEvent(SendNotificationsAction action, HasWidgets panel)
	{
		super(action, panel);
	}
	
	@Override
	public Type<SendNotificationsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendNotificationsEventHandler handler)
	{
		handler.onSendNotifications(this);
	}
}
