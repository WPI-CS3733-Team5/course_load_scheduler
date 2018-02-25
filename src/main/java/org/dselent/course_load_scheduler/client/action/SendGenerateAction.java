package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;

public class SendGenerateAction extends Action{
	private InstructorInfo instructor;
	private ArrayList<SectionInfo> sections;
	private ArrayList<CalendarInfo> calendars;
	
	public SendGenerateAction(InstructorInfo instructor, ArrayList<SectionInfo> sections, ArrayList<CalendarInfo> calendars) {
		this.instructor = instructor;
		this.sections = sections;
		this.calendars = calendars;
	}
	
	public InstructorInfo getInstructor() {
		return instructor;
	}
	
	public ArrayList<SectionInfo> getSections(){
		return sections;
	}

	public ArrayList<CalendarInfo> getCalendars(){
		return calendars;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendGenerateAction [instructor=");
		builder.append(instructor.toString());
		builder.append(" sections=");
		builder.append(sections.toString());
		builder.append(" calendars=");
		builder.append(calendars.toString());
		return builder.toString();
	}
}
