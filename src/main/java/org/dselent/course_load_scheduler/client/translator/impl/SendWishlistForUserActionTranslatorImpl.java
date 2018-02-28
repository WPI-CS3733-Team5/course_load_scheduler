package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistForUserAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistForUserAction;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.send.jsonkeys.SendLoginKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.json.client.JSONArray;

public class SendWishlistForUserActionTranslatorImpl implements ActionTranslator<SendWishlistForUserAction, ReceiveWishlistForUserAction>
{
	public SendWishlistForUserActionTranslatorImpl() {}
	
	@Override
	public JSONObject translateToJson(SendWishlistForUserAction act)
	{
		JSONObject jsonObject = new JSONObject();
		JSONHelper.putStringValue(jsonObject, JSONHelper.convertKeyName(SendLoginKeys.USER_NAME), act.getUser());
		return jsonObject;
	}

	@Override
	public ReceiveWishlistForUserAction translateToAction(JSONObject json)
	{
		SectionInfoTranslator sectionInfoTranslator = new SectionInfoTranslator();
		
		JSONValue jsonObject = json.get("success");
		
		JSONObject sectionListObject = jsonObject.isArray().get(0).isObject();
		JSONArray sectionInfoArray = sectionListObject.isArray();
		
		ArrayList<SectionInfo> sectionList = new ArrayList<SectionInfo>();
		
		for(int i=0; i < sectionInfoArray.isArray().size(); i++)
		{
			JSONObject tempSection = sectionInfoArray.get(i).isObject();
			SectionInfo sectionInfo = sectionInfoTranslator.translateToModel(tempSection);
			sectionList.add(sectionInfo);
		}
		
		ReceiveWishlistForUserAction act = new ReceiveWishlistForUserAction(sectionList);
		
		return act;
	}
}
