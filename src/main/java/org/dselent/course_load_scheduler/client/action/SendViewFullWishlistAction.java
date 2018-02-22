package org.dselent.course_load_scheduler.client.action;

//Same as SendWishlistAction, TODO is to deprecate this and change all calls to SendWishlistAction

public class SendViewFullWishlistAction {
	
	private String courseNumber;
	private String meetingTimes;
	
	public SendViewFullWishlistAction(String courseNumber, String meetingTimes) {
		this.courseNumber = courseNumber;
		this.meetingTimes = meetingTimes;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	
	public String getMeetingTimes() {
		return meetingTimes;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendViewFullWishlistAction [courseNumber =");
		builder.append(courseNumber);
		builder.append(", meetingTimes=");
		builder.append(meetingTimes);
		builder.append("]");
		return builder.toString();
	}
	

}
