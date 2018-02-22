package org.dselent.course_load_scheduler.client.action;

public class SendLogoutAction extends Action
{
	public SendLogoutAction() {}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendLogoutAction");
		return builder.toString();
	}
}
