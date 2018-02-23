package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;

public class ReceiveSchedulesUsersAction extends Action{
	
	private ArrayList<UserInfo> users;
	private ArrayList<InstructorInfo> instructors;
	
	public ReceiveSchedulesUsersAction(ArrayList<UserInfo> users, ArrayList<InstructorInfo> instructors) {
		this.users = users;
		this.instructors = instructors;
	}

	public ArrayList<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UserInfo> users) {
		this.users = users;
	}

	public ArrayList<InstructorInfo> getInstructors() {
		return instructors;
	}

	public void setInstructors(ArrayList<InstructorInfo> instructors) {
		this.instructors = instructors;
	}

	@Override
	public String toString() {
		return "ReceiveSchedulesAction [users=" + users + ", instructors=" + instructors + "]";
	}
	
	

}
