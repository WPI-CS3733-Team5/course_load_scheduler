package org.dselent.course_load_scheduler.client.presenter;

import com.google.gwt.user.client.ui.ListBox;

public interface HomePresenter extends BasePresenter
{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void applyFilter(ListBox listBox, ListBox listBox2);
	void acceptSchedule(ListBox termBox, ListBox userBox);
	void requestDifferentSchedule(ListBox termBox, ListBox userBox);
}
