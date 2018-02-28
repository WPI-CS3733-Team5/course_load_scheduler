package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendViewCourseDetailsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendViewCourseDetailsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;

public class SendViewCourseDetailsEvent extends DisplayEvent<SendViewCourseDetailsEventHandler>
{
	public static Type<SendViewCourseDetailsEventHandler> TYPE = new Type<SendViewCourseDetailsEventHandler>();
	
	private SendViewCourseDetailsAction sendViewCourseDetailsAction;
	
	public SendViewCourseDetailsEvent(SendViewCourseDetailsAction sendViewCourseDetailsAction, HasWidgets panel)
	{
		super(panel);
		this.sendViewCourseDetailsAction = sendViewCourseDetailsAction;
	}
	
	@Override
	public Type<SendViewCourseDetailsEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendViewCourseDetailsEventHandler handler)
	{
		handler.onSendViewCourseDetails(this);
	}

	public SendViewCourseDetailsAction getSendViewCourseDetailsAction()
	{
		return sendViewCourseDetailsAction;
	}	
}