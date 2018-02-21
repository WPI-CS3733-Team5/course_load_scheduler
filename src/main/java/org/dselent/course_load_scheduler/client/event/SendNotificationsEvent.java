package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendNotificationsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendNotificationsEventHandler;

import com.google.gwt.event.shared.GwtEvent; 

public class SendNotificationsEvent extends GwtEvent<SendNotificationsEventHandler>{
	
	public static Type<SendNotificationsEventHandler> TYPE = new Type<SendNotificationsEventHandler>();
	
	private SendNotificationsAction action;
	
	public SendNotificationsEvent(SendNotificationsAction action)
	{
		this.action = action;
	}
	
	public SendNotificationsAction getAction()
	{
		return action;
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
