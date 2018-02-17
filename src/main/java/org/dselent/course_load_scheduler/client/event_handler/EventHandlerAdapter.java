package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveNotificationListEvent;
import org.dselent.course_load_scheduler.client.event.SendAcceptScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SendAccountsEvent;
import org.dselent.course_load_scheduler.client.event.SendCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeFilterEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;
import org.dselent.course_load_scheduler.client.event.SendNotificationsEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestDifferentScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistEvent;

/**
 * Adapter class for convenience
 * All classes that need to implement an event handler can extend from this class
 * This allows for presenters or other classes not to implement a large number of handler interfaces
 * Need to register all event handling functions with this class by implementing the handler and
 * overriding with an empty method
 * 
 * @author dselent
 * 
 */
public abstract class EventHandlerAdapter
implements InvalidLoginEventHandler, 
			SendLoginEventHandler, 
			SendFetchListEventHandler, 
			ReceiveNotificationListEventHandler,
			SendAcceptScheduleEventHandler,
			SendRequestDifferentScheduleEventHandler,
			SendHomeFilterEventHandler,
			SendHomeEventHandler,
			SendProfileEventHandler,
			SendNotificationsEventHandler,
			SendWishlistEventHandler,
			SendCoursesEventHandler,
			SendAccountsEventHandler,
			SendSchedulesEventHandler,
			SendLogoutEventHandler
{
	@Override
	public void onInvalidLogin(InvalidLoginEvent evt) {}
	
	@Override
	public void onSendLogin(SendLoginEvent evt) {}
	
	@Override
	public void onNotificationListReceipt(ReceiveNotificationListEvent evt) {}

	public void onSendAcceptSchedule(SendAcceptScheduleEvent evt) {}
	
	@Override
	public void onSendRequestDifferentSchedule(SendRequestDifferentScheduleEvent evt) {}
	
	@Override
	public void onSendHomeFilter(SendHomeFilterEvent evt) {}
	
	@Override
	public void onSendHome(SendHomeEvent evt) {}
	
	@Override
	public void onSendProfile(SendProfileEvent evt) {}
	
	@Override
	public void onSendNotifications(SendNotificationsEvent evt) {}
	
	@Override
	public void onSendWishlist(SendWishlistEvent evt) {}
	
	@Override
	public void onSendCourses(SendCoursesEvent evt) {}
	
	@Override
	public void onSendAccounts(SendAccountsEvent evt) {}
	
	@Override
	public void onSendSchedules(SendSchedulesEvent evt) {}
	
	@Override
	public void onSendLogout(SendLogoutEvent evt) {}
}
