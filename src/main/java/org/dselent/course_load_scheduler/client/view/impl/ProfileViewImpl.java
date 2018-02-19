package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.ProfilePresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.ProfilePresenterImpl;
import org.dselent.course_load_scheduler.client.view.ProfileView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class ProfileViewImpl extends BaseViewImpl<ProfilePresenter> implements ProfileView {

	private static ProfileViewUiBinder uiBinder = GWT.create(ProfileViewUiBinder.class);
	interface ProfileViewUiBinder extends UiBinder<Widget, ProfileViewImpl> {}
	private ProfilePresenterImpl parent;
	
	@UiField HTMLPanel profileRoot;
	@UiField Label username;
	@UiField Label jobTitle;
	@UiField Label phoneNumber;
	@UiField Label office;
	@UiField Label email;
	@UiField Button editPersonalInfoButton;
	@UiField Button editWishlistButton;

	public ProfileViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public static ProfileViewUiBinder getUiBinder() {
		return uiBinder;
	}



	public static void setUiBinder(ProfileViewUiBinder uiBinder) {
		ProfileViewImpl.uiBinder = uiBinder;
	}



	public Label getUsername() {
		return username;
	}



	public void setUsername(Label username) {
		this.username = username;
	}



	public Label getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(Label jobTitle) {
		this.jobTitle = jobTitle;
	}



	public Label getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(Label phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Label getOffice() {
		return office;
	}



	public void setOffice(Label office) {
		this.office = office;
	}



	public Label getEmail() {
		return email;
	}



	public void setEmail(Label email) {
		this.email = email;
	}



	public Button getEditPersonalInfoButton() {
		return editPersonalInfoButton;
	}



	public void setEditPersonalInfoButton(Button editPersonalInfoButton) {
		this.editPersonalInfoButton = editPersonalInfoButton;
	}



	public Button getEditCourseWishlistButton() {
		return editWishlistButton;
	}



	public void setEditWishlistButton(Button editCourseWishlistButton) {
		this.editWishlistButton = editCourseWishlistButton;
	}
	

	@Override
	public Button getEditWishlistButton() {
		return this.editWishlistButton;
	}

	@UiHandler("editPersonalInfoButton")
	void onEditPersonalInfoButtonClicked(ClickEvent event) 
	{
		presenter.editInfo();
	}
	
	@UiHandler("editWishlistButton")
	void oneditCourseWishlistButtonClicked(ClickEvent evt)
	{
		presenter.editWishlist();
	}



	@Override
	public void setPresenter(ProfilePresenter presenter) {
		this.presenter = presenter;		
	}



	@Override
	public Widget getWidgetContainer() {
		return this;
	}



	@Override
	public HasWidgets getViewRootPanel() {
		return profileRoot;
	}



}
