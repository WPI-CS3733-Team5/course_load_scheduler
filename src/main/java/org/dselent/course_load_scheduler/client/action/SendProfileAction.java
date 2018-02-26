package org.dselent.course_load_scheduler.client.action;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendProfileAction extends Action{

	private Integer userId;
	
	HasWidgets panel;
	
	public SendProfileAction(HasWidgets panel, Integer userId) {
		this.userId = userId;
		this.panel = panel;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public HasWidgets getPanel() {
		return panel;
	}

	public void setPanel(HasWidgets panel) {
		this.panel = panel;
	}

	@Override
	public String toString() {
		return "SendProfileAction [userId=" + userId + ", panel=" + panel + "]";
	}
}
