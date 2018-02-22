package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveAccountsAction;
import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.action.SendAccountsAction;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveInstructorInfoKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveUserInfoKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendAccountsActionTranslatorImpl implements ActionTranslator<SendAccountsAction, ReceiveAccountsAction>
{
	@Override
	public JSONObject translateToJson(SendAccountsAction object) {
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveAccountsAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		JSONObject userListObject = jsonObject.isArray().get(0).isObject();
		JSONObject instructorListObject = jsonObject.isArray().get(0).isObject();
		
		
		JSONArray userInfoArray = userListObject.isArray();
		JSONArray instructorInfoArray = instructorListObject.isArray();
		
		ArrayList<UserInfo> userInfoList = new ArrayList<UserInfo>();
		ArrayList<InstructorInfo> instructorInfoList = new ArrayList<InstructorInfo>();

		for(int i = 0; i < userListObject.isArray().size(); i++) {
			Integer id = JSONHelper.getIntValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveUserInfoKeys.ID));
			String userName = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveUserInfoKeys.USER_NAME));
			String firstName = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveUserInfoKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveUserInfoKeys.LAST_NAME));
			String email = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveUserInfoKeys.EMAIL));
			Integer accountState = JSONHelper.getIntValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveUserInfoKeys.ACCOUNT_STATE));
			Date createdAt = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveUserInfoKeys.CREATED_AT));
			Date updatedAt = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveUserInfoKeys.UPDATED_AT));
			Date loginTime = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveUserInfoKeys.LOGIN_TIME));
		
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
		
		for(int i = 0; i < instructorListObject.isArray().size(); i++) {
			Integer id = JSONHelper.getIntValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.ID));
			Integer rank = JSONHelper.getIntValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.RANK));
			Integer courseLoad = JSONHelper.getIntValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.COURSE_LOAD));
			Integer phoneNumber = JSONHelper.getIntValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.PHONE_NUMBER));
			String office = JSONHelper.getStringValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.OFFICE));
			Integer userInfoId = JSONHelper.getIntValue(userInfoArray.get(i), JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.USER_INFO_ID));

			InstructorInfo instructor = new InstructorInfo();
			instructor.setId(id);
			instructor.setRank(rank);
			instructor.setCourseLoad(courseLoad);
			instructor.setPhoneNumber(phoneNumber);
			instructor.setOffice(office);
			instructor.setUserInfoId(userInfoId);
			
			instructorInfoList.add(instructor);
		}
		
		ReceiveAccountsAction action = new ReceiveAccountsAction(userInfoList, instructorInfoList);
		
		return action;
		
	}
	
}
