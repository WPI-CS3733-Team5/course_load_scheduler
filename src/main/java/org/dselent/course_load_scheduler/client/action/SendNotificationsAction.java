package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendNotificationsAction extends Action {
	
	private HasWidgets panel;
	public SendNotificationsAction(HasWidgets panel) {
		this.panel = panel;
	}
	@Override
	public String toString() {
		return "SendNotificationsAction [panel=" + panel + "]";
	}
	public HasWidgets getPanel() {
		return panel;
	}
	
}
