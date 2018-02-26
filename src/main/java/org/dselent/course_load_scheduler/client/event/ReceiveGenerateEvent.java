package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveGenerateAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveGenerateEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveGenerateEvent extends DisplayEvent<ReceiveGenerateAction, ReceiveGenerateEventHandler>{
	public static Type<ReceiveGenerateEventHandler> TYPE = new Type<ReceiveGenerateEventHandler>();
	private ReceiveGenerateAction act;
	
	public ReceiveGenerateEvent(ReceiveGenerateAction act, HasWidgets panel) {
		super(act, panel);
	}
	
	public ReceiveGenerateAction getAction() {
		return act;
	}

	public Type<ReceiveGenerateEventHandler> getAssociatedType(){
		return TYPE;
	}
	
	public void dispatch(ReceiveGenerateEventHandler handler) {
		handler.onReceiveGenerate(this);
	}
}
