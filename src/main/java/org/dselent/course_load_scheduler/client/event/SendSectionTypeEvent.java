package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSectionTypeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSectionTypeEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendSectionTypeEvent extends GwtEvent<SendSectionTypeEventHandler>{
	
public static Type<SendSectionTypeEventHandler> TYPE = new Type<SendSectionTypeEventHandler>();
	
	private SendSectionTypeAction action;
	
	public SendSectionTypeEvent(SendSectionTypeAction action)
	{
		this.action = action;
	}
	
	public SendSectionTypeAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendSectionTypeEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendSectionTypeEventHandler handler)
	{
		handler.onSendSectionType(this);
	}


}
