package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidCoursesEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidCoursesEventHandler extends EventHandler{

	public void onInvalidCourses(InvalidCoursesEvent evt);
}
