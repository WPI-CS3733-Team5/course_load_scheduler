package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendMeetingTimesEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendMeetingTimesEventHandler extends EventHandler {
	
	public void onSendMeetingTimes(SendMeetingTimesEvent evt);


}
