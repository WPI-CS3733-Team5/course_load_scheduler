package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;

public class ReceiveAccountsAction extends Action{

	private ArrayList<UserInfo> userinfoList;
	private ArrayList<InstructorInfo> instructorInfoList;
	
	public ReceiveAccountsAction(ArrayList<UserInfo> users, ArrayList<InstructorInfo> instructors) {
		this.userinfoList = users;
		this.instructorInfoList = instructors;
	}

	public ArrayList<UserInfo> getUserinfoList() {
		return userinfoList;
	}

	public void setUserinfoList(ArrayList<UserInfo> userinfoList) {
		this.userinfoList = userinfoList;
	}

	public ArrayList<InstructorInfo> getInstructorInfoList() {
		return instructorInfoList;
	}

	public void setInstructorInfoList(ArrayList<InstructorInfo> instructorInfoList) {
		this.instructorInfoList = instructorInfoList;
	}

	@Override
	public String toString() {
		return "ReceiveAccountsAction [userinfoList=" + userinfoList + ", instructorInfoList=" + instructorInfoList
				+ "]";
	}
}
