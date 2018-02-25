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
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCalendarsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCoursesKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveInstructorInfoKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLabsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSchedulesKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSectionsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveUserInfoKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class SendHomeActionTranslatorImpl implements ActionTranslator<SendHomeAction, ReceiveHomeAction>
{

	@Override
	public JSONObject translateToJson(SendHomeAction object) {
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
	}

	@Override
	public ReceiveHomeAction translateToAction(JSONObject json) {
		JSONValue jsonObject = json.get("success");
		
		JSONObject userListObject = jsonObject.isArray().get(0).isObject();
		JSONObject instructorListObject = jsonObject.isArray().get(1).isObject();
		JSONObject courseListObject = jsonObject.isArray().get(2).isObject();
		JSONObject sectionListObject = jsonObject.isArray().get(3).isObject();
		JSONObject labListObject = jsonObject.isArray().get(4).isObject();
		JSONObject calendarListObject = jsonObject.isArray().get(5).isObject();
		JSONObject scheduleListObject = jsonObject.isArray().get(6).isObject();
		
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

		for(int i = 0; i < userInfoArray.isArray().size(); i++) {
			
			JSONObject tempUser = userInfoArray.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.ID));
			String userName = JSONHelper.getStringValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.USER_NAME));
			String firstName = JSONHelper.getStringValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.FIRST_NAME));
			String lastName = JSONHelper.getStringValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.LAST_NAME));
			String email = JSONHelper.getStringValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.EMAIL));
			Integer accountState = JSONHelper.getIntValue(tempUser, JSONHelper.convertKeyName(ReceiveUserInfoKeys.ACCOUNT_STATE));
			
			UserInfo user = new UserInfo();
			user.setId(id);
			user.setUserName(userName);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setAccountState(accountState);
			
			userInfoList.add(user);
		}
		
		for(int i = 0; i < instructorInfoArray.isArray().size(); i++) {
			
			JSONObject tempInstructor = instructorInfoArray.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.ID));
			Integer rank = JSONHelper.getIntValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.RANK));
			Integer courseLoad = JSONHelper.getIntValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.COURSE_LOAD));
			String office = JSONHelper.getStringValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.OFFICE));
			Integer userInfoId = JSONHelper.getIntValue(tempInstructor, JSONHelper.convertKeyName(ReceiveInstructorInfoKeys.USER_INFO_ID));
		
			InstructorInfo instructor = new InstructorInfo();
			instructor.setId(id);
			instructor.setRank(rank);
			instructor.setCourseLoad(courseLoad);
			instructor.setOffice(office);
			instructor.setUserInfoId(userInfoId);
			
			instructorInfoList.add(instructor);
		}
		
		for(int i = 0; i < courseInfoArray.isArray().size(); i++) {
			
			JSONObject tempCourse = courseInfoArray.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempCourse, JSONHelper.convertKeyName(ReceiveCoursesKeys.ID));
			String courseName = JSONHelper.getStringValue(tempCourse, JSONHelper.convertKeyName(ReceiveCoursesKeys.COURSE_NAME));
			Integer requiredFrequencyPerTerm = JSONHelper.getIntValue(tempCourse, JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_TERM));
			Integer requiredFrequencyPerSemester = JSONHelper.getIntValue(tempCourse, JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_SEMESTER));
			Integer requiredFrequencyPerYear = JSONHelper.getIntValue(tempCourse, JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_YEAR));
			Integer creditAmount = JSONHelper.getIntValue(tempCourse, JSONHelper.convertKeyName(ReceiveCoursesKeys.CREDIT_AMOUNT));
			Boolean deleted = JSONHelper.getBooleanValue(tempCourse, JSONHelper.convertKeyName(ReceiveCoursesKeys.DELETED));
			String department = JSONHelper.getStringValue(tempCourse, JSONHelper.convertKeyName(ReceiveCoursesKeys.DEPARTMENT));
			Integer courseNumber = JSONHelper.getIntValue(tempCourse, JSONHelper.convertKeyName(ReceiveCoursesKeys.COURSE_NUMBER));

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
			
			courseInfoList.add(course);
		}
		
		for(int i = 0; i < sectionInfoArray.isArray().size(); i++) {
			
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
			
			sectionInfoList.add(section);
		}
		
		for(int i = 0; i < labInfoArray.isArray().size(); i++) {
			JSONObject tempLab = labInfoArray.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempLab, JSONHelper.convertKeyName(ReceiveLabsKeys.ID));
			Integer sectionInfoId = JSONHelper.getIntValue(tempLab, JSONHelper.convertKeyName(ReceiveLabsKeys.SECTION_INFO_ID));
			Integer instructorInfoId = JSONHelper.getIntValue(tempLab, JSONHelper.convertKeyName(ReceiveLabsKeys.INSTRUCTOR_INFO_ID));
			String location = JSONHelper.getStringValue(tempLab, JSONHelper.convertKeyName(ReceiveLabsKeys.LOCATION));
			Integer calendarInfoId = JSONHelper.getIntValue(tempLab, JSONHelper.convertKeyName(ReceiveLabsKeys.CALENDAR_INFO_ID));

			LabInfo lab = new LabInfo();
			lab.setId(id);
			lab.setSectionInfoId(sectionInfoId);
			lab.setInstructorInfoId(instructorInfoId);
			lab.setLocation(location);
			lab.setCalendarInfoId(calendarInfoId);
			
			labInfoList.add(lab);
		}
		
		for(int i = 0; i <calendarInfoArray.isArray().size(); i++) {
			JSONObject tempCalendar = calendarInfoArray.get(i).isObject();
			
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
			calendar.setDays(days);
			calendar.setStartTime(startTime);
			calendar.setEndTime(endTime);
			calendar.setTerm(term);
			
			calendarInfoList.add(calendar);
		}
		
		for(int i = 0; i < scheduleLinksArray.isArray().size(); i++) {
			JSONObject tempSchedule = scheduleLinksArray.get(i).isObject();
			
			Integer id = JSONHelper.getIntValue(tempSchedule, JSONHelper.convertKeyName(ReceiveSchedulesKeys.ID));
			Integer instructorInfoId = JSONHelper.getIntValue(tempSchedule, JSONHelper.convertKeyName(ReceiveSchedulesKeys.INSTRUCTOR_INFO_ID));
			Integer sectionInfoId = JSONHelper.getIntValue(tempSchedule, JSONHelper.convertKeyName(ReceiveSchedulesKeys.SECTION_INFO_ID));

			ScheduleLinks schedule = new ScheduleLinks();
			schedule.setId(id);
			schedule.setInstructorInfoId(instructorInfoId);
			schedule.setSectionInfoId(sectionInfoId);
			
			scheduleLinksList.add(schedule);
		}
		
		ReceiveHomeAction action = new ReceiveHomeAction(instructorInfoList, userInfoList, courseInfoList, sectionInfoList, labInfoList, calendarInfoList, scheduleLinksList);
		
		return action;
		
	}
	
}
