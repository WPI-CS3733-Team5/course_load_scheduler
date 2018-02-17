package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendAccountsAction {
	
	HasWidgets panel;
	
	public SendAccountsAction(HasWidgets panel) {
		this.panel = panel;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendAccountsAction");
		return builder.toString();
	}

	public HasWidgets getPanel() {
		return this.panel;
	}
}
