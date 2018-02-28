package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.event_handler.SendProfileEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendProfileEvent extends DisplayEvent<SendProfileEventHandler>
{
	public static Type<SendProfileEventHandler> TYPE = new Type<SendProfileEventHandler>();
	
	private SendProfileAction sendProfileAction;
	
	public SendProfileEvent(SendProfileAction sendProfileAction, HasWidgets container)
	{
		super(container);
		this.sendProfileAction = sendProfileAction;
	}
	
	@Override
	public Type<SendProfileEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendProfileEventHandler handler)
	{
		handler.onSendProfile(this);
	}

	public SendProfileAction getSendProfileAction()
	{
		return sendProfileAction;
	}
}
