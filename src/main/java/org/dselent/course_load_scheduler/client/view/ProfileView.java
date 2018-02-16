package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.ProfilePresenter;

import com.google.gwt.user.client.ui.Button;

public interface ProfileView extends BaseView<ProfilePresenter>
{
	Button getEditPersonalInfoButton();
	Button getEditWishlistButton();
}
