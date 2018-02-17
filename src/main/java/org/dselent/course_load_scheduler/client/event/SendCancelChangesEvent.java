package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCancelChangesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCancelChangesEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendCancelChangesEvent extends GwtEvent<SendCancelChangesEventHandler>{
	
public static Type<SendCancelChangesEventHandler> TYPE = new Type<SendCancelChangesEventHandler>();
	
	private SendCancelChangesAction action;
	
	public SendCancelChangesEvent(SendCancelChangesAction action)
	{
		this.action = action;
	}
	
	public SendCancelChangesAction getAction()
	{
		return action;
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


}
