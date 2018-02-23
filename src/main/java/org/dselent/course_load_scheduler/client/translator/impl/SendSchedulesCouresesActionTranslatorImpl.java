package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveCoursesAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesCoursesAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesUsersAction;
import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCalendarsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCoursesKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveInstructorInfoKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLabsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSectionsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveUserInfoKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendSchedulesCouresesActionTranslatorImpl implements ActionTranslator<SendSchedulesAction, ReceiveSchedulesCoursesAction>
{

	@Override
	public JSONObject translateToJson(SendSchedulesAction object) {
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveSchedulesCoursesAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		
		JSONObject coursesObject = jsonObject.isArray().get(0).isObject();
		JSONObject sectionsObject = jsonObject.isArray().get(0).isObject();
		JSONObject calendarObject = jsonObject.isArray().get(0).isObject();
		JSONObject labObject = jsonObject.isArray().get(0).isObject();

		JSONArray coursesArray = coursesObject.isArray();
		JSONArray sectionsArray = sectionsObject.isArray();
		JSONArray calendarArray = jsonObject.isArray();
		JSONArray labArray = jsonObject.isArray();

		ArrayList<CourseInfo> courses = new ArrayList<>();
		ArrayList<SectionInfo> sections = new ArrayList<>();
		ArrayList<CalendarInfo> calendars = new ArrayList<>();
		ArrayList<LabInfo> labs = new ArrayList<>();
		
		
		
		for(int i = 0; i < coursesObject.size(); i++) {
			Integer id = JSONHelper.getIntValue(coursesArray.get(i), JSONHelper.convertKeyName(ReceiveCoursesKeys.ID));
			String courseName = JSONHelper.getStringValue(coursesArray.get(i), JSONHelper.convertKeyName(ReceiveCoursesKeys.COURSE_NAME));
			Integer requiredFrequencyPerTerm = JSONHelper.getIntValue(coursesArray.get(i), JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_TERM));
			Integer requiredFrequencyPerSemester = JSONHelper.getIntValue(coursesArray.get(i), JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_SEMESTER));
			Integer requiredFrequencyPerYear = JSONHelper.getIntValue(coursesArray.get(i), JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_YEAR));
			Integer creditAmount = JSONHelper.getIntValue(coursesArray.get(i), JSONHelper.convertKeyName(ReceiveCoursesKeys.CREDIT_AMOUNT));
			Boolean deleted = JSONHelper.getBooleanValue(coursesArray.get(i), JSONHelper.convertKeyName(ReceiveCoursesKeys.DELETED));
			String department = JSONHelper.getStringValue(coursesArray.get(i), JSONHelper.convertKeyName(ReceiveCoursesKeys.DEPARTMENT));
			Integer courseNumber = JSONHelper.getIntValue(coursesArray.get(i), JSONHelper.convertKeyName(ReceiveCoursesKeys.COURSE_NUMBER));

			CourseInfo course = new CourseInfo();
			course.setId(id);
			course.setCourseName(courseName);
			course.setRequiredFrequencyPerTerm(requiredFrequencyPerTerm);
			course.setRequiredFrequencyPerSemester(requiredFrequencyPerSemester);
			course.setRequiredFrequencyPerYear(requiredFrequencyPerYear);
			course.setCreditAmount(creditAmount);
			course.setDeleted(deleted);
			course.setDepartment(department);
			course.setCourseNumber(courseNumber);
			
			courses.add(course);
		}
		
		for(int i = 0; i < sections.size(); i++)
		{
			Integer id = JSONHelper.getIntValue(sectionsArray.get(i), JSONHelper.convertKeyName(ReceiveSectionsKeys.ID));
			Integer sectionNumber = JSONHelper.getIntValue(sectionsArray.get(i), JSONHelper.convertKeyName(ReceiveSectionsKeys.SECTION_NUMBER));
			String sectionType = JSONHelper.getStringValue(sectionsArray.get(i), JSONHelper.convertKeyName(ReceiveSectionsKeys.SECTION_TYPE));
			Integer instructorInfoId = JSONHelper.getIntValue(sectionsArray.get(i), JSONHelper.convertKeyName(ReceiveSectionsKeys.INSTRUCTOR_INFO_ID));
			String location = JSONHelper.getStringValue(sectionsArray.get(i), JSONHelper.convertKeyName(ReceiveSectionsKeys.LOCATION));
			Boolean deleted = JSONHelper.getBooleanValue(sectionsArray.get(i), JSONHelper.convertKeyName(ReceiveSectionsKeys.DELETED));
			Integer courseInfoId = JSONHelper.getIntValue(sectionsArray.get(i), JSONHelper.convertKeyName(ReceiveSectionsKeys.COURSE_INFO_ID));
			Integer calendarInfoId = JSONHelper.getIntValue(sectionsArray.get(i), JSONHelper.convertKeyName(ReceiveSectionsKeys.CALENDAR_INFO_ID));
			
			SectionInfo section = new SectionInfo();
			section.setId(id);
			section.setSectionNumber(sectionNumber);
			section.setSectionType(sectionType);
			section.setInstructorInfoId(instructorInfoId);
			section.setLocation(location);
			section.setDeleted(deleted);
			section.setCourseInfoId(courseInfoId);
			section.setCalendarInfoId(calendarInfoId);
			
			sections.add(section);
		}
		
		for(int i = 0; i < calendars.size(); i++)
		{
			Integer id = JSONHelper.getIntValue(calendarArray.get(i), JSONHelper.convertKeyName(ReceiveCalendarsKeys.ID));
			Integer year = JSONHelper.getIntValue(calendarArray.get(i), JSONHelper.convertKeyName(ReceiveCalendarsKeys.YEAR));
			String semester = JSONHelper.getStringValue(calendarArray.get(i), JSONHelper.convertKeyName(ReceiveCalendarsKeys.SEMESTER));
			String days = JSONHelper.getStringValue(calendarArray.get(i), JSONHelper.convertKeyName(ReceiveCalendarsKeys.DAYS));
			Integer startTime = JSONHelper.getIntValue(calendarArray.get(i), JSONHelper.convertKeyName(ReceiveCalendarsKeys.START_TIME));
			Integer endTime = JSONHelper.getIntValue(calendarArray.get(i), JSONHelper.convertKeyName(ReceiveCalendarsKeys.END_TIME));
			Integer term = JSONHelper.getIntValue(calendarArray.get(i), JSONHelper.convertKeyName(ReceiveCalendarsKeys.TERM));

			CalendarInfo calendar = new CalendarInfo();
			calendar.setId(id);
			calendar.setYear(year);
			calendar.setSemester(semester);
			calendar.setStartTime(startTime);
			calendar.setEndTime(endTime);
			calendar.setTerm(term);
			
			calendars.add(calendar);
			
		}
		
		for(int i = 0; i < labs.size(); i++)
		{
			Integer id = JSONHelper.getIntValue(labArray.get(i), JSONHelper.convertKeyName(ReceiveLabsKeys.ID));
			Integer sectionInfoId = JSONHelper.getIntValue(labArray.get(i), JSONHelper.convertKeyName(ReceiveLabsKeys.SECTION_INFO_ID));
			Integer instructorInfoId = JSONHelper.getIntValue(labArray.get(i), JSONHelper.convertKeyName(ReceiveLabsKeys.INSTRUCTOR_INFO_ID));
			String location = JSONHelper.getStringValue(labArray.get(i), JSONHelper.convertKeyName(ReceiveLabsKeys.LOCATION));
			Integer calendarInfoId = JSONHelper.getIntValue(labArray.get(i), JSONHelper.convertKeyName(ReceiveLabsKeys.CALENDAR_INFO_ID));
			
			LabInfo lab = new LabInfo();
			lab.setId(id);
			lab.setSectionInfoId(sectionInfoId);
			lab.setInstructorInfoId(instructorInfoId);
			lab.setLocation(location);
			lab.setCalendarInfoId(calendarInfoId);
			
			labs.add(lab);
		}
		
		ReceiveSchedulesCoursesAction action = new ReceiveSchedulesCoursesAction(courses, sections, calendars, labs);
		return action;
	}
	
}
