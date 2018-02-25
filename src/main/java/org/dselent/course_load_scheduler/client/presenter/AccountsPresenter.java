package org.dselent.course_load_scheduler.client.presenter;

public interface AccountsPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	void applySort();
	void editCourse();
	void applyChanges();
	void cancelChanges();
	void removeAccount();
	void createAccount();
	void populateAccountsViewer();
	
}
