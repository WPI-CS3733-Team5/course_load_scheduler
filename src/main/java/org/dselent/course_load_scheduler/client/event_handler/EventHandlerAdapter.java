package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.*;

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
			SendPopup3ApplyEventHandler,
			ReceiveLoginEventHandler,
			ReceiveNotificationEventHandler,
			ReceiveHomeEventHandler
			

			
{
	@Override
	public void onInvalidLogin(InvalidLoginEvent evt) {}
	
	@Override
	public void onSendLogin(SendLoginEvent evt) {}
	
	@Override
	public void onNotificationListReceipt(ReceiveNotificationEvent evt) {}

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
	
	@Override
	public void onReceiveLogin(ReceiveLoginEvent evt) {}
}
