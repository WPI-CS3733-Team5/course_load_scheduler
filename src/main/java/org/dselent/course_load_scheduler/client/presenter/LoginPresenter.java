package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.presenter.impl.MenuTabsPresenterImpl;
import org.dselent.course_load_scheduler.client.view.impl.MenuTabsImpl;

public interface LoginPresenter extends BasePresenter
{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	void login();
	void setMenuTabs(MenuTabsPresenterImpl menuTabs);
}
