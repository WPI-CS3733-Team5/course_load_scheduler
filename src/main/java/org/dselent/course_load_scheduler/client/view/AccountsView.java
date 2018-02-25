package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.AccountsPresenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public interface AccountsView extends BaseView<AccountsPresenter>{
	public TextBox getEnterUserName();
	public void setEnterUserName(TextBox enterUserName);
	public TextBox getEnterFirstName();
	public void setEnterFirstName(TextBox enterFirstName);
	public Button getButtonEdit();
	public void setButtonEdit(Button buttonEdit);
	public Button getButtonApply();
	public void setButtonApply(Button buttonApply);
	public Button getButtonCancel();
	public void setButtonCancel(Button buttonCancel);
	public Button getButtonRemove();
	public void setButtonRemove(Button buttonRemove);
	public Button getButtonCreate();
	public void setButtonCreate(Button buttonCreate);
	public RadioButton getRadioSortDepartment();
	public void setRadioSortDepartment(RadioButton radioSortDepartment);
	public RadioButton getRadioSortName();
	public void setRadioSortName(RadioButton radioSortName);
	public HorizontalPanel getRadioPanel();
	public void setRadioPanel(HorizontalPanel radioPanel);
	public Grid getFullGrid();
	public void setFullGrid(Grid fullGrid);
	public ListBox getListAccounts();
	public void setListAccounts(ListBox listAccounts);
	public Grid getGridEditing();
	public void setGridEditing(Grid gridEditing);
	public TextBox getEnterLastName();
	public void setEnterLastName(TextBox enterLastName);
	public TextBox getEnterDepartment();
	public void setEnterDepartment(TextBox enterDepartment);
	public IntegerBox getEnterRank();
	public void setEnterRank(IntegerBox enterRank);
	public IntegerBox getEnterCourseLoad();
	public void setEnterCourseLoad(IntegerBox enterCourseLoad);
	public TextBox getEnterOffice();
	public void setEnterOffice(TextBox enterOffice);
	public MenuBar getMenuPrivelages();
	public void setMenuPrivelages(MenuBar menuPrivelages);
	public MenuItem getDropdownAdmin();
	public void setDropdownAdmin(MenuItem dropdownAdmin);
	public MenuItem getDropdownNonAdmin();
	public void setDropdownNonAdmin(MenuItem dropdownNonAdmin);
	public TextBox getEnterEmail();
	public void setEnterEmail(TextBox enterEmail);
	public Button getButtonSort();
	public void setButtonSort(Button buttonSort);
	public Label getLabelUserName();
	public Label getLabelFirstName();
	public Label getLabelSort();
	public Label getLabelLastName();
	public Label getLabelDepartment();
	public Label getLabelRank();
	public Label getLabelCourseLoad();
	public Label getLabelOffice();
	public Label getLabelPrivelages();
	public Label getLabelEmail();
	
	
}
