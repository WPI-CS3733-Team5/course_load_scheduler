package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;

public class ReceiveProfileAction extends Action{
	private UserInfo user;
	private InstructorInfo instructor;
	
	public ReceiveProfileAction(UserInfo user, InstructorInfo instructor)
	{
		this.user = user;
		this.instructor = instructor;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public InstructorInfo getInstructor() {
		return instructor;
	}

	public void setInstructor(InstructorInfo instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "ReceiveProfileAction [user=" + user + ", instructor=" + instructor + "]";
	}

	
}
