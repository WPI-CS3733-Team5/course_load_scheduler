package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.Action;
import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendHomeEventHandler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;


public class SendHomeEvent extends DisplayEvent{

	public static Type<SendHomeEventHandler> TYPE = new Type<SendHomeEventHandler>();
		
	public SendHomeEvent(Action action, HasWidgets container)
	{
		super(action, container);
	}
	
	@Override
	public Type<SendHomeEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendHomeEventHandler handler)
	{
		handler.onSendHome(this);
	}

	@Override
	protected void dispatch(EventHandler handler) {
		//TODO
	}

	@Override
	protected void dispatch(Object handler) {
		// TODO Auto-generated method stub
		
	}
}