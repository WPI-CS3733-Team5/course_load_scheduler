package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidCoursesAction;
import org.dselent.course_load_scheduler.client.action.ReceiveCoursesAction;
import org.dselent.course_load_scheduler.client.event.InvalidCoursesEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveCoursesEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SendCoursesActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendCoursesCallback extends DisplayCallback<JSONValue>
{

	public SendCoursesCallback(SimpleEventBus eventBus, HasWidgets container) {
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
		
		InvalidCoursesAction ica = new InvalidCoursesAction(sb.toString());
		InvalidCoursesEvent ice = new InvalidCoursesEvent(ica);
		eventBus.fireEvent(ice);		
	}

	@Override
	public void onSuccess(JSONValue result) {
		JSONObject json = JSONHelper.getObjectValue(result);
		SendCoursesActionTranslatorImpl sendCoursesActionTranslator = new SendCoursesActionTranslatorImpl();
		ReceiveCoursesAction action = sendCoursesActionTranslator.translateToAction(json);
		
		ReceiveCoursesEvent event = new ReceiveCoursesEvent(action, getContainer());
		eventBus.fireEvent(event);
	}
	
}
