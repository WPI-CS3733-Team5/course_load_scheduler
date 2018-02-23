package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.presenter.impl.MenuTabsPresenterImpl;

public interface ProfilePresenter extends BasePresenter 
{
	IndexPresenter getParentPresenter();
	void editWishlist();
	void setParentPresenter(IndexPresenter parentPresenter);
	void setMenuTabs(MenuTabsPresenterImpl menuTabs);
}
