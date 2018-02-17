package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendViewCourseDetailsAction;
//import org.dselent.course_load_scheduler.client.event_handler.SendLoginEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendViewCourseDetailsEventHandler;

import com.google.gwt.event.shared.GwtEvent;

//import org.dselent.course_load_scheduler.client.action.SendSortAction;
//import org.dselent.course_load_scheduler.client.event_handler.SendSortEventHandler;

public class SendViewCourseDetailsEvent extends GwtEvent<SendViewCourseDetailsEventHandler>{
		public static Type<SendViewCourseDetailsEventHandler> TYPE = new Type<SendViewCourseDetailsEventHandler>();
		
		private SendViewCourseDetailsAction action;
		
		public SendViewCourseDetailsEvent(SendViewCourseDetailsAction action)
		{
			this.action = action;
		}
		
		public SendViewCourseDetailsAction getAction()
		{
			return action;
		}
		
		/*
		 * 
		 */
		//@Override
		public Type<SendViewCourseDetailsEventHandler> getAssociatedType()
		{
			return TYPE;
		}

		/*
		 * 
		 */
		//@Override
		protected void dispatch(SendViewCourseDetailsEventHandler handler)
		{
			handler.onSendViewCourseDetails(this);
		}
	}