package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.KeyPrefix;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSectionsKeys;
import org.dselent.course_load_scheduler.client.translator.ReceiveModelTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class SectionInfoTranslator implements ReceiveModelTranslator<SectionInfo>
{
	@Override
	public SectionInfo translateToModel(JSONObject json)
	{	
		String idKey = JSONHelper.createKey(KeyPrefix.SECTION_INFO, ReceiveSectionsKeys.ID);
		String sectionNumberKey = JSONHelper.createKey(KeyPrefix.SECTION_INFO, ReceiveSectionsKeys.SECTION_NUMBER);
		String sectionTypeKey = JSONHelper.createKey(KeyPrefix.SECTION_INFO, ReceiveSectionsKeys.SECTION_TYPE);
		String instructorInfoIdKey = JSONHelper.createKey(KeyPrefix.SECTION_INFO, ReceiveSectionsKeys.INSTRUCTOR_INFO_ID);
		String locationKey = JSONHelper.createKey(KeyPrefix.SECTION_INFO, ReceiveSectionsKeys.LOCATION);
		String deletedKey = JSONHelper.createKey(KeyPrefix.SECTION_INFO, ReceiveSectionsKeys.DELETED);
		String courseInfoIdKey = JSONHelper.createKey(KeyPrefix.SECTION_INFO, ReceiveSectionsKeys.COURSE_INFO_ID);
		String calendarInfoIdKey = JSONHelper.createKey(KeyPrefix.SECTION_INFO, ReceiveSectionsKeys.CALENDAR_INFO_ID);
		
		Integer id = JSONHelper.getIntValue(json, idKey);
		Integer sectionNumber = JSONHelper.getIntValue(json, sectionNumberKey);
		String sectionType = JSONHelper.getStringValue(json, sectionTypeKey);
		//Integer instructorInfoId = JSONHelper.getIntValue(json, instructorInfoIdKey); // TODO not sure what to do with this it is null
		String location = JSONHelper.getStringValue(json, locationKey);
		//Boolean deleted = JSONHelper.getBooleanValue(json, deletedKey); // also was null
		Integer courseInfoId = JSONHelper.getIntValue(json, courseInfoIdKey);
		Integer calendarInfoId = JSONHelper.getIntValue(json, calendarInfoIdKey);
		
		SectionInfo sectionInfo = new SectionInfo();
		sectionInfo.setId(id);
		sectionInfo.setSectionNumber(sectionNumber);
		sectionInfo.setSectionType(sectionType);
		//sectionInfo.setInstructorInfoId(instructorInfoId); //TODO all null in database
		sectionInfo.setLocation(location);
		//sectionInfo.setDeleted(deleted); // also was null
		sectionInfo.setCourseInfoId(courseInfoId);
		sectionInfo.setCalendarInfoId(calendarInfoId);
		
		return sectionInfo;
	}
}