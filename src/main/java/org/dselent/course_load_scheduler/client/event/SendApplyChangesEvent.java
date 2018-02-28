package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendApplyChangesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendApplyChangesEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendApplyChangesEvent extends GwtEvent<SendApplyChangesEventHandler>
{
	public static Type<SendApplyChangesEventHandler> TYPE = new Type<SendApplyChangesEventHandler>();
	
	private SendApplyChangesAction sendApplyChangesAction;
	
	public SendApplyChangesEvent(SendApplyChangesAction sendApplyChangesAction)
	{
		this.sendApplyChangesAction = sendApplyChangesAction;
	}
		
	@Override
	public Type<SendApplyChangesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendApplyChangesEventHandler handler)
	{
		handler.onSendApplyChanges(this);
	}

	public SendApplyChangesAction getSendApplyChangesAction()
	{
		return sendApplyChangesAction;
	}	
}
