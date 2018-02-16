package org.dselent.course_load_scheduler.client.presenter;

public interface ProfilePresenter extends BasePresenter 
{
	IndexPresenter getParentPresenter();
	void editInfo();
	void editWishlist();
	void setParentPresenter(IndexPresenter parentPresenter);
}
