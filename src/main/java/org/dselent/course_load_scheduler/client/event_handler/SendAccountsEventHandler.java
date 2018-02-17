package org.dselent.course_load_scheduler.client.event_handler;
import org.dselent.course_load_scheduler.client.event.SendAccountsEvent;

import com.google.gwt.event.shared.EventHandler;
public interface SendAccountsEventHandler extends EventHandler
{
	
	public void onSendAccounts(SendAccountsEvent evt);
	
}
