package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.event.InvalidAccountsEvent;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendGenerateCallback extends DisplayCallback<JSONValue>{
	public SendGenerateCallback(SimpleEventBus eventBus, HasWidgets container) {
		super(eventBus, container);
	}
	
	@Override
	public void onFailure(Throwable caught) {
		StringBuilder sb = new StringBuilder();
		StackTraceElement[] stackTraceElements = caught.getStackTrace();
		for(StackTraceElement stackTraceElement : stackTraceElements)
		{
			sb.append(stackTraceElement.toString());
			sb.append("\n");
		}
		
		InvalidGenericAction iaa = new InvalidGenericAction(sb.toString());
		InvalidAccountsEvent iae = new InvalidAccountsEvent(iaa);
		eventBus.fireEvent(iae);		
	}
	
	@Override
	public void onSuccess(JSONValue result) {
		
	}
}
