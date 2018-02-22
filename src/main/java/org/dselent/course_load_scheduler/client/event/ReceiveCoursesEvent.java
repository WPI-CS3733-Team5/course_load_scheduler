package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveCoursesAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveCoursesEventHandler;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveHomeEventHandler;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.HasWidgets;

public class ReceiveCoursesEvent extends DisplayEvent<ReceiveCoursesAction, ReceiveCoursesEventHandler>{

	public static Type<ReceiveCoursesEventHandler> TYPE = new Type<ReceiveCoursesEventHandler>();

	public ReceiveCoursesEvent(ReceiveCoursesAction action, HasWidgets container) {
		super(action, container);
	}

	@Override
	public Type<ReceiveCoursesEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveCoursesEventHandler handler) {

		handler.onReceiveCourses(this);
	}

	
}
