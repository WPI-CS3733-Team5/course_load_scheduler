package org.dselent.course_load_scheduler.client.view.impl;

import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.presenter.TabTestPresenter;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.view.TabTestView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;

public class TabTest extends Composite {

	private static TabTestUiBinder uiBinder = GWT.create(TabTestUiBinder.class);

	interface TabTestUiBinder extends UiBinder<Widget, TabTest> {
	}

	public TabTest() {
		initWidget(uiBinder.createAndBindUi(this));
	}

/*
public class TabTest extends BaseViewImpl<TabTestPresenter> implements TabTestView{
	
	@UiField TabLayoutPanel tabPanel;

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
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return this.tabPanel;
	}
*/
}

