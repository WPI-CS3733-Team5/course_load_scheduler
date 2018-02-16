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
	
	private boolean editInProgress;
	private boolean creationInProgress;
	
	public AccountsPresenterImpl(IndexPresenter parentPresenter, AccountsView view) {
		this.parentPresenter = parentPresenter;
		this.view = view;
		editInProgress = false;
		creationInProgress = false;

		enableUserFields(false);
		view.getButtonApply().setEnabled(false);
		view.getButtonCancel().setEnabled(false);
	}
	
	private void enableUserFields(boolean active) {
		view.getEnterUserName().setEnabled(active);
		view.getEnterFirstName().setEnabled(active);
		view.getEnterLastName().setEnabled(active);
		view.getEnterDepartment().setEnabled(active);
		view.getEnterRank().setEnabled(active);
		view.getEnterCourseLoad().setEnabled(active);
		view.getEnterOffice().setEnabled(active);
		view.getMenuPrivelages().setVisible(active);
		view.getDropdownAdmin().setEnabled(active);
		view.getDropdownNonAdmin().setEnabled(active);
		view.getEnterEmail().setEnabled(active);
	}
	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.getWidgetContainer());
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
		if (!editInProgress && !creationInProgress) {
			editInProgress = true;
			enableUserFields(true);
			view.getButtonApply().setEnabled(true);
			view.getButtonCancel().setEnabled(true);
			
		}
	}

	@Override
	public void applyChanges() {
		if (editInProgress) {
			
		}
		else if (creationInProgress) {
			
		}
	}

	@Override
	public void cancelChanges() {
		if (editInProgress) {
			editInProgress = false;
			enableUserFields(false);
			view.getButtonApply().setEnabled(false);
			view.getButtonCancel().setEnabled(false);
		}
		else if (creationInProgress) {
			creationInProgress = false;
			enableUserFields(false);
			view.getButtonApply().setEnabled(false);
			view.getButtonCancel().setEnabled(false);
		}
	}

	@Override
	public void removeAccount() {
		String item = view.getListAccounts().getValue(view.getListAccounts().getSelectedIndex());
		
		
	}

	@Override
	public void createAccount() {
		if (!creationInProgress && !editInProgress) {
			creationInProgress = true;
			enableUserFields(true);
			view.getButtonApply().setEnabled(true);
			view.getButtonCancel().setEnabled(true);
		}
	}

}
