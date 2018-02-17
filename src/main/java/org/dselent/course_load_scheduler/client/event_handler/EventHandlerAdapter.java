package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveNotificationListEvent;
import org.dselent.course_load_scheduler.client.event.SendAcceptScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SendAccountsEvent;
import org.dselent.course_load_scheduler.client.event.SendAddToWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendApplyChangesEvent;
import org.dselent.course_load_scheduler.client.event.SendCancelChangesEvent;
import org.dselent.course_load_scheduler.client.event.SendCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendCreateAccountEvent;
import org.dselent.course_load_scheduler.client.event.SendCreateCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendEditAccountEvent;
import org.dselent.course_load_scheduler.client.event.SendEditCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeFilterEvent;
import org.dselent.course_load_scheduler.client.event.SendLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendLogoutEvent;
import org.dselent.course_load_scheduler.client.event.SendMeetingTimesEvent;
import org.dselent.course_load_scheduler.client.event.SendNotificationsEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup1ApplyEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup1CancelEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup2ApplyEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup2CancelEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup2EndTimeEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup2StartTimeEvent;
import org.dselent.course_load_scheduler.client.event.SendPopup3ApplyEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendRemoveAccountEvent;
import org.dselent.course_load_scheduler.client.event.SendRemoveCourseEvent;
import org.dselent.course_load_scheduler.client.event.SendRemoveSelectedFromWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestDifferentScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;
import org.dselent.course_load_scheduler.client.event.SendSectionTypeEvent;
import org.dselent.course_load_scheduler.client.event.SendSortCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendViewFullWishlistEvent;
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
			SendLogoutEventHandler,
			SendCreateAccountEventHandler,
			SendEditAccountEventHandler,
			SendRemoveAccountEventHandler,
			SendSortCoursesEventHandler,
			SendAddToWishlistEventHandler,
			SendRemoveSelectedFromWishlistEventHandler,
			SendViewFullWishlistEventHandler,
			SendApplyChangesEventHandler,
			SendEditCoursesEventHandler,
			SendCancelChangesEventHandler,
			SendRemoveCourseEventHandler,
			SendCreateCourseEventHandler,
			SendSectionTypeEventHandler,
			SendMeetingTimesEventHandler,
			SendPopup1ApplyEventHandler,
			SendPopup1CancelEventHandler,
			SendPopup2StartTimeEventHandler,
			SendPopup2EndTimeEventHandler,
			SendPopup2ApplyEventHandler,
			SendPopup2CancelEventHandler,
			SendPopup3ApplyEventHandler
			
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
	
	@Override
	public void onSendCreateAccount(SendCreateAccountEvent evt) {}
	
	@Override
	public void onSendEditAccount(SendEditAccountEvent evt) {}
	
	@Override
	public void onSendRemoveAccount(SendRemoveAccountEvent evt) {}
	
	@Override
	public void onSendSortCourses(SendSortCoursesEvent evt) {}
	
	@Override
	public void onSendAddToWishlist(SendAddToWishlistEvent evt) {}
	
	@Override
	public void onSendRemoveSelectedFromWishlist(SendRemoveSelectedFromWishlistEvent evt) {}
	
	@Override
	public void onSendViewFullWishlist(SendViewFullWishlistEvent evt) {}
	
	@Override
	public void onSendApplyChanges(SendApplyChangesEvent evt) {}

	@Override
	public void onSendEditCourses(SendEditCoursesEvent evt) {}
	
	@Override
	public void onSendCancelChanges(SendCancelChangesEvent evt) {}
	
	@Override
	public void onSendRemoveCourse(SendRemoveCourseEvent evt) {}
	
	@Override
	public void onSendCreateCourse(SendCreateCourseEvent evt) {}
	
	@Override
	public void onSendSectionType(SendSectionTypeEvent evt) {}
	
	@Override
	public void onSendMeetingTimes(SendMeetingTimesEvent evt) {}
	
	@Override
	public void onSendPopup1Apply(SendPopup1ApplyEvent evt) {}
	
	@Override
	public void onSendPopup1Cancel(SendPopup1CancelEvent evt) {}
	
	@Override
	public void onSendPopup2StartTime(SendPopup2StartTimeEvent evt) {}
	
	@Override
	public void onSendPopup2EndTime(SendPopup2EndTimeEvent evt) {}
	
	@Override
	public void onSendPopup2Apply(SendPopup2ApplyEvent evt) {}
	
	@Override
	public void onSendPopup2Cancel(SendPopup2CancelEvent evt) {}
	
	@Override
	public void onSendPopup3Apply(SendPopup3ApplyEvent evt) {}
}
