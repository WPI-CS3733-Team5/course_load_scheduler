package org.dselent.course_load_scheduler.client.presenter;

import com.google.gwt.user.client.ui.Button;


public interface MenuTabsPresenter extends BasePresenter
{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void home();
	void profile();
	void notifications();
	void wishlist();
	void courses();
	void accounts();
	void schedules();
	void logout();
}
