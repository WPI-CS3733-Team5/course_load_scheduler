<<<<<<< HEAD
package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSchedulesEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendSchedulesEvent extends DisplayEvent<SendSchedulesAction, SendSchedulesEventHandler>{
	
	public static Type<SendSchedulesEventHandler> TYPE = new Type<SendSchedulesEventHandler>();
		
	public SendSchedulesEvent(SendSchedulesAction action, HasWidgets panel)
	{
		super(action, panel);
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
}
=======
package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSchedulesEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendSchedulesEvent extends DisplayEvent<SendSchedulesAction, SendSchedulesEventHandler>{
	
	public static Type<SendSchedulesEventHandler> TYPE = new Type<SendSchedulesEventHandler>();
		
	public SendSchedulesEvent(SendSchedulesAction action, HasWidgets panel)
	{
		super(action,panel);
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
}
>>>>>>> 0794b4e12100245a2081ffc1eee87deca8904f25
