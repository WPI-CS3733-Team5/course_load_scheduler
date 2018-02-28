package org.dselent.course_load_scheduler.client.model;

public class GlobalData
{
	private UserInfo activeUser;
	
	public GlobalData()
	{
		
	}

	public UserInfo getActiveUser()
	{
		return activeUser;
	}

	public void setActiveUser(UserInfo activeUser)
	{
		this.activeUser = activeUser;
	}
}
