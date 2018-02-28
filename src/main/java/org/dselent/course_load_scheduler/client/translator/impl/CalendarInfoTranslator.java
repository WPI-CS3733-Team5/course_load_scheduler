package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.KeyPrefix;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCalendarsKeys;
import org.dselent.course_load_scheduler.client.translator.ReceiveModelTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class CalendarInfoTranslator implements ReceiveModelTranslator<CalendarInfo>
{
	@Override
	public CalendarInfo translateToModel(JSONObject json)
	{	
		String idKey = JSONHelper.createKey(KeyPrefix.CALENDAR_INFO, ReceiveCalendarsKeys.ID);
		String yearKey = JSONHelper.createKey(KeyPrefix.CALENDAR_INFO, ReceiveCalendarsKeys.YEAR);
		String semesterKey = JSONHelper.createKey(KeyPrefix.CALENDAR_INFO, ReceiveCalendarsKeys.SEMESTER);
		String daysKey = JSONHelper.createKey(KeyPrefix.CALENDAR_INFO, ReceiveCalendarsKeys.DAYS);
		String startTimeKey = JSONHelper.createKey(KeyPrefix.CALENDAR_INFO, ReceiveCalendarsKeys.START_TIME);
		String endTimeKey = JSONHelper.createKey(KeyPrefix.CALENDAR_INFO, ReceiveCalendarsKeys.END_TIME);
		String termKey = JSONHelper.createKey(KeyPrefix.CALENDAR_INFO, ReceiveCalendarsKeys.TERM);
		
		Integer id = JSONHelper.getIntValue(json, idKey);
		Integer year = JSONHelper.getIntValue(json, yearKey);
		String semester = JSONHelper.getStringValue(json, semesterKey);
		String days = JSONHelper.getStringValue(json, daysKey);
		Integer startTime = JSONHelper.getIntValue(json, startTimeKey);
		Integer endTime = JSONHelper.getIntValue(json, endTimeKey);
		Integer term = JSONHelper.getIntValue(json, termKey);

		CalendarInfo calendar = new CalendarInfo();
		calendar.setId(id);
		calendar.setYear(year);
		calendar.setSemester(semester);
		calendar.setDays(days);
		calendar.setStartTime(startTime);
		calendar.setEndTime(endTime);
		calendar.setTerm(term);
		
		return calendar;
	}
}