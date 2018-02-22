package org.dselent.course_load_scheduler.client.action;

public class SendSortCoursesAction extends Action {
	
	private String department;
	private String term;
	private String courseNumber;
	
	public SendSortCoursesAction(String department, String term, String courseNumber) {
		this.department = department;
		this.term = term;
		this.courseNumber = courseNumber;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getTerm() {
		return term;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendSortCoursesAction [department=");
		builder.append(department);
		builder.append(", term=");
		builder.append(term);
		builder.append(", courseNumber=");
		builder.append(courseNumber);
		builder.append("]");
		return builder.toString();
	}

}
