package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendLogoutAction extends Action
{
	private HasWidgets panel;
	
	public SendLogoutAction(HasWidgets panel) {
		this.panel = panel;
	}

	@Override
	public String toString() {
		return "SendLogoutAction [panel=" + panel + "]";
	}

	public HasWidgets getPanel() {
		return panel;
	}
}
