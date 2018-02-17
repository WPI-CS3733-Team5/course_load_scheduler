package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendSortCoursesEvent;

import com.google.gwt.event.shared.EventHandler;

public interface SendSortCoursesEventHandler extends EventHandler{
	
	public void onSendSortCourses(SendSortCoursesEvent evt);

}
