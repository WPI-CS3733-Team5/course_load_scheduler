package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendSchedulesAction extends Action{
	
	HasWidgets panel;
	
	public SendSchedulesAction(HasWidgets panel) {
		this.panel = panel;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendSchedulesAction");
		return builder.toString();
	}

	public HasWidgets getPanel() {
		return this.panel;
	}
}
