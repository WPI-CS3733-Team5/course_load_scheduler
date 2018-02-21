package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditCoursesEventHandler;
/**
 * Note: Event modified to match standardization
 * 
 * @author Leo
 *
 */
public class SendEditCoursesEvent extends BaseEvent<SendEditCoursesAction, SendEditCoursesEventHandler>{
	
public static Type<SendEditCoursesEventHandler> TYPE = new Type<SendEditCoursesEventHandler>();
	
	private SendEditCoursesAction action;
	
	public SendEditCoursesEvent(SendEditCoursesAction action)
	{
		super(action);
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
