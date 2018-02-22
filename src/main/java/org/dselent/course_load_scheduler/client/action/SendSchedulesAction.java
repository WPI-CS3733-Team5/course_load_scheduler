<<<<<<< HEAD
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
=======
package org.dselent.course_load_scheduler.client.action;

public class SendSchedulesAction extends Action {
		
	public SendSchedulesAction() {

	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendSchedulesAction");
		return builder.toString();
	}
}
>>>>>>> 0794b4e12100245a2081ffc1eee87deca8904f25
