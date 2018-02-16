package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.view.impl.ScheduleSelectPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IntegerBox;

public interface ScheduleSelectView extends BaseView<ScheduleSelectPresenter>{
	public ListBox getScheduleListBox();
	public void setScheduleListBox(ListBox scheduleListBox);
	public Button getBackButton();
	public Button getDeleteButton();
	public Button getAcceptButton();
	public ListBox getCourseListBox();
	public void setCourseListBox(ListBox courseListBox);
	public IntegerBox getYearBox();
	public void setYearBox(IntegerBox yearBox);
	public ListBox getTermCombo();
	public void setTermCombo(ListBox termCombo);
	public void showErrorMessages(String errorMessages);
}
