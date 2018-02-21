package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.UserInfo;

public class ReceiveProfileAction extends Action{
private UserInfo model;
	
	public ReceiveProfileAction(UserInfo model)
	{
		this.model = model;
	}

	public UserInfo getModel() 
	{
		return model;
	}

	public void setModel(UserInfo model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "ReceiveHomeAction [model=" + model + "]";
	}
}
