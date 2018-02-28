package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveLoginEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveLoginEvent extends DisplayEvent<ReceiveLoginEventHandler>
{
	public static Type<ReceiveLoginEventHandler> TYPE = new Type<ReceiveLoginEventHandler>();
	
	private ReceiveLoginAction receiveloginAction;
	private ReceiveHomeAction receivehomeAction;
	
	public ReceiveLoginEvent(ReceiveLoginAction receiveloginAction, ReceiveHomeAction receivehomeAction, HasWidgets container)
	{
		super(container);
		this.receiveloginAction = receiveloginAction;
		this.receivehomeAction = receivehomeAction;
	}
	
	@Override
	public Type<ReceiveLoginEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveLoginEventHandler handler)
	{
		handler.onReceiveLogin(this);
	}

	public ReceiveLoginAction getReceiveLoginAction()
	{
		return receiveloginAction;
	}

	public ReceiveHomeAction getReceiveHomeAction()
	{
		return receivehomeAction;
	}
}