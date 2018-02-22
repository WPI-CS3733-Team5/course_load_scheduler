package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSortCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSortCoursesEventHandler;

public class SendSortCoursesEvent extends BaseEvent<SendSortCoursesAction, SendSortCoursesEventHandler>{
	
public static Type<SendSortCoursesEventHandler> TYPE = new Type<SendSortCoursesEventHandler>();
		
	public SendSortCoursesEvent(SendSortCoursesAction action)
	{
		super(action);
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

	

}
