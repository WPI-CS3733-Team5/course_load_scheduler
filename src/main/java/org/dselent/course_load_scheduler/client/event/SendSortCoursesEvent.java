package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSortCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendSortCoursesEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendSortCoursesEvent extends GwtEvent<SendSortCoursesEventHandler>{
	
public static Type<SendSortCoursesEventHandler> TYPE = new Type<SendSortCoursesEventHandler>();
	
	private SendSortCoursesAction action;
	
	public SendSortCoursesEvent(SendSortCoursesAction action)
	{
		this.action = action;
	}
	
	public SendSortCoursesAction getAction()
	{
		return action;
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
