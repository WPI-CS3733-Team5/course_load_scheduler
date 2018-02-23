package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveSchedulesCoursesEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveSchedulesCoursesEventHandler extends EventHandler{

	public void onReceiveSchedulesCourses(ReceiveSchedulesCoursesEvent evt);

}
