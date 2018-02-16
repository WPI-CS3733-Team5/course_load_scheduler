package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendCoursesAction {
	
	HasWidgets panel;
	
	public SendCoursesAction(HasWidgets panel) {
		this.panel = panel;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendCoursesAction");
		return builder.toString();
	}

	public HasWidgets getPanel() {
		return this.panel;
	}
}
