package org.dselent.course_load_scheduler.client.view.impl;
import org.dselent.course_load_scheduler.client.presenter.AccountsPresenter;
import org.dselent.course_load_scheduler.client.view.AccountsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

public class AccountsViewImpl extends BaseViewImpl<AccountsPresenter> implements AccountsView
{

	private static AccountsViewUiBinder uiBinder = GWT.create(AccountsViewUiBinder.class);
	
	interface AccountsViewUiBinder extends UiBinder<Widget, AccountsViewImpl> {}
	
	@UiField HTMLPanel rootPanel;
	@UiField HorizontalPanel radioPanel;
	@UiField Grid fullGrid;
	@UiField Grid gridEditing;
	
	@UiField Label labelUserName;
	@UiField TextBox enterUserName;
	@UiField Label labelFirstName;
	@UiField TextBox enterFirstName;
	@UiField Button buttonEdit;
	@UiField Button buttonApply;
	@UiField Button buttonCancel;
	@UiField Button buttonRemove;
	@UiField Button buttonViewAccount;
	@UiField Button buttonCreate;
	@UiField Label labelSort;
	@UiField RadioButton radioSortDepartment;
	@UiField RadioButton radioSortName;
	@UiField Button buttonSort;
	@UiField ListBox listAccounts;
	@UiField Label labelLastName;
	@UiField TextBox enterLastName;
	@UiField Label labelDepartment;
	@UiField TextBox enterDepartment;
	@UiField Label labelRank;
	@UiField IntegerBox enterRank;
	@UiField Label labelCourseLoad;
	@UiField IntegerBox enterCourseLoad;
	@UiField Label labelOffice;
	@UiField TextBox enterOffice;
	@UiField Label labelPrivelages;
	@UiField MenuBar menuPrivelages;
	@UiField MenuItem dropdownAdmin;
	@UiField MenuItem dropdownNonAdmin;
	@UiField Label labelEmail;
	@UiField TextBox enterEmail;


	public AccountsViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(AccountsPresenter presenter)
	{
		this.presenter = presenter;
	}

	@Override
	public Widget getWidgetContainer()
	{
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel()
	{
		return rootPanel;
	}
	
	@Override
	public TextBox getEnterUserName()
	{
		return enterUserName;
	}

	@Override
	public void setEnterUserName(TextBox enterUserName)
	{
		this.enterUserName = enterUserName;
	}

	@Override
	public TextBox getEnterFirstName()
	{
		return enterFirstName;
	}

	@Override
	public void setEnterFirstName(TextBox enterFirstName)
	{
		this.enterFirstName = enterFirstName;
	}

	@Override
	public Button getButtonEdit()
	{
		return buttonEdit;
	}

	@Override
	public void setButtonEdit(Button buttonEdit)
	{
		this.buttonEdit = buttonEdit;
	}

	@Override
	public Button getButtonApply()
	{
		return buttonApply;
	}

	@Override
	public void setButtonApply(Button buttonApply)
	{
		this.buttonApply = buttonApply;
	}

	@Override
	public Button getButtonCancel()
	{
		return buttonCancel;
	}

	@Override
	public void setButtonCancel(Button buttonCancel)
	{
		this.buttonCancel = buttonCancel;
	}

	@Override
	public Button getButtonRemove()
	{
		return buttonRemove;
	}

	@Override
	public void setButtonRemove(Button buttonRemove)
	{
		this.buttonRemove = buttonRemove;
	}

	@Override
	public Button getButtonCreate()
	{
		return buttonCreate;
	}

	@Override
	public void setButtonCreate(Button buttonCreate)
	{
		this.buttonCreate = buttonCreate;
	}

	@Override
	public RadioButton getRadioSortDepartment()
	{
		return radioSortDepartment;
	}

	@Override
	public void setRadioSortDepartment(RadioButton radioSortDepartment)
	{
		this.radioSortDepartment = radioSortDepartment;
	}

	@Override
	public RadioButton getRadioSortName()
	{
		return radioSortName;
	}

	@Override
	public void setRadioSortName(RadioButton radioSortName)
	{
		this.radioSortName = radioSortName;
	}

	@Override
	public HorizontalPanel getRadioPanel()
	{
		return radioPanel;
	}

	@Override
	public void setRadioPanel(HorizontalPanel radioPanel)
	{
		this.radioPanel = radioPanel;
	}

	@Override
	public Grid getFullGrid()
	{
		return fullGrid;
	}

	@Override
	public void setFullGrid(Grid fullGrid)
	{
		this.fullGrid = fullGrid;
	}

	@Override
	public ListBox getListAccounts()
	{
		return listAccounts;
	}

	@Override
	public void setListAccounts(ListBox listAccounts)
	{
		this.listAccounts = listAccounts;
	}

	@Override
	public Grid getGridEditing()
	{
		return gridEditing;
	}

	@Override
	public void setGridEditing(Grid gridEditing)
	{
		this.gridEditing = gridEditing;
	}

	@Override
	public TextBox getEnterLastName()
	{
		return enterLastName;
	}

	@Override
	public void setEnterLastName(TextBox enterLastName)
	{
		this.enterLastName = enterLastName;
	}

	@Override
	public TextBox getEnterDepartment()
	{
		return enterDepartment;
	}

	@Override
	public void setEnterDepartment(TextBox enterDepartment)
	{
		this.enterDepartment = enterDepartment;
	}

	@Override
	public IntegerBox getEnterRank()
	{
		return enterRank;
	}

	@Override
	public void setEnterRank(IntegerBox enterRank)
	{
		this.enterRank = enterRank;
	}

	@Override
	public IntegerBox getEnterCourseLoad()
	{
		return enterCourseLoad;
	}

	@Override
	public void setEnterCourseLoad(IntegerBox enterCourseLoad)
	{
		this.enterCourseLoad = enterCourseLoad;
	}

	@Override
	public TextBox getEnterOffice()
	{
		return enterOffice;
	}

	@Override
	public void setEnterOffice(TextBox enterOffice)
	{
		this.enterOffice = enterOffice;
	}

	@Override
	public MenuBar getMenuPrivelages()
	{
		return menuPrivelages;
	}

	@Override
	public void setMenuPrivelages(MenuBar menuPrivelages)
	{
		this.menuPrivelages = menuPrivelages;
	}

	@Override
	public MenuItem getDropdownAdmin()
	{
		return dropdownAdmin;
	}

	@Override
	public void setDropdownAdmin(MenuItem dropdownAdmin)
	{
		this.dropdownAdmin = dropdownAdmin;
	}

	@Override
	public MenuItem getDropdownNonAdmin()
	{
		return dropdownNonAdmin;
	}

	@Override
	public void setDropdownNonAdmin(MenuItem dropdownNonAdmin)
	{
		this.dropdownNonAdmin = dropdownNonAdmin;
	}

	@Override
	public TextBox getEnterEmail()
	{
		return enterEmail;
	}

	@Override
	public void setEnterEmail(TextBox enterEmail)
	{
		this.enterEmail = enterEmail;
	}

	@Override
	public Label getLabelUserName()
	{
		return labelUserName;
	}

	@Override
	public Label getLabelFirstName()
	{
		return labelFirstName;
	}

	@Override
	public Label getLabelSort()
	{
		return labelSort;
	}

	@Override
	public Label getLabelLastName()
	{
		return labelLastName;
	}

	@Override
	public Label getLabelDepartment()
	{
		return labelDepartment;
	}

	@Override
	public Label getLabelRank()
	{
		return labelRank;
	}

	@Override
	public Label getLabelCourseLoad()
	{
		return labelCourseLoad;
	}

	@Override
	public Label getLabelOffice()
	{
		return labelOffice;
	}

	@Override
	public Label getLabelPrivelages()
	{
		return labelPrivelages;
	}

	@Override
	public Label getLabelEmail()
	{
		return labelEmail;
	}
	
	@Override
	public Button getButtonViewAccount()
	{
		return buttonViewAccount;
	}

	@Override
	public void setButtonViewAccount(Button buttonViewAccount)
	{
		this.buttonViewAccount = buttonViewAccount;
	}

	@Override
	public Button getButtonSort()
	{
		return buttonSort;
	}

	@Override
	public void setButtonSort(Button buttonSort)
	{
		this.buttonSort = buttonSort;
	}

	
	@UiHandler("buttonSort")
	void onButtonSortClicked(ClickEvent evt)
	{
		presenter.applySort();
	}
	
	@UiHandler("buttonEdit")
	void onbuttonEditClicked(ClickEvent evt)
	{
		presenter.editCourse();
	}
	@UiHandler("buttonApply")
	void onbuttonApplyClicked(ClickEvent evt)
	{
		presenter.applyChanges();
	}
	@UiHandler("buttonCancel")
	void onbuttonCancelClicked(ClickEvent evt)
	{
		presenter.cancelChanges();
	}
	@UiHandler("buttonRemove")
	void onbuttonRemoveClicked(ClickEvent evt)
	{
		presenter.removeAccount();
	}
	@UiHandler("buttonCreate")
	void onbuttonCreateClicked(ClickEvent evt)
	{
		presenter.createAccount();
	}
	@UiHandler("buttonViewAccount")
	void onbuttonViewAccountClicked(ClickEvent evt)
	{
		presenter.populateAccountsViewer();
	}

	
	
}
