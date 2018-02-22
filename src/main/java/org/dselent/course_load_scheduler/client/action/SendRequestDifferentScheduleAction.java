package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendRequestDifferentScheduleAction extends Action {
	
	private String userName;
	private String term;
	private HasWidgets panel;
	
	public SendRequestDifferentScheduleAction(String term, String username, HasWidgets panel) {
		this.term = term;
		this.userName = username;
		this.panel = panel;
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

	public HasWidgets getPanel() {
		return panel;
	}
}