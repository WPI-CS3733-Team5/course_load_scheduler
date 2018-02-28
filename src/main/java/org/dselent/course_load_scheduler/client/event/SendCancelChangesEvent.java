package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCancelChangesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCancelChangesEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendCancelChangesEvent extends GwtEvent<SendCancelChangesEventHandler>
{
	public static Type<SendCancelChangesEventHandler> TYPE = new Type<SendCancelChangesEventHandler>();
	
	private SendCancelChangesAction sendCancelChangesAction;
	
	public SendCancelChangesEvent(SendCancelChangesAction sendCancelChangesAction)
	{
		this.sendCancelChangesAction = sendCancelChangesAction;
	}
	
	@Override
	public Type<SendCancelChangesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendCancelChangesEventHandler handler)
	{
		handler.onSendCancelChanges(this);
	}

	public SendCancelChangesAction getSendCancelChangesAction()
	{
		return sendCancelChangesAction;
	}	
}
