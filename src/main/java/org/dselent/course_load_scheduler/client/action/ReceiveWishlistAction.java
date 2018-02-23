package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.WishlistLinks;

public class ReceiveWishlistAction extends Action{
	
	private WishlistLinks model;
	

	public ReceiveWishlistAction(ArrayList<WishlistLinks> wishlists, ArrayList<CalendarInfo> calendars, ArrayList<SectionInfo> sections, ArrayList<CourseInfo> courses)
	{
		this.model = wishlists;
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

