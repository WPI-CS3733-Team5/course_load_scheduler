package org.dselent.course_load_scheduler.client.event_handler;

import org.dselent.course_load_scheduler.client.event.ReceiveAccountsEvent;

import com.google.gwt.event.shared.EventHandler;

public interface ReceiveAccountsEventHandler extends EventHandler{
	
	public void onReceiveAccounts(ReceiveAccountsEvent evt);


}
