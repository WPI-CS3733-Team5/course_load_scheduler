package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesUsersAction;
import org.dselent.course_load_scheduler.client.event.InvalidAccountsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSchedulesUsersEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SendSchedulesCouresesActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendSchedulesUsersActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendSchedulesUsersCallback extends DisplayCallback<JSONValue>{

	public SendSchedulesUsersCallback(SimpleEventBus eventBus, HasWidgets container) {
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
		JSONObject json = JSONHelper.getObjectValue(result);
		SendSchedulesUsersActionTranslatorImpl sendSchedulesUsersActionTranslator = new SendSchedulesUsersActionTranslatorImpl();
		ReceiveSchedulesUsersAction action = sendSchedulesUsersActionTranslator.translateToAction(json);
		
		ReceiveSchedulesUsersEvent event = new ReceiveSchedulesUsersEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
}
