package org.dselent.course_load_scheduler.client.translator.impl;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.WishlistLinks;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
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
		CourseInfoTranslator courseInfoTranslator = new CourseInfoTranslator();
		SectionInfoTranslator sectionInfoTranslator = new SectionInfoTranslator();
		CalendarInfoTranslator calendarInfoTranslator = new CalendarInfoTranslator();
		LabInfoTranslator labInfoTranslator = new LabInfoTranslator();
		WishlistLinksTranslator wishlistLinksTranslator = new WishlistLinksTranslator();

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

		for(int i = 0; i < wishlistArray.size(); i++)
		{
			JSONObject tempWishlists = wishlistArray.isArray().get(i).isObject();
			WishlistLinks wishlistLinks = wishlistLinksTranslator.translateToModel(tempWishlists);
			wishlists.add(wishlistLinks);
		}

		for(int i = 0; i < calendarArray.size(); i++)
		{
			JSONObject tempCalendars = calendarArray.isArray().get(i).isObject();
			CalendarInfo calendarInfo = calendarInfoTranslator.translateToModel(tempCalendars);
			calendars.add(calendarInfo);
		}
		
		for(int i = 0; i < sectionsArray.size(); i++)
		{
			JSONObject tempSections = sectionsArray.isArray().get(i).isObject();
			SectionInfo sectionInfo = sectionInfoTranslator.translateToModel(tempSections);
			sections.add(sectionInfo);
		}

		for(int i = 0; i < courseArray.size(); i++)
		{
			JSONObject tempCourses = courseArray.isArray().get(i).isObject();
			CourseInfo courseInfo = courseInfoTranslator.translateToModel(tempCourses);
			courses.add(courseInfo);
		}
		
		for (int i = 0; i < labsArray.size(); i++)
		{
			JSONObject tempLab = labsArray.isArray().get(i).isObject();
			LabInfo labInfo = labInfoTranslator.translateToModel(tempLab);
			labs.add(labInfo);
		}

		ReceiveWishlistAction action = new ReceiveWishlistAction(wishlists,calendars,sections,courses,labs);
		
		return action;	
	}

}