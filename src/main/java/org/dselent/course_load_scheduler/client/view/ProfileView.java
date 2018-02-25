package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.ProfilePresenter;
import org.dselent.course_load_scheduler.client.view.impl.ProfileViewImpl.ProfileViewUiBinder;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public interface ProfileView extends BaseView<ProfilePresenter>
{
	Button getEditWishlistButton();

	Label getUsername();

	void setUsername(Label username);

	Label getPhoneNumber();

	void setPhoneNumber(Label phoneNumber);

	Label getEmail();

	void setEmail(Label email);

	Button getEditCourseWishlistButton();

	void setEditWishlistButton(Button editCourseWishlistButton);

}
