package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveSchedulesCoursesEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveSchedulesCoursesEvent extends DisplayEvent<ReceiveSchedulesCoursesAction, ReceiveSchedulesCoursesEventHandler>{

public static Type<ReceiveSchedulesCoursesEventHandler> TYPE = new Type<ReceiveSchedulesCoursesEventHandler>();
	
	public ReceiveSchedulesCoursesEvent(ReceiveSchedulesCoursesAction action, HasWidgets container)
	{
		super(action, container);
	}
	
	public Type<ReceiveSchedulesCoursesEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	protected void dispatch(ReceiveSchedulesCoursesEventHandler handler)
	{
		handler.onReceiveSchedulesCourses(this);
	}
}
