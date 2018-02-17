package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendCreateCourseEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendCreateCourseEventHandler extends EventHandler {
	
	public void onSendCreateCourse(SendCreateCourseEvent evt);


}
