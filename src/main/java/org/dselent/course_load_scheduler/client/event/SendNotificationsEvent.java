package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendNotificationsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendNotificationsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendNotificationsEvent extends DisplayEvent<SendNotificationsEventHandler>
{
	
	public static Type<SendNotificationsEventHandler> TYPE = new Type<SendNotificationsEventHandler>();
	
	private SendNotificationsAction sendNotificationsAction;
	
	public SendNotificationsEvent(SendNotificationsAction sendNotificationsAction, HasWidgets panel)
	{
		super(panel);
		this.sendNotificationsAction = sendNotificationsAction;
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

	public SendNotificationsAction getSendNotificationsAction()
	{
		return sendNotificationsAction;
	}
}
