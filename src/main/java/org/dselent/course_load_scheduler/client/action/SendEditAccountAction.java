package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;

public class SendEditAccountAction {
	private UserInfo user;
	private InstructorInfo instructor;
	
	public SendEditAccountAction() {
		user = new UserInfo();
		instructor = new InstructorInfo();
	}
	public SendEditAccountAction(UserInfo user, InstructorInfo instructor) {
		this.user = user;
		this.instructor = instructor;
	}
	
	public UserInfo getUser() {
		return user;
	}
	public InstructorInfo getInstructor() {
		return instructor;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public void setInstructor(InstructorInfo instructor) {
		this.instructor = instructor;
	}
	@Override
	public String toString() {
		return "SendEditAccountAction [user=" + user + ", instructor=" + instructor + "]";
	}
	
}
