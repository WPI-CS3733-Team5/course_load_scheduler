package org.dselent.course_load_scheduler.client.action;

public class SendSchedulesAction extends Action {
		
	public SendSchedulesAction() {

	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendSchedulesAction");
		return builder.toString();
	}
}
