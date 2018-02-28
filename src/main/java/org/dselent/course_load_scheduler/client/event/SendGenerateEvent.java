package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendGenerateAction;
import org.dselent.course_load_scheduler.client.event_handler.SendGenerateEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class SendGenerateEvent extends DisplayEvent<SendGenerateEventHandler>
{
	public static Type<SendGenerateEventHandler> TYPE = new Type<SendGenerateEventHandler>();
	
	private SendGenerateAction sendGenerateAction;
	
	public SendGenerateEvent(SendGenerateAction sendGenerateAction, HasWidgets panel)
	{
		super(panel);
		this.sendGenerateAction = sendGenerateAction;
	}

	@Override
	public Type<SendGenerateEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	public void dispatch(SendGenerateEventHandler handler)
	{
		handler.onSendGenerate(this);
	}

	public SendGenerateAction getSendGenerateAction()
	{
		return sendGenerateAction;
	}
}

