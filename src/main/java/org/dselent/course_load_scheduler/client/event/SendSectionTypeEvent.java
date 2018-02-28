package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSectionTypeAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSectionTypeEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendSectionTypeEvent extends GwtEvent<SendSectionTypeEventHandler>{
	
	public static Type<SendSectionTypeEventHandler> TYPE = new Type<SendSectionTypeEventHandler>();
	
	private SendSectionTypeAction sendSectionTypeAction;
	
	public SendSectionTypeEvent(SendSectionTypeAction sendSectionTypeAction)
	{
		this.sendSectionTypeAction = sendSectionTypeAction;
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

	public SendSectionTypeAction getSendSectionTypeAction()
	{
		return sendSectionTypeAction;
	}
}
