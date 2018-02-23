package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveLogoutAction;
import org.dselent.course_load_scheduler.client.action.SendLogoutAction;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import com.google.gwt.json.client.JSONObject;

public class SendLogoutActionTranslatorImpl implements ActionTranslator<SendLogoutAction, ReceiveLogoutAction>{

	@Override
	public JSONObject translateToJson(SendLogoutAction object) {
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveLogoutAction translateToAction(JSONObject json) {
		return new ReceiveLogoutAction();
	}

}
