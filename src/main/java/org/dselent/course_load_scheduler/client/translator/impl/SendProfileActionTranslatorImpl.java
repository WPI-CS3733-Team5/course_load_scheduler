package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveProfileAction;
import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendProfileKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendProfileActionTranslatorImpl implements ActionTranslator<SendProfileAction, ReceiveProfileAction>
{

	@Override
	public JSONObject translateToJson(SendProfileAction action)
	{
		JSONObject jsonObject = new JSONObject();
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendProfileKeys.ID), action.getUserId());
		return jsonObject;
	}

	@Override
	public ReceiveProfileAction translateToAction(JSONObject json)
	{
		UserInfoTranslator userInfoTranslator = new UserInfoTranslator();
		InstructorInfoTranslator instructorInfoTranslator = new InstructorInfoTranslator();
		
		JSONValue jsonObject = json.get("success");
		JSONObject userObject = jsonObject.isArray().get(0).isObject();
		JSONObject instructorObject = jsonObject.isArray().get(1).isObject();

		UserInfo userInfo = userInfoTranslator.translateToModel(userObject);
		InstructorInfo instructorInfo = instructorInfoTranslator.translateToModel(instructorObject);
		
		ReceiveProfileAction action = new ReceiveProfileAction(userInfo, instructorInfo);
		return action;
	}
	
}
