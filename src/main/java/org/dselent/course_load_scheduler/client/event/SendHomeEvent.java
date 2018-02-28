package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendHomeEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;


public class SendHomeEvent extends DisplayEvent<SendHomeEventHandler>{

	public static Type<SendHomeEventHandler> TYPE = new Type<SendHomeEventHandler>();

	private SendHomeAction sendHomeAction;
	
	public SendHomeEvent(SendHomeAction sendHomeAction, HasWidgets container)
	{
		super(container);
		this.sendHomeAction = sendHomeAction;
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

	public SendHomeAction getSendHomeAction()
	{
		return sendHomeAction;
	}
}