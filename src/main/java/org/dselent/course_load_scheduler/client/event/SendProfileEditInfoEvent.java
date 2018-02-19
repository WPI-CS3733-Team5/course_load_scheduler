package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendProfileEditInfoAction;
import org.dselent.course_load_scheduler.client.event_handler.SendAccountsEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendProfileEditInfoEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendProfileEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;


public class SendProfileEditInfoEvent extends GwtEvent<SendProfileEditInfoEventHandler>{
	
	public static Type<SendProfileEditInfoEventHandler> TYPE = new Type<SendProfileEditInfoEventHandler>();

	private SendProfileEditInfoAction action;
	
	public SendProfileEditInfoEvent(SendProfileEditInfoAction action) {
		this.setAction(action);
	}

	public SendProfileEditInfoAction getAction() {
		return action;
	}

	public void setAction(SendProfileEditInfoAction action) {
		this.action = action;
	}
	
	public Type<SendProfileEditInfoEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	protected void dispatch(SendProfileEditInfoEventHandler handler)
	{
		handler.onSendProfileEditInfo(this);
	}

}
