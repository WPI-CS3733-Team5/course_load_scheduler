package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.KeyPrefix;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveUserInfoKeys;
import org.dselent.course_load_scheduler.client.translator.ReceiveModelTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class UserInfoTranslator implements ReceiveModelTranslator<UserInfo>
{
	@Override
	public UserInfo translateToModel(JSONObject json)
	{		
		String idKey = JSONHelper.createKey(KeyPrefix.USER_INFO, ReceiveUserInfoKeys.ID);
		String userRoleKey = JSONHelper.createKey(KeyPrefix.USER_INFO, ReceiveUserInfoKeys.USER_ROLE);
		String userNameKey = JSONHelper.createKey(KeyPrefix.USER_INFO, ReceiveUserInfoKeys.USER_NAME);
		String firstNameKey = JSONHelper.createKey(KeyPrefix.USER_INFO, ReceiveUserInfoKeys.FIRST_NAME);
		String lastNameKey = JSONHelper.createKey(KeyPrefix.USER_INFO, ReceiveUserInfoKeys.LAST_NAME);
		String emailKey = JSONHelper.createKey(KeyPrefix.USER_INFO, ReceiveUserInfoKeys.EMAIL);
		
		Integer id = JSONHelper.getIntValue(json, idKey);
		Integer userRole = JSONHelper.getIntValue(json, userRoleKey); 
		String userName = JSONHelper.getStringValue(json, userNameKey);
		String firstName = JSONHelper.getStringValue(json, firstNameKey);
		String lastName = JSONHelper.getStringValue(json, lastNameKey);
		String email = JSONHelper.getStringValue(json, emailKey);
		
		UserInfo userInfo = new UserInfo();
		userInfo.setId(id);
		userInfo.setUserRole(userRole);
		userInfo.setUserName(userName);
		userInfo.setFirstName(firstName);
		userInfo.setLastName(lastName);
		userInfo.setEmail(email);
		
		return userInfo;
	}
}