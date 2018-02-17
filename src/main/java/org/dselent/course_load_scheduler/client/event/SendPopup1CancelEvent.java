package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendPopup1CancelAction;
import org.dselent.course_load_scheduler.client.event_handler.SendPopup1CancelEventHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendPopup1CancelEvent extends GwtEvent<SendPopup1CancelEventHandler>{
		
		public static Type<SendPopup1CancelEventHandler> TYPE = new Type<SendPopup1CancelEventHandler>();
			
			private SendPopup1CancelAction action;
			
			public SendPopup1CancelEvent(SendPopup1CancelAction action)
			{
				this.action = action;
			}
			
			public SendPopup1CancelAction getAction()
			{
				return action;
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
