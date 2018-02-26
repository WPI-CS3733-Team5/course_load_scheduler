package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.WishlistLinks;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCalendarsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCoursesKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLabsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveSectionsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveWishlistKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;


public class SendWishlistActionTranslatorImpl implements ActionTranslator<SendWishlistAction, ReceiveWishlistAction>
{
	@Override
	public JSONObject translateToJson(SendWishlistAction action)
	{
		JSONObject jsonObject = new JSONObject();
		return jsonObject;

	}

	@Override
	public ReceiveWishlistAction translateToAction(JSONObject json)
	{

		JSONValue jsonObject = json.get("success");
		JSONObject wishlistObject = jsonObject.isArray().get(0).isObject();
		JSONObject calendarObject = jsonObject.isArray().get(1).isObject();
		JSONObject sectionsObject = jsonObject.isArray().get(2).isObject();
		JSONObject courseObject = jsonObject.isArray().get(3).isObject();
		JSONObject labsObject = jsonObject.isArray().get(4).isObject();

		JSONArray wishlistArray = wishlistObject.isArray();
		JSONArray calendarArray = calendarObject.isArray();
		JSONArray sectionsArray = sectionsObject.isArray();
		JSONArray courseArray = courseObject.isArray();
		JSONArray labsArray = labsObject.isArray();

		ArrayList<WishlistLinks> wishlists = new ArrayList<>();
		ArrayList<CalendarInfo> calendars = new ArrayList<>();
		ArrayList<SectionInfo> sections = new ArrayList<>();
		ArrayList<CourseInfo> courses = new ArrayList<>();
		ArrayList<LabInfo> labs = new ArrayList<>();

		for(int i = 0; i < wishlistArray.size(); i++) {
			JSONObject tempWishlists = wishlistArray.isArray().get(i).isObject();

			Integer id = JSONHelper.getIntValue(tempWishlists, JSONHelper.convertKeyName(ReceiveWishlistKeys.ID));
			Integer instructorInfoId= JSONHelper.getIntValue(tempWishlists, JSONHelper.convertKeyName(ReceiveWishlistKeys.INSTRUCTOR_INFO_ID));
			Integer sectionInfoId = JSONHelper.getIntValue(tempWishlists, JSONHelper.convertKeyName(ReceiveWishlistKeys.SECTION_INFO_ID));

			WishlistLinks wishlist = new WishlistLinks();
			wishlist.setId(id);
			wishlist.setInstructorInfoId(instructorInfoId);
			wishlist.setSectionInfoId(sectionInfoId);

			wishlists.add(wishlist);
		}

		for(int i = 0; i < calendarArray.size(); i++) {
			JSONObject tempCalendars = calendarArray.isArray().get(i).isObject();

			Integer startTime = JSONHelper.getIntValue(tempCalendars, JSONHelper.convertKeyName(ReceiveCalendarsKeys.START_TIME));
			Integer endTime = JSONHelper.getIntValue(tempCalendars, JSONHelper.convertKeyName(ReceiveCalendarsKeys.END_TIME));
			Integer term = JSONHelper.getIntValue(tempCalendars, JSONHelper.convertKeyName(ReceiveCalendarsKeys.TERM));
			Integer year = JSONHelper.getIntValue(tempCalendars, JSONHelper.convertKeyName(ReceiveCalendarsKeys.YEAR));

			CalendarInfo calendar = new CalendarInfo();
			calendar.setStartTime(startTime);
			calendar.setEndTime(endTime);
			calendar.setTerm(term);
			calendar.setYear(year);

			calendars.add(calendar);
		}
		for(int i = 0; i < sectionsArray.size(); i++) {
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

		for(int i = 0; i < courseArray.size(); i++) {

			JSONObject tempCourses = courseArray.isArray().get(i).isObject();

			Integer id = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.ID));
			String courseName = JSONHelper.getStringValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.COURSE_NAME));
			Integer requiredFrequencyPerTerm = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_TERM));
			Integer requiredFrequencyPerSemester = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_SEMESTER));
			Integer requiredFrequencyPerYear = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_YEAR));
			Integer creditAmount = JSONHelper.getIntValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.CREDIT_AMOUNT));
			Boolean deleted = JSONHelper.getBooleanValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.DELETED));
			String department = JSONHelper.getStringValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.DELETED));
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
		
		for (int i = 0; i < labsArray.size(); i++) {
			JSONObject tempLab = labsArray.isArray().get(i).isObject();

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

			labs.add(lab);
		}

		ReceiveWishlistAction action = new ReceiveWishlistAction(wishlists,calendars,sections,courses,labs);
		return action;	

	}

}