package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.model.ActiveUser;

public interface IndexPresenter extends BasePresenter
{
	public void showLoadScreen();
	public void hideLoadScreen();
	public void showMenuTabs();
	public void hideMenuTabs();
	public ActiveUser getActiveUser();
	public void setActiveUser(ActiveUser user);
	void setActiveUserState(Integer state);
}
