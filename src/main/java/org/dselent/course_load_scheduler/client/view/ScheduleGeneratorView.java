package org.dselent.course_load_scheduler.client.view;

//created by David M.

import org.dselent.course_load_scheduler.client.presenter.ScheduleGeneratorPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

public interface ScheduleGeneratorView extends BaseView<ScheduleGeneratorPresenter> {
	public TextBox getNameBox();
	public void setNameBox(TextBox nameBox);	
	public ListBox getTermCombo1();
	public void setTermCombo1(ListBox termCombo1);
	public IntegerBox getYearBox1();
	public void setYearBox1(IntegerBox yearBox1);
	public ListBox getTermCombo2();
	public void setTermCombo2(ListBox termCombo2);
	public IntegerBox getYearBox2();
	public void setYearBox2(IntegerBox yearBox2);
	public TextBox getCourseBox();
	public void setCourseBox(TextBox courseBox);
	public Button getSelectReqButton();
	public Button getSelectAllButton();
	public Button getRemoveSelButton();
	public Button getRemoveAllButton();
	public ListBox getCourseList();
	public void setCourseList(ListBox courseList);
	public Button getCancelButton();
	public Button getGenerateButton();
	public void showErrorMessages(String errorMessages);
}
