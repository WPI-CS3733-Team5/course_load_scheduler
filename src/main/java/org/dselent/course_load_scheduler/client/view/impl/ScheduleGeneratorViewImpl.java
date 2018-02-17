package org.dselent.course_load_scheduler.client.view.impl;

//created by David M.

import org.dselent.course_load_scheduler.client.presenter.ScheduleGeneratorPresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleGeneratorView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.IntegerBox;

public class ScheduleGeneratorViewImpl extends BaseViewImpl<ScheduleGeneratorPresenter> implements ScheduleGeneratorView {

	private static ScheduleGeneratorViewUiBinder uiBinder = GWT.create(ScheduleGeneratorViewUiBinder.class);

	interface ScheduleGeneratorViewUiBinder extends UiBinder<Widget, ScheduleGeneratorViewImpl> {}
	
	@UiField Grid mainPanel;
	@UiField Grid fieldsPanel;
	@UiField Label userNameLabel;
	@UiField TextBox nameBox;
	@UiField Label termLabel;
	@UiField Grid termPanel;
	@UiField ListBox termCombo1;
	@UiField IntegerBox yearBox1;
	@UiField Label toLabel;
	@UiField ListBox termCombo2;
	@UiField IntegerBox yearBox2;
	@UiField Label courseLabel;
	@UiField TextBox courseBox;
	@UiField Grid rightPanel;
	@UiField Grid selectPanel;
	@UiField Button selectReqButton;
	@UiField Button selectAllButton;
	@UiField Button removeSelButton;
	@UiField Button removeAllButton;
	@UiField ListBox courseList;
	@UiField Grid proceedPanel;
	@UiField Button cancelButton;
	@UiField Button generateButton;
	

	public ScheduleGeneratorViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	//@Override
	public TextBox getNameBox() {
		return nameBox;
	}

	//@Override
	public void setNameBox(TextBox nameBox) {
		this.nameBox = nameBox;
	}

	//@Override
	public ListBox getTermCombo1() {
		return termCombo1;
	}

	//@Override
	public void setTermCombo1(ListBox termCombo1) {
		this.termCombo1 = termCombo1;
	}

	//@Override
	public IntegerBox getYearBox1() {
		return yearBox1;
	}

	//@Override
	public void setYearBox1(IntegerBox yearBox1) {
		this.yearBox1 = yearBox1;
	}

	//@Override
	public ListBox getTermCombo2() {
		return termCombo2;
	}

	//@Override
	public void setTermCombo2(ListBox termCombo2) {
		this.termCombo2 = termCombo2;
	}

	//@Override
	public IntegerBox getYearBox2() {
		return yearBox2;
	}

	//@Override
	public void setYearBox2(IntegerBox yearBox2) {
		this.yearBox2 = yearBox2;
	}

	//@Override
	public TextBox getCourseBox() {
		return courseBox;
	}

	//@Override
	public void setCourseBox(TextBox courseBox) {
		this.courseBox = courseBox;
	}

	//@Override
	public Button getSelectReqButton() {
		return selectReqButton;
	}

	//@Override
	public Button getSelectAllButton() {
		return selectAllButton;
	}

	//@Override
	public Button getRemoveSelButton() {
		return removeSelButton;
	}

	//@Override
	public Button getRemoveAllButton() {
		return removeAllButton;
	}

	//@Override
	public ListBox getCourseList() {
		return courseList;
	}

	//@Override
	public void setCourseList(ListBox courseList) {
		this.courseList = courseList;
	}

	//@Override
	public Button getCancelButton() {
		return cancelButton;
	}

	//@Override
	public Button getGenerateButton() {
		return generateButton;
	}

	//@Override
	@Override
	public void setPresenter(ScheduleGeneratorPresenter presenter)
	{
		this.presenter = presenter;
	}

	//@Override
	@Override
	public void showErrorMessages(String errorMessages)
	{
		Window.alert(errorMessages);
	}
	
	//@Override
	public Widget getWidgetContainer()
	{
		return this;
	}
	
	//@Override
	public HasWidgets getViewRootPanel()
	{
		return mainPanel;
	}
}
