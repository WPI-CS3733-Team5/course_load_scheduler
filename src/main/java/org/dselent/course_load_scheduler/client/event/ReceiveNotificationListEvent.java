package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.ReceiveNotificationListAction;
import org.dselent.course_load_scheduler.client.event_handler.ReceiveNotificationListEventHandler;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;

import com.google.gwt.event.shared.GwtEvent;

public class ReceiveNotificationListEvent extends GwtEvent<ReceiveNotificationListEventHandler> {
	public BasePresenter getPresenter() {
		return presenter;
	}

	private BasePresenter presenter;
	private ReceiveNotificationListAction action;
	
	public ReceiveNotificationListAction getAction() {
		return action;
	}

	public void setAction(ReceiveNotificationListAction action) {
		this.action = action;
	}

	public ReceiveNotificationListEvent(ReceiveNotificationListAction action, BasePresenter presenter) {
		super();
		this.action = action;
		this.presenter = presenter;
	}

	public static Type<ReceiveNotificationListEventHandler> TYPE = new Type<ReceiveNotificationListEventHandler>();

	@Override
	public Type<ReceiveNotificationListEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReceiveNotificationListEventHandler handler) {
		// TODO no clue what to do here (dispatch)
	}

	
	
}
