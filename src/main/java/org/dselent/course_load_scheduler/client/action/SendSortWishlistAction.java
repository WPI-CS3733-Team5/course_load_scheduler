package org.dselent.course_load_scheduler.client.action;

public class SendSortWishlistAction 
{
	private String dept;
	private String term;
	private String courseNum;
	
	public SendSortWishlistAction(String dept, String term, String courseNum)
	{
		this.dept = dept;
		this.term = term;
		this.courseNum = courseNum;
	}

	public String getDept()
	{
		return this.dept;
	}

	public String getTerm()
	{
		return this.term;
	}
	
	public String getCourseNum()
	{
		return this.courseNum;
	}

	@Override
	public String toString() {
		return "SendSortAction [dept=" + dept + ", term=" + term + ", courseNum=" + courseNum + "]";
	}


}
