package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendRequestNewScheduleAction;
import org.dselent.course_load_scheduler.client.event_handler.SendRequestNewScheduleEventHandler;

import com.google.gwt.event.shared.GwtEvent;

public class SendRequestNewScheduleEvent extends GwtEvent<SendRequestNewScheduleEventHandler>{
		public static Type<SendRequestNewScheduleEventHandler> TYPE = new Type<SendRequestNewScheduleEventHandler>();
		
		private SendRequestNewScheduleAction action;
		
		public SendRequestNewScheduleEvent(SendRequestNewScheduleAction action)
		{
			this.action = action;
		}
		
		public SendRequestNewScheduleAction getAction()
		{
			return action;
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