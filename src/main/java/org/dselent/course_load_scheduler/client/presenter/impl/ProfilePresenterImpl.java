package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveProfileAction;
import org.dselent.course_load_scheduler.client.event.ReceiveProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ProfilePresenter;
import org.dselent.course_load_scheduler.client.view.ProfileView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;


public class ProfilePresenterImpl extends BasePresenterImpl implements ProfilePresenter
{
	private IndexPresenter parentPresenter;
	private MenuTabsPresenterImpl menuTabs;
	private ProfileView view;
	private boolean editWishlistClickInProgress;
	private UserInfo user;
	private InstructorInfo instructor;

	@Inject
	public ProfilePresenterImpl(ProfileView view)
	{
		this.view = view;
		view.setPresenter(this);
		setEditWishlistClickInProgress(false);
	}

	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration onReceiveProfile;
		onReceiveProfile = eventBus.addHandler(SendProfileEvent.TYPE, this);
		eventBusRegistration.put(SendProfileEvent.TYPE, onReceiveProfile);
		
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
		go(evt.getSendProfileAction().getPanel());
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
		ReceiveProfileAction rpa = evt.getReceiveProfileAction();
		this.user = rpa.getUser();
		this.setInstructor(rpa.getInstructor());
		go(container);
		Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
	}


	public InstructorInfo getInstructor() {
		return instructor;
	}


	public void setInstructor(InstructorInfo instructor) {
		this.instructor = instructor;
	}
}
