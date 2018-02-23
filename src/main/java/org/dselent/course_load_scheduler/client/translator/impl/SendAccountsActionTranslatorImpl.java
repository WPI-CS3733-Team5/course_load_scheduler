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
		JSONObject instructorListObject = jsonObject.isArray().get(1).isObject();
		
		JSONArray userInfoArray = userListObject.isArray();
		JSONArray instructorInfoArray = instructorListObject.isArray();
		
		ArrayList<UserInfo> userInfoList = new ArrayList<UserInfo>();
		ArrayList<InstructorInfo> instructorInfoList = new ArrayList<InstructorInfo>();

		for(int i = 0; i < userInfoArray.isArray().size(); i++) {
			
			JSONObject tempUser = userInfoArray.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.ID));
			String userName = JSONHelper.getStringValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.USER_NAME));
			String firstName = JSONHelper.getStringValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.LAST_NAME));
			String email = JSONHelper.getStringValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.EMAIL));
			Integer accountState = JSONHelper.getIntValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.ACCOUNT_STATE));

		
			UserInfo user = new UserInfo();
			user.setId(id);
			user.setUserName(userName);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setAccountState(accountState);
			
			userInfoList.add(user);
		}
		
		for(int i = 0; i < instructorInfoArray.isArray().size(); i++) {
			
			JSONObject tempInstructor = instructorInfoArray.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.ID));
			Integer rank = JSONHelper.getIntValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.RANK));
			Integer courseLoad = JSONHelper.getIntValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.COURSE_LOAD));
			Integer phoneNumber = JSONHelper.getIntValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.PHONE_NUMBER));
			String office = JSONHelper.getStringValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.OFFICE));
			Integer userInfoId = JSONHelper.getIntValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.USER_INFO_ID));

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
