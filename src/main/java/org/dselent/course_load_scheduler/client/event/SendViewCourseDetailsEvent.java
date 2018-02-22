package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendViewCourseDetailsAction;
import org.dselent.course_load_scheduler.client.event_handler.SendViewCourseDetailsEventHandler;

import com.google.gwt.user.client.ui.HasWidgets;
public class SendViewCourseDetailsEvent extends DisplayEvent<SendViewCourseDetailsAction, SendViewCourseDetailsEventHandler>{
		public static Type<SendViewCourseDetailsEventHandler> TYPE = new Type<SendViewCourseDetailsEventHandler>();
				
		public SendViewCourseDetailsEvent(SendViewCourseDetailsAction action, HasWidgets panel)
		{
			
			super(action, panel);
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