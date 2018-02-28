package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.event_handler.SendLoginEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendLoginEvent extends DisplayEvent<SendLoginEventHandler>
{
	public static Type<SendLoginEventHandler> TYPE = new Type<SendLoginEventHandler>();
	
	private SendLoginAction sendLoginAction;
	
	public SendLoginEvent(SendLoginAction sendLoginAction, HasWidgets container)
 	{
		super(container);
		this.sendLoginAction = sendLoginAction;
 	}
	
	public Type<SendLoginEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	protected void dispatch(SendLoginEventHandler handler)
	{
		handler.onSendLogin(this);
	}

	public SendLoginAction getSendLoginAction()
	{
		return sendLoginAction;
	}
}
