package org.dselent.course_load_scheduler.client.action;

public class SendRemoveSelectedFromWishlistAction extends Action {
	
	private String courseNumber;
	private String meetingTimes;
	
	public SendRemoveSelectedFromWishlistAction(String courseNumber, String meetingTimes) {
		this.courseNumber = courseNumber;
		this.meetingTimes = meetingTimes;
	}
	
	public String getCourseNumber()
	{
		return courseNumber;
	}
	
	public String getMeetingTimes()
	{
		return meetingTimes;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendRemoveSelectedFromWishlistAction [courseNumber=");
		builder.append(courseNumber);
		builder.append(", meetingTimes=");
		builder.append(meetingTimes);
		builder.append("]");
		return builder.toString();
	}

}
