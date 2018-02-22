package org.dselent.course_load_scheduler.client.action;

public class SendPopup2EndTimeAction extends Action {
	
	private String endTime;
	
	public SendPopup2EndTimeAction(String endTime) {
		this.endTime = endTime;
	}

	public String getEndTime() {
		return endTime;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendPopup2EndTimeAction [endTime=");
		builder.append(endTime);
		builder.append("]");
		return builder.toString();
	}


}
