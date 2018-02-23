package org.dselent.course_load_scheduler.client.action;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.WishlistLinks;

public class ReceiveWishlistAction extends Action
{
	private WishlistLinks model;

	public ReceiveWishlistAction(WishlistLinks wishlist, CalendarInfo calendar, SectionInfo section, CourseInfo course)
	{
		this.model = wishlist;
	}

	public WishlistLinks getModel()
	{
		return model;
	}

	public void setModel(WishlistLinks model)
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

