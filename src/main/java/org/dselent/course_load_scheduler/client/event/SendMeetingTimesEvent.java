package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendMeetingTimesAction;
import org.dselent.course_load_scheduler.client.event_handler.SendMeetingTimesEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendMeetingTimesEvent extends GwtEvent<SendMeetingTimesEventHandler>
{
	public static Type<SendMeetingTimesEventHandler> TYPE = new Type<SendMeetingTimesEventHandler>();
	
	private SendMeetingTimesAction sendMeetingTimesAction;
	
	public SendMeetingTimesEvent(SendMeetingTimesAction sendMeetingTimesAction)
	{
		this.sendMeetingTimesAction = sendMeetingTimesAction;
	}
	
	@Override
	public Type<SendMeetingTimesEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(SendMeetingTimesEventHandler handler)
	{
		handler.onSendMeetingTimes(this);
	}

	public SendMeetingTimesAction getSendMeetingTimesAction()
	{
		return sendMeetingTimesAction;
	}
}
