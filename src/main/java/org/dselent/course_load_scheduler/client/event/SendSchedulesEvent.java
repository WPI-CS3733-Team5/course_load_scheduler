package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSchedulesEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendSchedulesEvent extends DisplayEvent<SendSchedulesEventHandler>
{
	public static Type<SendSchedulesEventHandler> TYPE = new Type<SendSchedulesEventHandler>();
	
	private SendSchedulesAction sendSchedulesAction;
	
	public SendSchedulesEvent(SendSchedulesAction sendSchedulesAction, HasWidgets panel)
	{
		super(panel);
		this.sendSchedulesAction = sendSchedulesAction;
	}
	
	@Override
	public Type<SendSchedulesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendSchedulesEventHandler handler)
	{
		handler.onSendSchedules(this);
	}

	public SendSchedulesAction getSendSchedulesAction()
	{
		return sendSchedulesAction;
	}
}
