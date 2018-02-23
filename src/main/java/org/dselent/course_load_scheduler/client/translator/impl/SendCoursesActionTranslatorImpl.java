package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import org.dselent.course_load_scheduler.client.action.ReceiveCoursesAction;
import org.dselent.course_load_scheduler.client.action.SendCoursesAction;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCalendarsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCoursesKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLabsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSectionsKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendCoursesActionTranslatorImpl implements ActionTranslator<SendCoursesAction, ReceiveCoursesAction> {
	
	@Override
	public JSONObject translateToJson(SendCoursesAction object) {
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveCoursesAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		JSONObject coursesObject = jsonObject.isArray().get(0).isObject();
		JSONObject sectionsObject = jsonObject.isArray().get(1).isObject();
		JSONObject calendarObject = jsonObject.isArray().get(2).isObject();
		JSONObject labObject = jsonObject.isArray().get(3).isObject();
		
		JSONArray coursesArray = coursesObject.isArray();
		JSONArray sectionsArray = sectionsObject.isArray();
		JSONArray calendarArray = calendarObject.isArray();
		JSONArray labArray = labObject.isArray();
		
		ArrayList<CourseInfo> courses = new ArrayList<>();
		ArrayList<SectionInfo> sections = new ArrayList<>();
		ArrayList<CalendarInfo> calendars = new ArrayList<>();
		ArrayList<LabInfo> labs = new ArrayList<>();
		
		for(int i = 0; i < coursesArray.size(); i++) {
			
			JSONObject tempCourses = coursesArray.isArray().get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.ID));
			String courseName = JSONHelper.getStringValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.COURSE_NAME));
			Integer requiredFrequencyPerTerm = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_TERM));
			Integer requiredFrequencyPerSemester = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_SEMESTER));
			Integer requiredFrequencyPerYear = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_YEAR));
			Integer creditAmount = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.CREDIT_AMOUNT));
			Boolean deleted = JSONHelper.getBooleanValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.DELETED));
			String department = JSONHelper.getStringValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.DEPARTMENT));
			Integer courseNumber = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.COURSE_NUMBER));

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
			
			JSONObject tempSections = sectionsArray.isArray().get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempSections, JSONHelper.convertKeyName(ReceiveSectionsKeys.ID));
			Integer sectionNumber = JSONHelper.getIntValue(tempSections, JSONHelper.convertKeyName(ReceiveSectionsKeys.SECTION_NUMBER));
			String sectionType = JSONHelper.getStringValue(tempSections, JSONHelper.convertKeyName(ReceiveSectionsKeys.SECTION_TYPE));
			Integer instructorInfoId = JSONHelper.getIntValue(tempSections, JSONHelper.convertKeyName(ReceiveSectionsKeys.INSTRUCTOR_INFO_ID));
			String location = JSONHelper.getStringValue(tempSections, JSONHelper.convertKeyName(ReceiveSectionsKeys.LOCATION));
			Boolean deleted = JSONHelper.getBooleanValue(tempSections, JSONHelper.convertKeyName(ReceiveSectionsKeys.DELETED));
			Integer courseInfoId = JSONHelper.getIntValue(tempSections, JSONHelper.convertKeyName(ReceiveSectionsKeys.COURSE_INFO_ID));
			Integer calendarInfoId = JSONHelper.getIntValue(tempSections, JSONHelper.convertKeyName(ReceiveSectionsKeys.CALENDAR_INFO_ID));
			
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
		
		for(int i = 0; i < calendarArray.isArray().size(); i++)
		{
			
			JSONObject tempCalendar = calendarArray.isArray().get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempCalendar, JSONHelper.convertKeyName(ReceiveCalendarsKeys.ID));
			Integer year = JSONHelper.getIntValue(tempCalendar, JSONHelper.convertKeyName(ReceiveCalendarsKeys.YEAR));
			String semester = JSONHelper.getStringValue(tempCalendar, JSONHelper.convertKeyName(ReceiveCalendarsKeys.SEMESTER));
			String days = JSONHelper.getStringValue(tempCalendar, JSONHelper.convertKeyName(ReceiveCalendarsKeys.DAYS));
			Integer startTime = JSONHelper.getIntValue(tempCalendar, JSONHelper.convertKeyName(ReceiveCalendarsKeys.START_TIME));
			Integer endTime = JSONHelper.getIntValue(tempCalendar, JSONHelper.convertKeyName(ReceiveCalendarsKeys.END_TIME));
			Integer term = JSONHelper.getIntValue(tempCalendar, JSONHelper.convertKeyName(ReceiveCalendarsKeys.TERM));

			CalendarInfo calendar = new CalendarInfo();
			calendar.setId(id);
			calendar.setYear(year);
			calendar.setSemester(semester);
			calendar.setStartTime(startTime);
			calendar.setEndTime(endTime);
			calendar.setTerm(term);
			
			calendars.add(calendar);
			
		}
		
		for(int i = 0; i < labArray.isArray().size(); i++)
		{
			
			JSONObject tempLabs = labArray.isArray().get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempLabs, JSONHelper.convertKeyName(ReceiveLabsKeys.ID));
			Integer sectionInfoId = JSONHelper.getIntValue(tempLabs, JSONHelper.convertKeyName(ReceiveLabsKeys.SECTION_INFO_ID));
			Integer instructorInfoId = JSONHelper.getIntValue(tempLabs, JSONHelper.convertKeyName(ReceiveLabsKeys.INSTRUCTOR_INFO_ID));
			String location = JSONHelper.getStringValue(tempLabs, JSONHelper.convertKeyName(ReceiveLabsKeys.LOCATION));
			Integer calendarInfoId = JSONHelper.getIntValue(tempLabs, JSONHelper.convertKeyName(ReceiveLabsKeys.CALENDAR_INFO_ID));
			
			LabInfo lab = new LabInfo();
			lab.setId(id);
			lab.setSectionInfoId(sectionInfoId);
			lab.setInstructorInfoId(instructorInfoId);
			lab.setLocation(location);
			lab.setCalendarInfoId(calendarInfoId);
			
			labs.add(lab);
		}
		
		ReceiveCoursesAction action = new ReceiveCoursesAction(courses, sections, calendars, labs);
		return action;
	}
}
