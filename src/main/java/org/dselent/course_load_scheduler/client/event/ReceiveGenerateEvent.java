package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveGenerateAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveGenerateEventHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveGenerateEvent extends DisplayEvent<ReceiveGenerateEventHandler>
{	
	public static Type<ReceiveGenerateEventHandler> TYPE = new Type<ReceiveGenerateEventHandler>();
	
	private ReceiveGenerateAction receiveGenerateAction;
	
	public ReceiveGenerateEvent(ReceiveGenerateAction receiveGenerateAction, HasWidgets panel)
	{
		super(panel);
		this.receiveGenerateAction = receiveGenerateAction;
	}
	

	@Override
	public Type<ReceiveGenerateEventHandler> getAssociatedType()
	{
		return TYPE;
	}
	
	@Override
	public void dispatch(ReceiveGenerateEventHandler handler)
	{
		handler.onReceiveGenerate(this);
	}

	public ReceiveGenerateAction getReceiveGenerateAction()
	{
		return receiveGenerateAction;
	}
}
