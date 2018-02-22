package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveProfileAction;
import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveUserInfoKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveProfileKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendProfileActionTranslatorImpl implements ActionTranslator<SendProfileAction, ReceiveProfileAction>
{

	@Override
	public JSONObject translateToJson(SendProfileAction object) {
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveProfileAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		JSONObject userObject = jsonObject.isArray().get(0).isObject();
		UserInfo user = new UserInfo();
		Integer id = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.ID));
		String userName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.USER_NAME));
		String firstName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.FIRST_NAME));
		String lastName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.LAST_NAME));
		String email = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.EMAIL));
		Integer accountState = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.ACCOUNT_STATE));
		Date createdAt = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.CREATED_AT));
		Date updatedAt = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.UPDATED_AT));
		Date loginTime = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.LOGIN_TIME));

		user.setId(id);
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setAccountState(accountState);
		user.setLoginTime(loginTime);
		user.setUpdatedAt(updatedAt);
		user.setAccountState(accountState);
		user.setCreatedAt(createdAt);
		
		ReceiveProfileAction action = new ReceiveProfileAction(user);
		return action;
	}
	
}
