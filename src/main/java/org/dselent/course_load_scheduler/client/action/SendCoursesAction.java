package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendCoursesAction extends Action {
	
	HasWidgets panel;
	
	public SendCoursesAction() {
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
