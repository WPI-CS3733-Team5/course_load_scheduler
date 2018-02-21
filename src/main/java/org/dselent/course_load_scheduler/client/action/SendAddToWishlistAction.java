package org.dselent.course_load_scheduler.client.action;

public class SendAddToWishlistAction extends Action {
	
	private String department;
	private String courseNumber;
	private String courseSection;
	private String sectionType;
	private String term;
	private String meetingTimes;
	private String location;
	
	public SendAddToWishlistAction(String department, String courseNumber, String courseSection, String sectionType, String term, String meetingTimes, String location) {
		this.department = department;
		this.courseNumber = courseNumber;
		this.courseSection = courseSection;
		this.sectionType = sectionType;
		this.term = term;
		this.meetingTimes = meetingTimes;
		this.location = location;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getCourseNumber(){
		return courseNumber;
	}

	public String getCourseSection() {
		return courseSection;
	}

	public String getSectionType() {
		return sectionType;
	}

	public String getMeetingTimes() {
		return meetingTimes;
	}

	public String getLocation() {
		return location;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendAddToWishlistAction [department=");
		builder.append(department);
		builder.append(", courseNumber=");
		builder.append(courseNumber);
		builder.append(", courseSection=");
		builder.append(courseSection);
		builder.append(", sectionType=");
		builder.append(sectionType);
		builder.append(", term=");
		builder.append(term);
		builder.append(", meetingTimes=");
		builder.append(meetingTimes);
		builder.append(", location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}

}
