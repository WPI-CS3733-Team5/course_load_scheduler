package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendSortWishlistAction;
//import org.dselent.course_load_scheduler.client.event_handler.SendSortEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.SendSortWishlistEventHandler;

import com.google.gwt.event.shared.GwtEvent;
//import com.google.gwt.event.shared.GwtEvent.Type;

public class SendSortWishlistEvent extends GwtEvent<SendSortWishlistEventHandler>{
		public static Type<SendSortWishlistEventHandler> TYPE = new Type<SendSortWishlistEventHandler>();
		
		private SendSortWishlistAction action;
		
		public SendSortWishlistEvent(SendSortWishlistAction action)
		{
			this.action = action;
		}
		
		public SendSortWishlistAction getAction()
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