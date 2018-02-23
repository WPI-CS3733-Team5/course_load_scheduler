package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.InvalidLogoutEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidLogoutEventHandler extends EventHandler
{
	  public void onInvalidLogout(InvalidLogoutEvent evt);
}