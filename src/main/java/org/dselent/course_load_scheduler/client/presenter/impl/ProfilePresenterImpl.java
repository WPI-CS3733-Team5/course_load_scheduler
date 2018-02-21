package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistEvent;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ProfilePresenter;
import org.dselent.course_load_scheduler.client.view.ProfileView;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class ProfilePresenterImpl extends BasePresenterImpl implements ProfilePresenter
{
	private IndexPresenter parentPresenter;
	private ProfileView view;
	private boolean editWishlistClickInProgress;

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
	public void editWishlist() {
		sendProfileEditWishlist();
	}
	
	private void sendProfileEditWishlist() {
		SendWishlistAction spewa = new SendWishlistAction(view.getViewRootPanel());
		SendWishlistEvent spewe = new SendWishlistEvent(spewa);
		eventBus.fireEvent(spewe);
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
}
