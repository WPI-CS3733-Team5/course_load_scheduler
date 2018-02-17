package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.SendEditWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendRequestNewScheduleAction;
import org.dselent.course_load_scheduler.client.action.SendSortWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendViewCourseDetailsAction;
import org.dselent.course_load_scheduler.client.event.SendEditWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestNewScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SendSortWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendViewCourseDetailsEvent;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.WishlistPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.WishlistView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;




public class WishlistPresenterImpl extends BasePresenterImpl implements WishlistPresenter{
	
	private IndexPresenter parentPresenter;
	private WishlistView view;
	private boolean sort;
	private boolean viewCourseDetails;
	private boolean requestNewSchedule;
	private boolean editWishlist;
;
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());
		
	}

	@Override
	//wisihlitview getview
	
	public BaseView<? extends BasePresenter> getView() {
		return (BaseView<? extends BasePresenter>) this.view;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		// TODO Auto-generated method stub
		return parentPresenter;
	}
	////////////////////////////

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
		
	}
	
	

	@Override
	public void sort(RadioButton name, ListBox department, ListBox term, TextBox courseNumber) 
	{
		if(!sort)
		{
			
			sort = true;
			view.getSortButton().setEnabled(false);
			
			
			String department1 = department.getItemText(department.getSelectedIndex());
			String term1 = term.getItemText(term.getSelectedIndex());
			String courseNumber1 = courseNumber.getSelectedText();
			sendSort(department1, term1, courseNumber1);
			
		}
		
	}
	
	private void sendSort(String dept, String term, String courseNum)
	{
		
		SendSortWishlistAction ssa = new SendSortWishlistAction(dept, term, courseNum);
		SendSortWishlistEvent sse = new SendSortWishlistEvent(ssa);
		eventBus.fireEvent(sse);
		
	}

	@Override
	public void viewCourseDetails(ListBox course) {
		if(!viewCourseDetails)
		{
			
			viewCourseDetails = true;
			view.getViewCourseDetailsButton();
			
			String course1 = course.getItemText(course.getSelectedIndex());
			sendViewCourseDetails(course1);
			
		}
		
	}
	
	private void sendViewCourseDetails(String course)
	{
		
		SendViewCourseDetailsAction svcda = new SendViewCourseDetailsAction(course);
		SendViewCourseDetailsEvent svcde = new SendViewCourseDetailsEvent(svcda);
		eventBus.fireEvent(svcde);
		
	}

	@Override
	public void editWishlist() {
		if(!editWishlist)
		{
			
			editWishlist = true;
			view.getEditWishlistButton();
			
			sendEditWishList();
			
		}		
	}
	
	private void sendEditWishList()
	{
		
		SendEditWishlistAction svcda = new SendEditWishlistAction();
		SendEditWishlistEvent svcde = new SendEditWishlistEvent(svcda);
		eventBus.fireEvent(svcde);
		
	}
	

	@Override
	public void requestNewSchedule() {
		if(!requestNewSchedule) 
		{
			requestNewSchedule = true;
			view.getRequestNewScheduleButton();
			
			sendRequestNewSchedule();
		}
		
	}
	
	private void sendRequestNewSchedule()
	{
		
		SendRequestNewScheduleAction srnsa = new SendRequestNewScheduleAction();
		SendRequestNewScheduleEvent srnse = new SendRequestNewScheduleEvent(srnsa);
		eventBus.fireEvent(srnse);
		
	}
	

}
