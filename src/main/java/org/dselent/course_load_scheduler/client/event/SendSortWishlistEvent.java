package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSortWishlistAction;
//import org.dselent.course_load_scheduler.client.event_handler.SendSortEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendSortWishlistEventHandler;

public class SendSortWishlistEvent extends BaseEvent<SendSortWishlistAction, SendSortWishlistEventHandler>{
		public static Type<SendSortWishlistEventHandler> TYPE = new Type<SendSortWishlistEventHandler>();
		
		
		public SendSortWishlistEvent(SendSortWishlistAction action)
		{
			super(action);
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