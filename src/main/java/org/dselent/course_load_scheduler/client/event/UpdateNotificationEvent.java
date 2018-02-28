package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.UpdateNotificationAction;
import org.dselent.course_load_scheduler.client.event_handler.UpdateNotificationEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateNotificationEvent extends GwtEvent<UpdateNotificationEventHandler>
{
	private static Type<UpdateNotificationEventHandler> TYPE = new Type<UpdateNotificationEventHandler>();
	
	private UpdateNotificationAction updateNotificationAction;
	
	public UpdateNotificationEvent(UpdateNotificationAction updateNotificationAction)
	{
		this.updateNotificationAction = updateNotificationAction;
	}

	@Override
	public Type<UpdateNotificationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateNotificationEventHandler handler)
	{
		handler.onUpdateNotification(this);
	}

	public UpdateNotificationAction getUpdateNotificationAction()
	{
		return updateNotificationAction;
	}
}
