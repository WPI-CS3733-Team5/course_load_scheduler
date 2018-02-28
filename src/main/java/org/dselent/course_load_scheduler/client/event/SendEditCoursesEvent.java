package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditCoursesEventHandler;

import com.google.gwt.event.shared.GwtEvent;
/**
 * Note: Event modified to match standardization
 * 
 * @author Leo
 *
 */
public class SendEditCoursesEvent extends GwtEvent<SendEditCoursesEventHandler>
{
	
	public static Type<SendEditCoursesEventHandler> TYPE = new Type<SendEditCoursesEventHandler>();
	
	private SendEditCoursesAction sendEditCoursesAction;
	
	public SendEditCoursesEvent(SendEditCoursesAction sendEditCoursesAction)
	{
		this.sendEditCoursesAction = sendEditCoursesAction;
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

	public SendEditCoursesAction getSendEditCoursesAction()
	{
		return sendEditCoursesAction;
	}
}
