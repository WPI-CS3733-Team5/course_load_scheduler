package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.AccountsPresenter;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.AccountsView;
import org.dselent.course_load_scheduler.client.view.BaseView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;


public class AccountsPresenterImpl extends BasePresenterImpl implements AccountsPresenter{
	private IndexPresenter parentPresenter;
	private AccountsView view;
	
	public AccountsPresenterImpl(IndexPresenter parentPresenter, AccountsView view) {
		this.parentPresenter = parentPresenter;
		this.view = view;
	}
	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountsView getView() {
		// TODO Auto-generated method stub
		return this.view;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		// TODO Auto-generated method stub
		return parentPresenter;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		// TODO Auto-generated method stub
		this.parentPresenter = parentPresenter;
	}

	@Override
	public void init() {
		bind();
	}
	@Override
	public void bind() {
		HandlerRegistration registration;
		
		
		
	}
	
	@Override
	public void editCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyChanges() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelChanges() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCourse() {
		// TODO Auto-generated method stub
		
	}

}
