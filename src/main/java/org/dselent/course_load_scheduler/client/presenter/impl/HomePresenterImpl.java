package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.SendAcceptScheduleAction;
import org.dselent.course_load_scheduler.client.action.SendHomeFilterAction;
import org.dselent.course_load_scheduler.client.action.SendRequestDifferentScheduleAction;
import org.dselent.course_load_scheduler.client.event.SendAcceptScheduleEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeFilterEvent;
import org.dselent.course_load_scheduler.client.event.SendRequestDifferentScheduleEvent;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.HomePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.HomeView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.inject.Inject;

public class HomePresenterImpl extends BasePresenterImpl implements HomePresenter {
	
	private IndexPresenter parentPresenter;
	private HomeView view;
	private boolean acceptScheduleInProgress;
	private boolean requestDifferentScheduleInProgress;
	private boolean applyFilterInProgress;
	
	@Inject
	public HomePresenterImpl(IndexPresenter parentPresenter, HomeView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setParent(this);
		acceptScheduleInProgress = false;
		requestDifferentScheduleInProgress = false;
		applyFilterInProgress = false;
		
	}
	
	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.getWidgetContainer());		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BaseView<? extends BasePresenter> getView() {
		return (BaseView<? extends BasePresenter>) this.view;
	}
	
	@Override
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}
	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
	}
	@Override
	public void applyFilter(ListBox termBox, ListBox userBox) {
		if(!applyFilterInProgress)
		{
			applyFilterInProgress = true;
			view.getApply().setEnabled(false);
			
			String term = termBox.getItemText(termBox.getSelectedIndex());
			String username = userBox.getItemText(userBox.getSelectedIndex());
			sendApplyFilter(term, username);
		}
	}
	
	private void sendApplyFilter(String term, String username)
	{
		SendHomeFilterAction shfa = new SendHomeFilterAction(term, username);
		SendHomeFilterEvent shfe = new SendHomeFilterEvent(shfa);
		eventBus.fireEvent(shfe);
	}
	
	@Override
	public void acceptSchedule(ListBox termBox, ListBox userBox) {
		if(!acceptScheduleInProgress)
		{
			acceptScheduleInProgress = true;
			view.getAcceptSchedule().setEnabled(false);
			
			String term = termBox.getItemText(termBox.getSelectedIndex());
			String username = userBox.getItemText(userBox.getSelectedIndex());
			
			sendAcceptSchedule(term, username);
		}
	}
	
	private void sendAcceptSchedule(String term, String username) {
		SendAcceptScheduleAction sasa = new SendAcceptScheduleAction(term, username);
		SendAcceptScheduleEvent sase = new SendAcceptScheduleEvent(sasa);
		eventBus.fireEvent(sase);
	}
	
	@Override
	public void requestDifferentSchedule(ListBox termBox, ListBox userBox) {
		if(!requestDifferentScheduleInProgress)
		{
			requestDifferentScheduleInProgress = true;
			view.getRequestDifferentSchedule().setEnabled(false);
			
			String term = termBox.getItemText(termBox.getSelectedIndex());
			String username = userBox.getItemText(userBox.getSelectedIndex());
			
			sendRequestDifferentSchedule(term, username);
		}
	}
	
	private void sendRequestDifferentSchedule(String term, String username) {
		SendRequestDifferentScheduleAction srdsa = new SendRequestDifferentScheduleAction(term, username);
		SendRequestDifferentScheduleEvent srdse = new SendRequestDifferentScheduleEvent(srdsa);
		eventBus.fireEvent(srdse);
	}

}
