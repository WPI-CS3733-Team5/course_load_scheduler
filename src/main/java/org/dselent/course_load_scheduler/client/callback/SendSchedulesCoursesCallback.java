package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesCoursesAction;
import org.dselent.course_load_scheduler.client.event.InvalidAccountsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSchedulesCoursesEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SendSchedulesCouresesActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendSchedulesCoursesCallback extends DisplayCallback<JSONValue>{
	
	public SendSchedulesCoursesCallback(SimpleEventBus eventBus, HasWidgets container) {
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
		SendSchedulesCouresesActionTranslatorImpl sendSchedulesCoursesActionTranslator = new SendSchedulesCouresesActionTranslatorImpl();
		ReceiveSchedulesCoursesAction action = sendSchedulesCoursesActionTranslator.translateToAction(json);
		
		ReceiveSchedulesCoursesEvent event = new ReceiveSchedulesCoursesEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
}
