package org.dselent.course_load_scheduler.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ExampleViewImpl extends Composite {

	private static ExampleViewImplUiBinder uiBinder = GWT.create(ExampleViewImplUiBinder.class);

	interface ExampleViewImplUiBinder extends UiBinder<Widget, ExampleViewImpl> {
	}

	public ExampleViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
