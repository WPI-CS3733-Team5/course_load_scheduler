package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleNotificationAction;
import org.dselent.course_load_scheduler.client.action.UpdateNotificationAction;
import org.dselent.course_load_scheduler.client.event.ReceiveNotificationEvent;
import org.dselent.course_load_scheduler.client.event.SendAcceptScheduleNotificationEvent;
import org.dselent.course_load_scheduler.client.event.SendNotificationsEvent;
import org.dselent.course_load_scheduler.client.event.UpdateNotificationEvent;
import org.dselent.course_load_scheduler.client.model.Notifications;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.NotificationsPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.NotificationsView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class NotificationsPresenterImpl extends BasePresenterImpl implements NotificationsPresenter {

	private IndexPresenter parentPresenter;
	private NotificationsView view;
	private Notifications curNotification;
	private ArrayList<Notifications> listNotifications;
	
 
	@Inject
	public NotificationsPresenterImpl(IndexPresenter parentPresenter, NotificationsView view) {
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		curNotification = null;
		listNotifications = new ArrayList<Notifications>();
	}

	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration registration;
		
		// Add these two lines of code for other handlers
		registration = eventBus.addHandler(ReceiveNotificationEvent.TYPE, this);
		eventBusRegistration.put(ReceiveNotificationEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
	}
	
	@Override
	public void onNotificationListReceipt(ReceiveNotificationEvent evt) {
		listNotifications = evt.getAction().getNotificationList();
		go(evt.getContainer());
	}

	@Override
	public BaseView<? extends BasePresenter> getView() {
		if (this.view instanceof BaseView<?>)
			return (BaseView<? extends BasePresenter>) this.view;
		else
			return null;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}
	
	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
	}
	
	public void selectNotification(int index) {
		if (listNotifications.size() != 0) {
		curNotification = listNotifications.get(index);
		view.getLblSender().setText(curNotification.getFromUserInfoId().toString());
		view.getMainTextArea().setText(curNotification.getMessage());
		}
		else {
			view.getLblSender().setText("N/A");
			view.getLblSubject().setText("N/A");
			view.getLblTitle().setText("N/A");
		}
	}
	
	public void archiveNotification() {
		Notifications n = curNotification;
		n.setMessage("[ARCHIVED] </br>" + n.getMessage());
		updateNotification(n);
	}
	
	/**
	 * Once this event is received by the server, callback simply refreshes the page
	 * 
	 * @param n Notification to be updated
	 */
	private void updateNotification(Notifications n) {
		UpdateNotificationAction a = new UpdateNotificationAction(n.getId());
		UpdateNotificationEvent e = new UpdateNotificationEvent(a);
		eventBus.fireEvent(e);
	}

	@Override
	public void onSendNotifications(SendNotificationsEvent evt) { 
		go(evt.getContainer());
	}

	@Override
	public void rejectScheduleRequest() {
		Notifications n = curNotification;
		if (!n.getMessage().contains("[REJECTED]") && !n.getMessage().contains("[ACCEPTED]")) {
			n.setMessage("[REJECTED] " + n.getMessage());
		}
		else
			System.out.println("Cannot reject and already rejected/accepted request");
	}

	@Override
	public void acceptScheduleRequest() {
		Notifications n = curNotification;
		if (!n.getMessage().contains("[REJECTED]") && !n.getMessage().contains("[ACCEPTED]")) {
			n.setMessage("[ACCEPTED] " + n.getMessage());
			SendAcceptScheduleNotificationAction a = new SendAcceptScheduleNotificationAction(n);
			SendAcceptScheduleNotificationEvent e = new SendAcceptScheduleNotificationEvent(a);
			eventBus.fireEvent(e);
		}
		else
			System.out.println("Cannot accept and already rejected/accepted request");
		
	}

}
