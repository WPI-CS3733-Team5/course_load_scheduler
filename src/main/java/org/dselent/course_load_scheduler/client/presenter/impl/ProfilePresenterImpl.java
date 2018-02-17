package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.SendProfileEditInfoAction;
import org.dselent.course_load_scheduler.client.action.SendProfileEditWishlistAction;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEditInfoEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEditWishlistEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ProfilePresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.view.ProfileView;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class ProfilePresenterImpl extends BasePresenterImpl implements ProfilePresenter
{
	private IndexPresenter parentPresenter;
	private ProfileView view;
	private boolean editInfoClickInProgress;
	private boolean editWishlistClickInProgress;

	public ProfilePresenterImpl(IndexPresenter parentPresenter, ProfileView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		editInfoClickInProgress = false;
		editWishlistClickInProgress = false;
	}
	
	
	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProfileView getView() {
		// TODO Auto-generated method stub
		return view;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		// TODO Auto-generated method stub
		return parentPresenter;
	}
	
	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}

	@Override
	public void editInfo() {
		sendProfileEditInfo();
	}
	
	private void sendProfileEditInfo() {
		SendProfileEditInfoAction speia = new SendProfileEditInfoAction();
		SendProfileEditInfoEvent speie = new SendProfileEditInfoEvent(speia);
		eventBus.fireEvent(speia);
	}

	@Override
	public void editWishlist() {
		sendProfileEditWishlist();
	}
	
	private void sendProfileEditWishlist() {
		SendProfileEditWishlistAction spewa = new SendProfileEditWishlistAction();
		SendProfileEditWishlistEvent spewe = new SendProfileEditWishlistEvent(spewa);
		eventBus.fireEvent(spewe);
	}

	@Override
	public void onSendProfile(SendProfileEvent evt) {
		go(evt.getAction().getPanel());
	}
}
