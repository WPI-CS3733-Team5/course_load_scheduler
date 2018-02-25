package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.ScheduleLinks;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;

public class ReceiveSchedulesAction extends Action{
	private ArrayList<InstructorInfo> instructors;
	private ArrayList<UserInfo> users;
	private ArrayList<CourseInfo> courses;
	private ArrayList<SectionInfo> sections;
	private ArrayList<LabInfo> labs;
	private ArrayList<CalendarInfo> calendars;
	private ArrayList<ScheduleLinks> schedules;
	
	public ReceiveSchedulesAction(ArrayList<InstructorInfo> instructors,
			ArrayList<UserInfo> users,
			ArrayList<CourseInfo> courses,
			ArrayList<SectionInfo> sections,
			ArrayList<LabInfo> labs,
			ArrayList<CalendarInfo> calendars,
			ArrayList<ScheduleLinks> schedules)
	{
		this.instructors = instructors;
		this.users = users;
		this.courses = courses;
		this.sections = sections;
		this.labs = labs;
		this.calendars = calendars;
		this.schedules = schedules;
	}

	public ArrayList<InstructorInfo> getInstructors() {
		return instructors;
	}

	public void setInstructors(ArrayList<InstructorInfo> instructors) {
		this.instructors = instructors;
	}

	public ArrayList<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UserInfo> users) {
		this.users = users;
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

	public ArrayList<LabInfo> getLabs() {
		return labs;
	}

	public void setLabs(ArrayList<LabInfo> labs) {
		this.labs = labs;
	}

	public ArrayList<CalendarInfo> getCalendars() {
		return calendars;
	}

	public void setCalendars(ArrayList<CalendarInfo> calendars) {
		this.calendars = calendars;
	}

	public ArrayList<ScheduleLinks> getSchedules() {
		return schedules;
	}

	public void setSchedules(ArrayList<ScheduleLinks> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "ReceiveSchedulesAction [instructors=" + instructors + ", users=" + users + ", courses=" + courses
				+ ", sections=" + sections + ", labs=" + labs + ", calendars=" + calendars + ", schedules=" + schedules
				+ "]";
	}
	
	
}
