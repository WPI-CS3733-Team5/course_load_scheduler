package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSortAction;
//import org.dselent.course_load_scheduler.client.event_handler.SendSortEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendSortWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;
//import com.google.gwt.event.shared.GwtEvent.Type;

public class SendSortWishlistEvent extends GwtEvent<SendSortWishlistEventHandler>{
		public static Type<SendSortWishlistEventHandler> TYPE = new Type<SendSortWishlistEventHandler>();
		
		private SendSortAction action;
		
		public SendSortWishlistEvent(SendSortAction action)
		{
			this.action = action;
		}
		
		public SendSortAction getAction()
		{
			return action;
		}
		
		/*
		 * 
		 */
		//@Override
		public Type<SendSortWishlistEventHandler> getAssociatedType()
		{
			return TYPE;
		}

		/*
		 * 
		 */
		//@Override
		protected void dispatch(SendSortWishlistEventHandler handler)
		{
			handler.onSendSortWishlist(this);
		}
	}