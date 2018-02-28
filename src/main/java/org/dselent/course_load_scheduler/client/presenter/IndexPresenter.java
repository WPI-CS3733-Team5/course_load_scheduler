package org.dselent.course_load_scheduler.client.presenter;

import org.dselent.course_load_scheduler.client.view.IndexView;

public interface IndexPresenter extends BasePresenter
{
	IndexView getView();
	void showMenuTabs();
	void hideMenuTabs();
	void showLoadScreen();
	void hideLoadScreen();
}
