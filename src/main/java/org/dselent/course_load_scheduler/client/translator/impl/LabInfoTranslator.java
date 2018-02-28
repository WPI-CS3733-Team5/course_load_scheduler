package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.KeyPrefix;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLabsKeys;
import org.dselent.course_load_scheduler.client.translator.ReceiveModelTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class LabInfoTranslator implements ReceiveModelTranslator<LabInfo>
{
	@Override
	public LabInfo translateToModel(JSONObject json)
	{		
		String idKey = JSONHelper.createKey(KeyPrefix.LAB_INFO, ReceiveLabsKeys.ID);
		String sectionInfoIdKey = JSONHelper.createKey(KeyPrefix.LAB_INFO, ReceiveLabsKeys.SECTION_INFO_ID);
		String instructorInfoIdKey = JSONHelper.createKey(KeyPrefix.LAB_INFO, ReceiveLabsKeys.INSTRUCTOR_INFO_ID);
		String locationKey = JSONHelper.createKey(KeyPrefix.LAB_INFO, ReceiveLabsKeys.LOCATION);
		String calendarInfoIdKey = JSONHelper.createKey(KeyPrefix.LAB_INFO, ReceiveLabsKeys.CALENDAR_INFO_ID);
		
		Integer id = JSONHelper.getIntValue(json, idKey);
		Integer sectionInfoId = JSONHelper.getIntValue(json, sectionInfoIdKey);
		//Integer instructorInfoId = JSONHelper.getIntValue(json, instructorInfoIdKey); this is null in the database, not sure how to handle
		String location = JSONHelper.getStringValue(json, locationKey);
		Integer calendarInfoId = JSONHelper.getIntValue(json, calendarInfoIdKey);
		
		LabInfo labInfo = new LabInfo();
		labInfo.setId(id);
		labInfo.setSectionInfoId(sectionInfoId);
		//labInfo.setInstructorInfoId(instructorInfoId); this is null in the database, not sure how to handle
		labInfo.setLocation(location);
		labInfo.setCalendarInfoId(calendarInfoId);
		
		return labInfo;
	}
}