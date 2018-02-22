package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;

public class ReceiveCoursesAction extends Action{

	private ArrayList<CourseInfo> courses;
	private ArrayList<SectionInfo> sections;
	
	public ReceiveCoursesAction(ArrayList<CourseInfo> courses, ArrayList<SectionInfo> sections) {
		this.courses = courses;
		this.sections = sections;
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

	@Override
	public String toString() {
		return "ReceiveCoursesAction [courses=" + courses + ", sections=" + sections + "]";
	}
}
