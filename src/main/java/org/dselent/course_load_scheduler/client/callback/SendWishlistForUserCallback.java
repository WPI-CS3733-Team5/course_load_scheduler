package org.dselent.course_load_scheduler.client.callback;

import org.dselent.course_load_scheduler.client.action.InvalidGenericAction;
import org.dselent.course_load_scheduler.client.action.ReceiveWishlistForUserAction;
import org.dselent.course_load_scheduler.client.event.InvalidAccountsEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveWishlistForUserEvent;
import org.dselent.course_load_scheduler.client.translator.impl.SendWishlistForUserActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendWishlistForUserCallback extends DisplayCallback<JSONValue>
{
	public SendWishlistForUserCallback(SimpleEventBus eventBus, HasWidgets container)
	{
		super(eventBus, container);
	}

	@Override
	public void onSuccess(JSONValue result)
	{
		try
		{
			JSONObject json = JSONHelper.getObjectValue(result);
			SendWishlistForUserActionTranslatorImpl sendWishlistTranslator = new SendWishlistForUserActionTranslatorImpl();
			ReceiveWishlistForUserAction act = sendWishlistTranslator.translateToAction(json);
			
			ReceiveWishlistForUserEvent evt = new ReceiveWishlistForUserEvent(act, getContainer());
			eventBus.fireEvent(evt);
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
		
		InvalidGenericAction iaa = new InvalidGenericAction(caught.getMessage()/*sb.toString()*/);
		InvalidAccountsEvent iae = new InvalidAccountsEvent(iaa);
		eventBus.fireEvent(iae);		
	}
	

}
