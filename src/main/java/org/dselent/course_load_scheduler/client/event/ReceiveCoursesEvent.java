package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveCoursesEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveCoursesEvent extends DisplayEvent<ReceiveCoursesEventHandler>
{

	public static Type<ReceiveCoursesEventHandler> TYPE = new Type<ReceiveCoursesEventHandler>();

	private ReceiveCoursesAction receiveCoursesAction;
	
	public ReceiveCoursesEvent(ReceiveCoursesAction receiveCoursesAction, HasWidgets container)
	{
		super(container);
		this.receiveCoursesAction = receiveCoursesAction;
	}

	@Override
	public Type<ReceiveCoursesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveCoursesEventHandler handler)
	{
		handler.onReceiveCourses(this);
	}

	public ReceiveCoursesAction getReceiveCoursesAction()
	{
		return receiveCoursesAction;
	}
}
