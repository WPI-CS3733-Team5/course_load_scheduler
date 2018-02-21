package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidHomeAction;
import org.dselent.course_load_scheduler.client.action.InvalidProfileAction;
import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.action.ReceiveProfileAction;
import org.dselent.course_load_scheduler.client.event.InvalidHomeEvent;
import org.dselent.course_load_scheduler.client.event.InvalidProfileEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveHomeEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveProfileEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SendHomeActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendProfileActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendProfileCallback extends DisplayCallback<JSONValue>{

	public SendProfileCallback(SimpleEventBus eventBus, HasWidgets container) {
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
		
		InvalidProfileAction iha = new InvalidProfileAction(sb.toString());
		InvalidProfileEvent ihe = new InvalidProfileEvent(iha);
		eventBus.fireEvent(ihe);		
	}

	@Override
	public void onSuccess(JSONValue result) {
		JSONObject json = JSONHelper.getObjectValue(result);
		SendProfileActionTranslatorImpl sendProfileActionTranslator = new SendProfileActionTranslatorImpl();
		ReceiveProfileAction action = sendProfileActionTranslator.translateToAction(json);
		
		ReceiveProfileEvent event = new ReceiveProfileEvent(action, getContainer());
		eventBus.fireEvent(event);		
	}

}
