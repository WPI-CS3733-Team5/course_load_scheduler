package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistForUserAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistForUserAction;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSectionsKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.json.client.JSONArray;

public class SendWishlistForUserActionTranslatorImpl implements ActionTranslator<SendWishlistForUserAction, ReceiveWishlistForUserAction>{
	@Override
	public JSONObject translateToJson(SendWishlistForUserAction obj) {
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveWishlistForUserAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		
		JSONObject sectionListObject = jsonObject.isArray().get(0).isObject();
		JSONArray sectionInfoArray = sectionListObject.isArray();
		
		ArrayList<SectionInfo> sectionList = new ArrayList<SectionInfo>();
		
		for(int i=0; i < sectionInfoArray.isArray().size(); i++) {
			JSONObject tempSection = sectionInfoArray.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempSection, JSONHelper.convertKeyName(ReceiveSectionsKeys.ID));
			Integer sectionNumber = JSONHelper.getIntValue(tempSection, JSONHelper.convertKeyName(ReceiveSectionsKeys.SECTION_NUMBER));
			String sectionType = JSONHelper.getStringValue(tempSection, JSONHelper.convertKeyName(ReceiveSectionsKeys.SECTION_TYPE));
			Integer instructorInfoId = JSONHelper.getIntValue(tempSection, JSONHelper.convertKeyName(ReceiveSectionsKeys.INSTRUCTOR_INFO_ID));
			String location = JSONHelper.getStringValue(tempSection, JSONHelper.convertKeyName(ReceiveSectionsKeys.LOCATION));
			Boolean deleted = JSONHelper.getBooleanValue(tempSection, JSONHelper.convertKeyName(ReceiveSectionsKeys.DELETED));
			Integer courseInfoId = JSONHelper.getIntValue(tempSection, JSONHelper.convertKeyName(ReceiveSectionsKeys.COURSE_INFO_ID));
			Integer calendarInfoId = JSONHelper.getIntValue(tempSection, JSONHelper.convertKeyName(ReceiveSectionsKeys.CALENDAR_INFO_ID));
			
			SectionInfo section = new SectionInfo();
			
			section.setId(id);
			section.setSectionNumber(sectionNumber);
			section.setSectionType(sectionType);
			section.setInstructorInfoId(instructorInfoId);
			section.setLocation(location);
			section.setDeleted(deleted);
			section.setCourseInfoId(courseInfoId);
			section.setCalendarInfoId(calendarInfoId);
			
			sectionList.add(section);
		}
		
		ReceiveWishlistForUserAction act = new ReceiveWishlistForUserAction(sectionList);
		return act;
	}
}
