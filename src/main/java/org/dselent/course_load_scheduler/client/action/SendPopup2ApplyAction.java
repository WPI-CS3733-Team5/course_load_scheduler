package org.dselent.course_load_scheduler.client.action;


public class SendPopup2ApplyAction {
	
	private String meetingTimes;
	private String meetingDays;
	
	public SendPopup2ApplyAction(String meetingTimes, String meetingDays){
		this.meetingTimes = meetingTimes;
		this.meetingDays = meetingDays;
	}
	
	public String getMeetingTimes() {
		return meetingTimes;
	}
	
	public String getMeetingDays(){
		return meetingDays;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendPopup2ApplyAction [meetingTimes=");
		builder.append(meetingTimes);
		builder.append(", meetingDays=");
		builder.append(meetingDays);
		builder.append("]");
		return builder.toString();
	}
		

}
