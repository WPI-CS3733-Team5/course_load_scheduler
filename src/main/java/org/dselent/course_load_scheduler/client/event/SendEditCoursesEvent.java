package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditCoursesEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendEditCoursesEvent extends GwtEvent<SendEditCoursesEventHandler>{
	
public static Type<SendEditCoursesEventHandler> TYPE = new Type<SendEditCoursesEventHandler>();
	
	private SendEditCoursesAction action;
	
	public SendEditCoursesEvent(SendEditCoursesAction action)
	{
		this.action = action;
	}
	
	public SendEditCoursesAction getAction()
	{
		return action;
	}
	
	@Override
	public Type<SendEditCoursesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendEditCoursesEventHandler handler)
	{
		handler.onSendEditCourses(this);
	}

}
