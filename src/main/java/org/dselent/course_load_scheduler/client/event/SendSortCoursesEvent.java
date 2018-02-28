package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSortCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSortCoursesEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendSortCoursesEvent extends GwtEvent<SendSortCoursesEventHandler>
{
	public static Type<SendSortCoursesEventHandler> TYPE = new Type<SendSortCoursesEventHandler>();
	
	private SendSortCoursesAction sendSortCoursesAction;
	
	public SendSortCoursesEvent(SendSortCoursesAction sendSortCoursesAction)
	{
		this.sendSortCoursesAction = sendSortCoursesAction;
	}
	
	@Override
	public Type<SendSortCoursesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendSortCoursesEventHandler handler)
	{
		handler.onSendSortCourses(this);
	}

	public SendSortCoursesAction getSendSortCoursesAction()
	{
		return sendSortCoursesAction;
	}
}
