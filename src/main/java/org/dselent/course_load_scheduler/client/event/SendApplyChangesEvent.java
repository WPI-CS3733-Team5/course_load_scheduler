package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendApplyChangesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendApplyChangesEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendApplyChangesEvent extends GwtEvent<SendApplyChangesEventHandler>{

public static Type<SendApplyChangesEventHandler> TYPE = new Type<SendApplyChangesEventHandler>();
	
	private SendApplyChangesAction action;
	
	public SendApplyChangesEvent(SendApplyChangesAction action)
	{
		this.action = action;
	}
	
	public SendApplyChangesAction getAction()
	{
		return action;
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
	
}
