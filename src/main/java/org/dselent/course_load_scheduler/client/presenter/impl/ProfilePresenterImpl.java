package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveProfileAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.event.ReceiveProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ProfilePresenter;
import org.dselent.course_load_scheduler.client.view.ProfileView;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class ProfilePresenterImpl extends BasePresenterImpl implements ProfilePresenter
{
	private IndexPresenter parentPresenter;
	private MenuTabsPresenterImpl menuTabs;
	private ProfileView view;
	private boolean editWishlistClickInProgress;
	private UserInfo user;

	@Inject
	public ProfilePresenterImpl(IndexPresenter parentPresenter, ProfileView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		setEditWishlistClickInProgress(false);
	}
	
	
	@Override
	public void go(HasWidgets container) {
		
		view.getEmail().setText("Email: " + user.getEmail());
		view.getUsername().setText(user.getFirstName() + " " + user.getLastName() + " " + user.getUserName());
		
		container.clear();
		container.add(view.getWidgetContainer());		
	}

	@Override
	public ProfileView getView() {
		return view;
	}

	@Override
	public IndexPresenter getParentPresenter()
	{
		return parentPresenter;
	}
	
	@Override
	public void setParentPresenter(IndexPresenter parentPresenter)
	{
		this.parentPresenter = parentPresenter;
	}
	
	@Override
	public void setMenuTabs(MenuTabsPresenterImpl menuTabs)
	{
		this.menuTabs = menuTabs;
	}

	
	@Override
	public void editWishlist() {
		sendProfileEditWishlist();
	}
	
	private void sendProfileEditWishlist() {
		menuTabs.sendWishlist();
	}

	@Override
	public void onSendProfile(SendProfileEvent evt) {
		go(evt.getAction().getPanel());
	}


	public boolean isEditWishlistClickInProgress() {
		return editWishlistClickInProgress;
	}


	public void setEditWishlistClickInProgress(boolean editWishlistClickInProgress) {
		this.editWishlistClickInProgress = editWishlistClickInProgress;
	}
	
	@Override
	public void onReceiveProfile(ReceiveProfileEvent evt)
	{
		HasWidgets container = evt.getContainer();
		ReceiveProfileAction rpa = evt.getAction();
		this.user = rpa.getModel();
		go(container);
		Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
	}
}
