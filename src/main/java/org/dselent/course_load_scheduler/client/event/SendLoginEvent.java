package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendLoginAction;
import org.dselent.course_load_scheduler.client.event_handler.SendLoginEventHandler;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendLoginEvent extends DisplayEvent<SendLoginAction, SendLoginEventHandler>
{
	public static Type<SendLoginEventHandler> TYPE = new Type<SendLoginEventHandler>();
	
	public SendLoginEvent(SendLoginAction action, HasWidgets container)
 	{
-		return action;
+		super(action, container);
 	}
	

	public Type<SendLoginEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	protected void dispatch(SendLoginEventHandler handler)
	{
		handler.onSendLogin(this);
	}
}
