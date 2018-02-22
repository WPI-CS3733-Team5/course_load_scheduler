package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup1CancelAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup1CancelEventHandler;

public class SendPopup1CancelEvent extends BaseEvent<SendPopup1CancelAction, SendPopup1CancelEventHandler>{
		
		public static Type<SendPopup1CancelEventHandler> TYPE = new Type<SendPopup1CancelEventHandler>();
			
			
			public SendPopup1CancelEvent(SendPopup1CancelAction action)
			{
				super(action);
			}
			 
			
			@Override
			public Type<SendPopup1CancelEventHandler> getAssociatedType()
			{
				return TYPE;
			}

			@Override
			protected void dispatch(SendPopup1CancelEventHandler handler)
			{
				handler.onSendPopup1Cancel(this);
			}

	
	
}
