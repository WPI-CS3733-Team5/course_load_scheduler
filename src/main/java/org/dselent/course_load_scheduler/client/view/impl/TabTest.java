package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.presenter.TabTestPresenter;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.view.TabTestView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class TabTest extends BaseViewImpl<TabTestPresenter> implements TabTestView{

	private static TabTestUiBinder uiBinder = GWT.create(TabTestUiBinder.class);

	interface TabTestUiBinder extends UiBinder<Widget, TabTest> {
	}

	public TabTest() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(TabTestPresenter presenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Widget getWidgetContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
