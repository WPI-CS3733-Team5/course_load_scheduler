package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;
import org.dselent.course_load_scheduler.client.action.ReceiveHomeAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.ScheduleLinks;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendHomeActionTranslatorImpl implements ActionTranslator<SendHomeAction, ReceiveHomeAction>
{

	@Override
	public JSONObject translateToJson(SendHomeAction object)
	{
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	
	@Override
	public ReceiveHomeAction translateToAction(JSONObject json)
	{
		return translateToAction(json, 0);
	}
	
	public ReceiveHomeAction translateToAction(JSONObject json, int arrayIndex)
	{
		UserInfoTranslator userInfoTranslator = new UserInfoTranslator();
		InstructorInfoTranslator instructorInfoTranslator = new InstructorInfoTranslator();
		CourseInfoTranslator courseInfoTranslator = new CourseInfoTranslator();
		SectionInfoTranslator sectionInfoTranslator = new SectionInfoTranslator();
		CalendarInfoTranslator calendarInfoTranslator = new CalendarInfoTranslator();
		LabInfoTranslator labInfoTranslator = new LabInfoTranslator();
		ScheduleLinksTranslator scheduleLinksTranslator = new ScheduleLinksTranslator();
		
		JSONValue jsonObject = json.get("success");
		JSONArray mainList = jsonObject.isArray().get(arrayIndex).isArray();
		
		// TODO
		// Might be better to use keys than indices
		
		JSONValue userListObject = mainList.get(0);
		JSONValue instructorListObject = mainList.isArray().get(1);
		JSONValue courseListObject = mainList.isArray().get(2);
		JSONValue labListObject = mainList.isArray().get(3);
		JSONValue sectionListObject = mainList.isArray().get(4);
		JSONValue calendarListObject = mainList.isArray().get(5);
		JSONValue scheduleListObject = mainList.isArray().get(6);
		
		JSONArray userInfoArray = userListObject.isArray();
		JSONArray instructorInfoArray = instructorListObject.isArray();
		JSONArray courseInfoArray = courseListObject.isArray();
		JSONArray sectionInfoArray = sectionListObject.isArray();
		JSONArray labInfoArray = labListObject.isArray();
		JSONArray calendarInfoArray = calendarListObject.isArray();
		JSONArray scheduleLinksArray = scheduleListObject.isArray();
		
		ArrayList<UserInfo> userInfoList = new ArrayList<UserInfo>();
		ArrayList<InstructorInfo> instructorInfoList = new ArrayList<InstructorInfo>();
		ArrayList<CourseInfo> courseInfoList = new ArrayList<CourseInfo>();
		ArrayList<SectionInfo> sectionInfoList = new ArrayList<SectionInfo>();
		ArrayList<LabInfo> labInfoList = new ArrayList<LabInfo>();
		ArrayList<CalendarInfo> calendarInfoList = new ArrayList<CalendarInfo>();
		ArrayList<ScheduleLinks> scheduleLinksList = new ArrayList<ScheduleLinks>();

		for(int i=0; i<userInfoArray.isArray().size(); i++)
		{
			JSONObject tempUser = userInfoArray.get(i).isObject();
			UserInfo userInfo = userInfoTranslator.translateToModel(tempUser);
			userInfoList.add(userInfo);
		}
		
		for(int i=0; i<instructorInfoArray.isArray().size(); i++)
		{
			JSONObject tempInstructor = instructorInfoArray.get(i).isObject();
			InstructorInfo instructorInfo = instructorInfoTranslator.translateToModel(tempInstructor);
			instructorInfoList.add(instructorInfo);
		}
		
		for(int i=0; i<courseInfoArray.isArray().size(); i++)
		{
			JSONObject tempCourse = courseInfoArray.get(i).isObject();
			CourseInfo courseInfo = courseInfoTranslator.translateToModel(tempCourse);
			courseInfoList.add(courseInfo);
		}
		
		for(int i=0; i<sectionInfoArray.isArray().size(); i++)
		{
			JSONObject tempSection = sectionInfoArray.get(i).isObject();
			SectionInfo sectionInfo = sectionInfoTranslator.translateToModel(tempSection);
			sectionInfoList.add(sectionInfo);
		}
		
		for(int i=0; i<labInfoArray.isArray().size(); i++)
		{
			JSONObject tempLab = labInfoArray.get(i).isObject();
			LabInfo labInfo = labInfoTranslator.translateToModel(tempLab);
			labInfoList.add(labInfo);
		}
		
		for(int i=0; i<calendarInfoArray.isArray().size(); i++)
		{
			JSONObject tempCalendar = calendarInfoArray.get(i).isObject();
			CalendarInfo calendarInfo = calendarInfoTranslator.translateToModel(tempCalendar);
			calendarInfoList.add(calendarInfo);
		}
		
		for(int i=0; i<scheduleLinksArray.isArray().size(); i++)
		{
			JSONObject tempSchedule = scheduleLinksArray.get(i).isObject();
			ScheduleLinks scheduleLinks = scheduleLinksTranslator.translateToModel(tempSchedule);
			scheduleLinksList.add(scheduleLinks);
		}
		
		ReceiveHomeAction action = new ReceiveHomeAction(instructorInfoList, userInfoList, courseInfoList, sectionInfoList, labInfoList, calendarInfoList, scheduleLinksList);
		
		return action;
	}
	
}
