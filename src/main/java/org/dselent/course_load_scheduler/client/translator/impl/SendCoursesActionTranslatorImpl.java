package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import java.util.Date;

import org.dselent.course_load_scheduler.client.action.ReceiveCoursesAction;
import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.action.ReceiveProfileAction;
import org.dselent.course_load_scheduler.client.action.SendCoursesAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCoursesKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveProfileKeys;
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
		JSONObject sectionsObject = jsonObject.isArray().get(0).isObject();
		
		JSONArray coursesArray = coursesObject.isArray();
		JSONArray sectionsArray = sectionsObject.isArray();
		
		ArrayList<CourseInfo> courses = new ArrayList<>();
		ArrayList<SectionInfo> sections = new ArrayList<>();
		
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
		
		ReceiveCoursesAction action = new ReceiveCoursesAction(courses, sections);
		return action;
	}
}
