package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendEditWishlistAction;
import org.dselent.course_load_scheduler.client.event_handler.SendEditWishlistEventHandler;

public class SendEditWishlistEvent extends BaseEvent<SendEditWishlistAction, SendEditWishlistEventHandler>{
		public static Type<SendEditWishlistEventHandler> TYPE = new Type<SendEditWishlistEventHandler>();
	
		public SendEditWishlistEvent(SendEditWishlistAction action)
		{
			super(action);
		}
	
		/*
		 * 
		 */
		@Override
		public Type<SendEditWishlistEventHandler> getAssociatedType()
		{
			return TYPE;
		}

		/*
		 * 
		 */
		@Override
		protected void dispatch(SendEditWishlistEventHandler handler)
		{
			handler.onSendEditWishlist(this);
		}
	}