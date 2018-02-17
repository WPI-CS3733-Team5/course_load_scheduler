package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
 
import org.dselent.course_load_scheduler.client.action.SendFetchListAction;
import org.dselent.course_load_scheduler.client.event.ReceiveNotificationListEvent;
import org.dselent.course_load_scheduler.client.event.SendFetchListEvent;
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
	private boolean taskInProgress;
	private Notifications curNotification;
	private ArrayList<Notifications> listNotifications;
	
 
	@Inject
	public NotificationsPresenterImpl(IndexPresenter parentPresenter, NotificationsView view) {
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		taskInProgress = false;
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
		registration = eventBus.addHandler(ReceiveNotificationListEvent.TYPE, this);
		eventBusRegistration.put(ReceiveNotificationListEvent.TYPE, registration);
	}
	
	@Override
	public void go(HasWidgets container) {
		//TODO load information onto UI
		container.clear();
		container.add(view.getWidgetContainer());
	}
	
	@Override
	public void onNotificationListReceipt(ReceiveNotificationListEvent evt) {
		listNotifications = evt.getAction().getNotificationList();
		go(evt.getPresenter().getView().getViewRootPanel());
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

}
