package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.WishlistLinks;

public class ReceiveWishlistAction extends Action{
	
	private ArrayList<WishlistLinks> wishlists;
	private ArrayList<CalendarInfo> calendars;
	private ArrayList<SectionInfo> sections;
	private ArrayList<CourseInfo> courses;

		public ReceiveWishlistAction(ArrayList<WishlistLinks> wishlists, ArrayList<CalendarInfo> calendars, ArrayList<SectionInfo> sections, ArrayList<CourseInfo> courses)
	{
		this.setWishlists(wishlists);
		this.setCalendars(calendars);
		this.setSections(sections);
		this.setCourses(courses);
	}

		public ArrayList<WishlistLinks> getWishlists() {
		return wishlists;
	}



	public void setWishlists(ArrayList<WishlistLinks> wishlists) {
		this.wishlists = wishlists;
	}



	public ArrayList<CalendarInfo> getCalendars() {
		return calendars;
	}



	public void setCalendars(ArrayList<CalendarInfo> calendars) {
		this.calendars = calendars;
	}



	public ArrayList<SectionInfo> getSections() {
		return sections;
	}



	public void setSections(ArrayList<SectionInfo> sections) {
		this.sections = sections;
	}



	public ArrayList<CourseInfo> getCourses() {
		return courses;
	}



	public void setCourses(ArrayList<CourseInfo> courses) {
		this.courses = courses;
	}
	@Override
	public String toString()
	{
		return "ReceiveWishlistAction [wishlists=" + wishlists + ", calendars=" + calendars+ ", sections=" + sections+ ", courses=" + courses + "]";
	}
}

