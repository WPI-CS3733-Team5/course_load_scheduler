package org.dselent.course_load_scheduler.client.presenter;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public interface WishlistPresenter extends BasePresenter
{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	void sort(RadioButton choose, ListBox courses, ListBox term, TextBox courseNumber);
	void viewCourseDetails(ListBox course);
	void editWishlist();
	void requestNewSchedule();
	
}
