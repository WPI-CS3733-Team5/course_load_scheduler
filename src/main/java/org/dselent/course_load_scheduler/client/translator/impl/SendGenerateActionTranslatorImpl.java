package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveGenerateAction;
import org.dselent.course_load_scheduler.client.action.SendGenerateAction;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveInstructorInfoKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSectionsKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class SendGenerateActionTranslatorImpl implements ActionTranslator<SendGenerateAction, ReceiveGenerateAction>{
	public SendGenerateActionTranslatorImpl() {}
	
	@Override
	public JSONObject translateToJson(SendGenerateAction act)
	{
		JSONObject json = new JSONObject();
		StringBuilder keyString = new StringBuilder();
		
		JSONHelper.putIntValue(json, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.ID), act.getInstructor().getId());
		
		for(SectionInfo c: act.getSections())
		{
			keyString.append(Integer.toString(c.getId()) + " ");
		}
		
		JSONHelper.putStringValue(json, JSONHelper.convertKeyName(ReceiveSectionsKeys.ID), keyString.toString());
		
		return json;
	}
	
	@Override
	public ReceiveGenerateAction translateToAction(JSONObject json)
	{
		ReceiveGenerateAction act = new ReceiveGenerateAction();
		return act;
	}

}
