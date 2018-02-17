package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditAccountAction;
import org.dselent.course_load_scheduler.client.action.SendRemoveAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditAccountEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendRemoveAccountEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendRemoveAccountEvent extends GwtEvent<SendRemoveAccountEventHandler>{

	public static Type<SendRemoveAccountEventHandler> TYPE = new Type<SendRemoveAccountEventHandler>();
	
	private SendRemoveAccountAction action;
	
	public SendRemoveAccountEvent(SendRemoveAccountAction action)
	{
		this.action = action;
	}
	
	public SendRemoveAccountAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendRemoveAccountEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(SendRemoveAccountEventHandler handler) {
		// TODO Auto-generated method stub
		
	}

}
