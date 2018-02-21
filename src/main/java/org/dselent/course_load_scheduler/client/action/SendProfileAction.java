package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendProfileAction extends Action{

	HasWidgets panel;
	
	public SendProfileAction(HasWidgets panel) {
		this.panel = panel;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendProfileAction");
		return builder.toString();
	}

	public HasWidgets getPanel() {
		return panel;
	}

	public void setPanel(HasWidgets panel) {
		this.panel = panel;
	}
	
}
