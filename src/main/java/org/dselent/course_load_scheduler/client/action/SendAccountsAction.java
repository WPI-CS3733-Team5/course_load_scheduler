package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendAccountsAction extends Action {
		
	private HasWidgets panel;
	public SendAccountsAction(HasWidgets panel) {
		this.panel = panel;
	}
	@Override
	public String toString() {
		return "SendAccountsAction [panel=" + panel + "]";
	}
	public HasWidgets getPanel() {
		return panel;
	}
}

