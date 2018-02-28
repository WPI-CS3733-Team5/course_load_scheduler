package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.event.InvalidHomeEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveHomeEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SendHomeActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendHomeCallback extends DisplayCallback<JSONValue>
{
	public SendHomeCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}

	@Override
	public void onSuccess(JSONValue result)
	{
		try
		{
			JSONObject json = JSONHelper.getObjectValue(result);
			SendHomeActionTranslatorImpl sendHomeActionTranslator = new SendHomeActionTranslatorImpl();
			ReceiveHomeAction action = sendHomeActionTranslator.translateToAction(json);
			
			ReceiveHomeEvent event = new ReceiveHomeEvent(action, getContainer());
			eventBus.fireEvent(event);
		}
		catch(Throwable caught)
		{
			// succeeded then had an exception
			// this is more likely due to programmer error
			
			Window.alert(caught.getMessage());
		}
		
	}
	
	@Override
	public void onFailure(Throwable caught)
	{
		/*
		StringBuilder sb = new StringBuilder();
		StackTraceElement[] stackTraceElements = caught.getStackTrace();
		for(StackTraceElement stackTraceElement : stackTraceElements)
		{
			sb.append(stackTraceElement.toString());
			sb.append("\n");
		}
		*/
		
		InvalidGenericAction iha = new InvalidGenericAction(caught.getMessage()/*sb.toString()*/);
		InvalidHomeEvent ihe = new InvalidHomeEvent(iha);
		eventBus.fireEvent(ihe);
		
	}


}
