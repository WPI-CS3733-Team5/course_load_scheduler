package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;

public class SendGenerateAction extends Action{
	private InstructorInfo instructor;
	private ArrayList<SectionInfo> sections;
	
	public SendGenerateAction(InstructorInfo instructor, ArrayList<SectionInfo> sections) {
		this.instructor = instructor;
		this.sections = sections;
	}
	
	public InstructorInfo getInstructor() {
		return instructor;
	}
	
	public ArrayList<SectionInfo> getSections(){
		return sections;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendGenerateAction [instructor=");
		builder.append(instructor.toString());
		builder.append(" sections=");
		builder.append(sections.toString());
		return builder.toString();
	}
}
