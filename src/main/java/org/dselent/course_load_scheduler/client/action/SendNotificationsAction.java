package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendNotificationsAction {
	
	HasWidgets panel;
	
	public SendNotificationsAction(HasWidgets panel) {
		this.panel = panel;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendNotificationsAction");
		return builder.toString();
	}

	public HasWidgets getPanel() {
		return this.panel;
	}
	
	public void setPanel(HasWidgets panel) {
		this.panel = panel;
	}
}
