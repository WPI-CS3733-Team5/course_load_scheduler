package org.dselent.course_load_scheduler.client.presenter;

public interface NotificationsPresenter extends BasePresenter {
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	public void selectNotification(int index);
}
