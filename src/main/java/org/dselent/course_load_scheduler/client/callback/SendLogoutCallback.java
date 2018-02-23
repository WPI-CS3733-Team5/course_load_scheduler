package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLoginAction;
import org.dselent.course_load_scheduler.client.action.ReceiveLogoutAction;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLogoutEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveLogoutEvent;
import org.dselent.course_load_scheduler.client.translator.impl.LoginActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendLogoutActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendLogoutCallback extends DisplayCallback<JSONValue>{

	public SendLogoutCallback(SimpleEventBus eventBus, HasWidgets container) {
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
		
		InvalidGenericAction ila = new InvalidGenericAction(sb.toString());
		InvalidLogoutEvent ile = new InvalidLogoutEvent(ila);
		eventBus.fireEvent(ile);		
	}

	@Override
	public void onSuccess(JSONValue result) {
		JSONObject json = JSONHelper.getObjectValue(result);
		SendLogoutActionTranslatorImpl logoutActionTranslator = new SendLogoutActionTranslatorImpl();
		ReceiveLogoutAction action = logoutActionTranslator.translateToAction(json);
		
		ReceiveLogoutEvent event = new ReceiveLogoutEvent(action, getContainer());
		eventBus.fireEvent(event);		
	}

}
