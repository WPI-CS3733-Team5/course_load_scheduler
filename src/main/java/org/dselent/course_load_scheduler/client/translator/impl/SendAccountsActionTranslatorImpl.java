package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.ReceiveAccountsAction;
import org.dselent.course_load_scheduler.client.action.SendAccountsAction;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendAccountsActionTranslatorImpl implements ActionTranslator<SendAccountsAction, ReceiveAccountsAction>
{
	@Override
	public JSONObject translateToJson(SendAccountsAction object)
	{
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveAccountsAction translateToAction(JSONObject json)
	{
		UserInfoTranslator userInfoTranslator = new UserInfoTranslator();
		InstructorInfoTranslator instructorInfoTranslator = new InstructorInfoTranslator();
		
		JSONValue jsonObject = json.get("success");
		
		JSONObject userListObject = jsonObject.isArray().get(0).isObject();
		JSONObject instructorListObject = jsonObject.isArray().get(1).isObject();
		
		JSONArray userInfoArray = userListObject.isArray();
		JSONArray instructorInfoArray = instructorListObject.isArray();
		
		ArrayList<UserInfo> userInfoList = new ArrayList<UserInfo>();
		ArrayList<InstructorInfo> instructorInfoList = new ArrayList<InstructorInfo>();

		for(int i=0; i<userInfoArray.isArray().size(); i++)
		{
			JSONObject tempUser = userInfoArray.get(i).isObject();
			UserInfo userInfo = userInfoTranslator.translateToModel(tempUser);
			userInfoList.add(userInfo);
		}
		
		for(int i = 0; i < instructorInfoArray.isArray().size(); i++)
		{
			
			JSONObject tempInstructor = instructorInfoArray.get(i).isObject();
			InstructorInfo instructorInfo = instructorInfoTranslator.translateToModel(tempInstructor);
			instructorInfoList.add(instructorInfo);
		}
		
		ReceiveAccountsAction action = new ReceiveAccountsAction(userInfoList, instructorInfoList);
		
		return action;
	}
	
}
