package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.WishlistLinks;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCalendarsKeys;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCoursesKeys;
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

		JSONArray wishlistArray = wishlistObject.isArray();
		JSONArray calendarArray = calendarObject.isArray();
		JSONArray sectionsArray = sectionsObject.isArray();
		JSONArray courseArray = courseObject.isArray();

		ArrayList<WishlistLinks> wishlists = new ArrayList<>();
		ArrayList<CalendarInfo> calendars = new ArrayList<>();
		ArrayList<SectionInfo> sections = new ArrayList<>();
		ArrayList<CourseInfo> courses = new ArrayList<>();

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
			JSONObject tempSections = calendarArray.isArray().get(i).isObject();

			String location = JSONHelper.getStringValue(tempSections, JSONHelper.convertKeyName(ReceiveSectionsKeys.LOCATION));

			SectionInfo section = new SectionInfo();
			section.setLocation(location);

			sections.add(section);
		}

		for(int i = 0; i < courseArray.size(); i++) {

			JSONObject tempCourses = calendarArray.isArray().get(i).isObject();

			String courseName = JSONHelper.getStringValue(tempCourses, JSONHelper.convertKeyName(ReceiveCoursesKeys.COURSE_NAME));

			CourseInfo course = new CourseInfo();
			course.setCourseName(courseName);

			courses.add(course);
		}

		ReceiveWishlistAction action = new ReceiveWishlistAction(wishlists,calendars,sections,courses);
		return action;	

	}

}