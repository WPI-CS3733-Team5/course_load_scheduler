package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.UserInfo;

public class ReceiveLoginAction extends Action
{
	private UserInfo model;
	
	public ReceiveLoginAction(UserInfo model)
	{
		this.model = model;
	}

	public UserInfo getModel()
	{
		return model;
	}

	public void setModel(UserInfo model)
	{
		this.model = model;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveLoginAction [model=");
		builder.append(model);
		builder.append("]");
		return builder.toString();
	}
}