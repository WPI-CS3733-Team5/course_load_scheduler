package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.InvalidAccountsEvent;
import org.dselent.course_load_scheduler.client.event.InvalidHomeEvent;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidAccountsEventHandler extends EventHandler{
	
	public void onInvalidAccounts(InvalidAccountsEvent evt);


}
