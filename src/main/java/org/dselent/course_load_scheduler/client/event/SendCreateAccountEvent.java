package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendCreateAccountAction;
import org.dselent.course_load_scheduler.client.action.SendEditAccountAction;
import org.dselent.course_load_scheduler.client.event_handler.SendCreateAccountEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendEditAccountEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendCreateAccountEvent extends GwtEvent<SendCreateAccountEventHandler>{

	public static Type<SendCreateAccountEventHandler> TYPE = new Type<SendCreateAccountEventHandler>();
	
	private SendCreateAccountAction action;
	
	public SendCreateAccountEvent(SendCreateAccountAction action)
	{
		this.action = action;
	}
	
	public SendCreateAccountAction getAction()
	{
		return action;
	}
	
	
	@Override
	public Type<SendCreateAccountEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(SendCreateAccountEventHandler handler) {
		// TODO Auto-generated method stub
		
	}

}
