package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendGenerateAction;
import org.dselent.course_load_scheduler.client.event_handler.SendGenerateEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendGenerateEvent extends DisplayEvent<SendGenerateAction, SendGenerateEventHandler>{
	public static Type<SendGenerateEventHandler> TYPE = new Type<SendGenerateEventHandler>();
	private SendGenerateAction action;
	
	public SendGenerateEvent(SendGenerateAction action, HasWidgets panel) {
		super(action, panel);
	}

	public SendGenerateAction getAction() {
		return action;
	}

	public Type<SendGenerateEventHandler> getAssociatedType(){
		return TYPE;
	}
	
	public void dispatch(SendGenerateEventHandler handler) {
		handler.onSendGenerate(this);
	}
}

