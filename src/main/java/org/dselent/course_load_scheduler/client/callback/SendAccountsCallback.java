package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidAccountsAction;
import org.dselent.course_load_scheduler.client.action.ReceiveAccountsAction;
import org.dselent.course_load_scheduler.client.event.InvalidAccountsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveAccountsEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SendAccountsActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendAccountsCallback extends DisplayCallback<JSONValue>{

	public SendAccountsCallback(SimpleEventBus eventBus, HasWidgets container) {
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
		
		InvalidAccountsAction iaa = new InvalidAccountsAction(sb.toString());
		InvalidAccountsEvent iae = new InvalidAccountsEvent(iaa);
		eventBus.fireEvent(iae);		
	}

	@Override
	public void onSuccess(JSONValue result) {
		JSONObject json = JSONHelper.getObjectValue(result);
		SendAccountsActionTranslatorImpl sendAccountsActionTranslator = new SendAccountsActionTranslatorImpl();
		ReceiveAccountsAction action = sendAccountsActionTranslator.translateToAction(json);
		
		ReceiveAccountsEvent event = new ReceiveAccountsEvent(action, getContainer());
		eventBus.fireEvent(event);		
	}

}
