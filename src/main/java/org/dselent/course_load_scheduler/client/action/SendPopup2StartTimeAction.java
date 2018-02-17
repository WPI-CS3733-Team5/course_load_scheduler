package org.dselent.course_load_scheduler.client.action;

public class SendPopup2StartTimeAction {
	
	private String startTime;
	
	public SendPopup2StartTimeAction (String startTime) {
		this.startTime = startTime;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendPopup2StartTimeAction [startTime=");
		builder.append(startTime);
		builder.append("]");
		return builder.toString();
	}

}
