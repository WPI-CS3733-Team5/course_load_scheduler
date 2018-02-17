package org.dselent.course_load_scheduler.client.action;

public class SendMeetingTimesAction {
	
private String meetingTimes;
	
	public SendMeetingTimesAction(String meetingTimes) {
		this.meetingTimes = meetingTimes;
	}

	public String getMeetingTimes() {
		return meetingTimes;
	}

	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendMeetingTimesAction [meetingTimes=");
		builder.append(meetingTimes);
		builder.append("]");
		return builder.toString();
	}

}
