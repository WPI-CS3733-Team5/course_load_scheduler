package org.dselent.course_load_scheduler.client.translator.impl;

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
		

		
		Integer id = JSONHelper.getIntValue(wishlistObject, JSONHelper.convertKeyName(ReceiveWishlistKeys.ID));
		Integer instructorInfoId= JSONHelper.getIntValue(wishlistObject, JSONHelper.convertKeyName(ReceiveWishlistKeys.INSTRUCTOR_INFO_ID));
		Integer sectionInfoId = JSONHelper.getIntValue(wishlistObject, JSONHelper.convertKeyName(ReceiveWishlistKeys.SECTION_INFO_ID));
		Integer startTime = JSONHelper.getIntValue(wishlistObject, JSONHelper.convertKeyName(ReceiveCalendarsKeys.START_TIME));
		Integer endTime = JSONHelper.getIntValue(wishlistObject, JSONHelper.convertKeyName(ReceiveCalendarsKeys.END_TIME));
		Integer term = JSONHelper.getIntValue(wishlistObject, JSONHelper.convertKeyName(ReceiveCalendarsKeys.TERM));
		Integer year = JSONHelper.getIntValue(wishlistObject, JSONHelper.convertKeyName(ReceiveCalendarsKeys.YEAR));
		String location = JSONHelper.getStringValue(wishlistObject, JSONHelper.convertKeyName(ReceiveSectionsKeys.LOCATION));
		String courseName = JSONHelper.getStringValue(wishlistObject, JSONHelper.convertKeyName(ReceiveCoursesKeys.COURSE_NAME));
		
		// TODO look into time conversion more
		// put into JSONHelper?
		
		WishlistLinks wishlist = new WishlistLinks();
		wishlist.setId(id);
		wishlist.setInstructorInfoId(instructorInfoId);
		wishlist.setSectionInfoId(sectionInfoId);
		
		CalendarInfo calendar = new CalendarInfo();
		calendar.setStartTime(startTime);
		calendar.setEndTime(endTime);
		calendar.setTerm(term);
		calendar.setYear(year);
		
		SectionInfo section = new SectionInfo();
		section.setLocation(location);
		
		CourseInfo course = new CourseInfo();
		course.setCourseName(courseName);
		
		
		ReceiveWishlistAction action = new ReceiveWishlistAction(wishlist,calendar,section,course);
		return action;	
		
	}

}