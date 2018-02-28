package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.ProfilePresenter;
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
	public interface ProfileViewUiBinder extends UiBinder<Widget, ProfileViewImpl> {}
	
	@UiField HTMLPanel rootPanel;
	@UiField Label username;
	@UiField Label phoneNumber;
	@UiField Label email;
	@UiField Button editWishlistButton;

	public ProfileViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void setPresenter(ProfilePresenter presenter)
	{
		this.presenter = presenter;		
	}

	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel()
	{
		return rootPanel;
	}


	@Override
	public Label getUsername()
	{
		return username;
	}


	@Override
	public void setUsername(Label username)
	{
		this.username = username;
	}

	@Override
	public Label getPhoneNumber()
	{
		return phoneNumber;
	}


	@Override
	public void setPhoneNumber(Label phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	@Override
	public Label getEmail()
	{
		return email;
	}


	@Override
	public void setEmail(Label email)
	{
		this.email = email;
	}


	@Override
	public Button getEditCourseWishlistButton()
	{
		return editWishlistButton;
	}


	@Override
	public void setEditWishlistButton(Button editCourseWishlistButton)
	{
		this.editWishlistButton = editCourseWishlistButton;
	}
	

	@Override
	public Button getEditWishlistButton()
	{
		return this.editWishlistButton;
	}

		
	@UiHandler("editWishlistButton")
	void oneditCourseWishlistButtonClicked(ClickEvent evt)
	{
		presenter.editWishlist();
	}

}
