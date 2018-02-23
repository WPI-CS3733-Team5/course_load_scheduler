package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;

public class ReceiveSchedulesCoursesAction extends Action{
	
	private ArrayList<CourseInfo> courses;
	private ArrayList<SectionInfo> sections;
	private ArrayList<CalendarInfo> calendars;
	private ArrayList<LabInfo> labs;
	
	public ReceiveSchedulesCoursesAction(ArrayList<CourseInfo> courses, 
			ArrayList<SectionInfo> sections, 
			ArrayList<CalendarInfo> calendars, 
			ArrayList<LabInfo> labs) {
		this.courses = courses;
		this.sections = sections;
		this.calendars = calendars;
		this.labs = labs;
	}

	
	public ArrayList<CourseInfo> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<CourseInfo> courses) {
		this.courses = courses;
	}

	public ArrayList<SectionInfo> getSections() {
		return sections;
	}

	public void setSections(ArrayList<SectionInfo> sections) {
		this.sections = sections;
	}

	public ArrayList<CalendarInfo> getCalendars() {
		return calendars;
	}

	public void setCalendars(ArrayList<CalendarInfo> calendars) {
		this.calendars = calendars;
	}

	public ArrayList<LabInfo> getLabs() {
		return labs;
	}

	public void setLabs(ArrayList<LabInfo> labs) {
		this.labs = labs;
	}

	@Override
	public String toString() {
		return "ReceiveSchedulesAction [courses=" + courses
				+ ", sections=" + sections + ", calendars=" + calendars + ", labs=" + labs + "]";
	}
	
	

}
