package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveHomeKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendHomeActionTranslatorImpl implements ActionTranslator<SendHomeAction, ReceiveHomeAction>
{

	@Override
	public JSONObject translateToJson(SendHomeAction object) {
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveHomeAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		JSONObject userListObject = jsonObject.isArray().get(0).isObject();
		
		
		JSONArray userInfoArray = userListObject.isArray();
		
		ArrayList<UserInfo> userInfoList = new ArrayList<UserInfo>();

		for(int i = 0; i < jsonObject.isArray().size(); i++) {
			Integer id = JSONHelper.getIntValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveHomeKeys.ID));
			String userName = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveHomeKeys.USER_NAME));
			String firstName = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveHomeKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveHomeKeys.LAST_NAME));
			String email = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveHomeKeys.EMAIL));
			Integer accountState = JSONHelper.getIntValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveHomeKeys.ACCOUNT_STATE));
			Date createdAt = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveHomeKeys.CREATED_AT));
			Date updatedAt = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveHomeKeys.UPDATED_AT));
			Date loginTime = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveHomeKeys.LOGIN_TIME));
		
			UserInfo user = new UserInfo();
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
			
			userInfoList.add(user);
		}
		
		ReceiveHomeAction action = new ReceiveHomeAction(userInfoList);
		
		return action;
		
	}
	
}
