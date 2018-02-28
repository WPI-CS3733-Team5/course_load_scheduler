package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveProfileAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveProfileEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveProfileEvent extends DisplayEvent<ReceiveProfileEventHandler>
{
	public static Type<ReceiveProfileEventHandler> TYPE = new Type<ReceiveProfileEventHandler>();
	
	private ReceiveProfileAction receiveProfileAction;
	
	public ReceiveProfileEvent(ReceiveProfileAction receiveProfileAction, HasWidgets container)
	{
		super(container);
		this.receiveProfileAction = receiveProfileAction;
	}

	@Override
	public Type<ReceiveProfileEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveProfileEventHandler handler)
	{
		handler.onReceiveProfile(this);
	}

	public ReceiveProfileAction getReceiveProfileAction()
	{
		return receiveProfileAction;
	}
}
