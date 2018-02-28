package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import org.dselent.course_load_scheduler.client.action.ReceiveCoursesAction;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.translator.ReceiveActionTranslator;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendCoursesActionTranslatorImpl implements ReceiveActionTranslator<ReceiveCoursesAction>
{
	@Override
	public ReceiveCoursesAction translateToAction(JSONObject json)
	{
		CourseInfoTranslator courseInfoTranslator = new CourseInfoTranslator();
		SectionInfoTranslator sectionInfoTranslator = new SectionInfoTranslator();
		CalendarInfoTranslator calendarInfoTranslator = new CalendarInfoTranslator();
		LabInfoTranslator labInfoTranslator = new LabInfoTranslator();
		
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
		
		for(int i=0; i<coursesArray.size(); i++)
		{			
			JSONObject tempCourses = coursesArray.isArray().get(i).isObject();
			CourseInfo courseInfo = courseInfoTranslator.translateToModel(tempCourses);
			courses.add(courseInfo);
		}
		
		for(int i=0; i<sections.size(); i++)
		{
			JSONObject tempSections = sectionsArray.isArray().get(i).isObject();
			SectionInfo sectionInfo = sectionInfoTranslator.translateToModel(tempSections);
			sections.add(sectionInfo);
		}
		
		for(int i=0; i<calendarArray.isArray().size(); i++)
		{
			JSONObject tempCalendar = calendarArray.isArray().get(i).isObject();
			CalendarInfo calendarInfo = calendarInfoTranslator.translateToModel(tempCalendar);
			calendars.add(calendarInfo);
		}
		
		for(int i=0; i<labArray.isArray().size(); i++)
		{
			JSONObject tempLabs = labArray.isArray().get(i).isObject();
			LabInfo labInfo = labInfoTranslator.translateToModel(tempLabs);
			labs.add(labInfo);
		}
		
		ReceiveCoursesAction action = new ReceiveCoursesAction(courses, sections, calendars, labs);
		
		return action;
	}
}
