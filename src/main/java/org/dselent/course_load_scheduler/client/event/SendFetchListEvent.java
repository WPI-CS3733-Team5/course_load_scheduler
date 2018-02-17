package org.dselent.course_load_scheduler.client.event;

import org.dselent.course_load_scheduler.client.action.SendFetchListAction;
import org.dselent.course_load_scheduler.client.event_handler.SendFetchListEventHandler;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SendFetchListEvent extends GwtEvent<SendFetchListEventHandler> {
	private BasePresenter presenter;
	private SendFetchListAction action;
	public static Type<SendFetchListEventHandler> TYPE = new Type<SendFetchListEventHandler>();
	

	public SendFetchListEvent(SendFetchListAction sendFetchListAction, BasePresenter presenter) {
		super();
		action = sendFetchListAction;
		this.presenter = presenter;
	}

	@Override
	public Type<SendFetchListEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SendFetchListEventHandler handler) {
		// TODO no clue what to do here (dispatch)
		
	}

}
