package org.dselent.course_load_scheduler.client.action;

public class SendViewCourseDetailsAction extends Action
{
	private String course;

	
	public SendViewCourseDetailsAction(String course)
	{
		this.course = course;

	}

	public String getCourse()
	{
		return this.course;
	}

	@Override
	public String toString() {
		return "SendViewCourseDetailsAction [course=" + course + "]";
	}

	

}
