package org.dselent.course_load_scheduler.client.presenter.impl;

import org.dselent.course_load_scheduler.client.presenter.BasePresenter;
import org.dselent.course_load_scheduler.client.presenter.TabTestPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.view.BaseView;
import org.dselent.course_load_scheduler.client.view.TabTestView;

import com.google.gwt.user.client.ui.HasWidgets;

public class TabTestPresenterImpl extends BasePresenterImpl implements TabTestPresenter{
	
	TabTestView view;
	
	//@Inject
	public TabTestPresenterImpl(TabTestView view)
	{
		this.view=view;
		view.setPresenter(this);
	}
	
	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public void bind()
	{
	}

	@Override
	public void go(HasWidgets container) {
		
		container.clear();
		container.add(view.getWidgetContainer());
	}

	@Override
	public BaseView<? extends BasePresenter> getView() {
		return this.view;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		return null;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		
	}

}
