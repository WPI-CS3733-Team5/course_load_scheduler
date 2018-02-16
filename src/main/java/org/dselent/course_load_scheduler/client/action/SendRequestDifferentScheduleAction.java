package org.dselent.course_load_scheduler.client.action;

public class SendRequestDifferentScheduleAction {
	
	private String userName;
	private String term;
	
	public SendRequestDifferentScheduleAction(String term, String username) {
		this.term = term;
		this.userName = username;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getTerm()
	{
		return term;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendRequestDifferentScheduleAction [term=");
		builder.append(term);
		builder.append(", userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}
}