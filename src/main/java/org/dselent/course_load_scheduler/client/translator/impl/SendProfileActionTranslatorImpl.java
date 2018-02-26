package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveProfileAction;
import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveInstructorInfoKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveUserInfoKeys;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendProfileKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendProfileActionTranslatorImpl implements ActionTranslator<SendProfileAction, ReceiveProfileAction>
{

	@Override
	public JSONObject translateToJson(SendProfileAction action) {
		JSONObject jsonObject = new JSONObject();
		
		JSONHelper.putIntValue(jsonObject, JSONHelper.convertKeyName(SendProfileKeys.ID), action.getUserId());
		
		return jsonObject;
	}

	@Override
	public ReceiveProfileAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		JSONObject userObject = jsonObject.isArray().get(0).isObject();
		JSONObject instructorObject = jsonObject.isArray().get(1).isObject();
		
		UserInfo user = new UserInfo();
		InstructorInfo instructor = new InstructorInfo();
		
		Integer id = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.ID));
		String userName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.USER_NAME));
		String firstName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.FIRST_NAME));
		String lastName = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.LAST_NAME));
		String email = JSONHelper.getStringValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.EMAIL));
		Integer userStateId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveUserInfoKeys.USER_STATE_ID));

		user.setId(id);
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setUserStateId(userStateId);
		
		Integer id2 = JSONHelper.getIntValue(instructorObject, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.ID));
		Integer rank = JSONHelper.getIntValue(instructorObject, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.RANK));
		Integer courseLoad = JSONHelper.getIntValue(instructorObject, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.COURSE_LOAD));
		String office = JSONHelper.getStringValue(instructorObject, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.OFFICE));
		Integer userInfoId = JSONHelper.getIntValue(instructorObject, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.USER_INFO_ID));
	
		instructor.setId(id2);
		instructor.setRank(rank);
		instructor.setCourseLoad(courseLoad);
		instructor.setOffice(office);
		instructor.setUserInfoId(userInfoId);
		
		ReceiveProfileAction action = new ReceiveProfileAction(user, instructor);
		return action;
	}
	
}
