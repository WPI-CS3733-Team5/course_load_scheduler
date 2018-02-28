package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.model.ScheduleLinks;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.KeyPrefix;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLabsKeys;
import org.dselent.course_load_scheduler.client.translator.ReceiveModelTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class ScheduleLinksTranslator implements ReceiveModelTranslator<ScheduleLinks>
{
	@Override
	public ScheduleLinks translateToModel(JSONObject json)
	{		
		String idKey = JSONHelper.createKey(KeyPrefix.SCHEDULE_LINKS, ReceiveLabsKeys.ID);
		String instructorInfoIdKey = JSONHelper.createKey(KeyPrefix.SCHEDULE_LINKS, ReceiveLabsKeys.INSTRUCTOR_INFO_ID);
		String sectionInfoIdKey = JSONHelper.createKey(KeyPrefix.SCHEDULE_LINKS, ReceiveLabsKeys.SECTION_INFO_ID);
	
		Integer id = JSONHelper.getIntValue(json, idKey);
		Integer instructorInfoId = JSONHelper.getIntValue(json, instructorInfoIdKey);
		Integer sectionInfoId = JSONHelper.getIntValue(json, sectionInfoIdKey);

		ScheduleLinks scheduleLinks = new ScheduleLinks();
		scheduleLinks.setId(id);
		scheduleLinks.setInstructorInfoId(instructorInfoId);
		scheduleLinks.setSectionInfoId(sectionInfoId);
		
		return scheduleLinks;
	}
}