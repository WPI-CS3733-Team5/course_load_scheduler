package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.UserInfo;

public class ReceiveHomeAction extends Action{

	private ArrayList<UserInfo> model;
	
	public ReceiveHomeAction(ArrayList<UserInfo> model)
	{
		this.model = model;
	}

	public ArrayList<UserInfo> getModel() {
		return model;
	}

	public void setModel(ArrayList<UserInfo> model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "ReceiveHomeAction [model=" + model + "]";
	}
	
	
	
}
