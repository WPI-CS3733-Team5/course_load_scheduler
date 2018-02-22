package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRequestNewScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRequestNewScheduleEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendRequestNewScheduleEvent extends BaseEvent<SendRequestNewScheduleAction, SendRequestNewScheduleEventHandler>{
		public static Type<SendRequestNewScheduleEventHandler> TYPE = new Type<SendRequestNewScheduleEventHandler>();
				
		public SendRequestNewScheduleEvent(SendRequestNewScheduleAction action)
		{
			super(action);
		}
		
		/*
		 * 
		 */
		//@Override
		public Type<SendRequestNewScheduleEventHandler> getAssociatedType()
		{
			return TYPE;
		}

		/*
		 * 
		 */
		//@Override
		protected void dispatch(SendRequestNewScheduleEventHandler handler)
		{
			handler.onSendRequestNewSchedule(this);
		}
	}