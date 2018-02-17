package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendHomeAction {
	
	HasWidgets panel;
	
	public SendHomeAction(HasWidgets panel){
		this.panel = panel;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendHomeAction");
		return builder.toString();
	}

	public HasWidgets getPanel() {
		return panel;
	}

	public void setPanel(HasWidgets panel) {
		this.panel = panel;
	}

}
