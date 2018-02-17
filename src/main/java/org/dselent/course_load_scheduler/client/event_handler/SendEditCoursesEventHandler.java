package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.SendEditCoursesEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendEditCoursesEventHandler extends EventHandler{
	
	public void onSendEditCourses(SendEditCoursesEvent evt);


}
