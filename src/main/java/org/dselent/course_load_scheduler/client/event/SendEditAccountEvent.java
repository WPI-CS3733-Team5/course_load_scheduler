package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.InvalidLoginAction;
import org.dselent.course_load_scheduler.client.action.SendEditAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.InvalidLoginEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendEditAccountEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendEditAccountEvent extends GwtEvent<SendEditAccountEventHandler>{

	public static Type<SendEditAccountEventHandler> TYPE = new Type<SendEditAccountEventHandler>();
	
	private SendEditAccountAction action;
	
	public SendEditAccountEvent(SendEditAccountAction action)
	{
		this.action = action;
	}
	
	public SendEditAccountAction getAction()
	{
		return action;
	}
	@Override
	public Type<SendEditAccountEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(SendEditAccountEventHandler handler) {
		// TODO Auto-generated method stub
		
		
	}

}
