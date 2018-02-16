package org.dselent.course_load_scheduler.client.view.impl;
import org.dselent.course_load_scheduler.client.presenter.AccountsPresenter;
import org.dselent.course_load_scheduler.client.view.AccountsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

public class AccountsViewImpl extends BaseViewImpl<AccountsPresenter> {

	private static AccountsViewUiBinder uiBinder = GWT.create(AccountsViewUiBinder.class);
	interface AccountsViewUiBinder extends UiBinder<Widget, AccountsViewImpl> {}
	@UiField Label labelUserName;
	@UiField TextBox enterUserName;
	@UiField Label labelFirstName;
	@UiField TextBox enterFirstName;
	@UiField Button buttonEdit;
	@UiField Button buttonApply;
	@UiField Button buttonCancel;
	@UiField Button buttonRemove;
	@UiField Button buttonCreate;
	@UiField Label labelSort;
	@UiField RadioButton radioSortDepartment;
	@UiField RadioButton radioSortName;
	@UiField RadioButton radioSortUserName;
	@UiField HorizontalPanel radioPanel;
	@UiField Grid fullGrid;
	@UiField ListBox listAccounts;
	@UiField Grid gridEditing;
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



	public AccountsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public TextBox getEnterUserName() {
		return enterUserName;
	}

	public void setEnterUserName(TextBox enterUserName) {
		this.enterUserName = enterUserName;
	}

	public TextBox getEnterFirstName() {
		return enterFirstName;
	}

	public void setEnterFirstName(TextBox enterFirstName) {
		this.enterFirstName = enterFirstName;
	}

	public Button getButtonEdit() {
		return buttonEdit;
	}

	public void setButtonEdit(Button buttonEdit) {
		this.buttonEdit = buttonEdit;
	}

	public Button getButtonApply() {
		return buttonApply;
	}

	public void setButtonApply(Button buttonApply) {
		this.buttonApply = buttonApply;
	}

	public Button getButtonCancel() {
		return buttonCancel;
	}

	public void setButtonCancel(Button buttonCancel) {
		this.buttonCancel = buttonCancel;
	}

	public Button getButtonRemove() {
		return buttonRemove;
	}

	public void setButtonRemove(Button buttonRemove) {
		this.buttonRemove = buttonRemove;
	}

	public Button getButtonCreate() {
		return buttonCreate;
	}

	public void setButtonCreate(Button buttonCreate) {
		this.buttonCreate = buttonCreate;
	}

	public RadioButton getRadioSortDepartment() {
		return radioSortDepartment;
	}

	public void setRadioSortDepartment(RadioButton radioSortDepartment) {
		this.radioSortDepartment = radioSortDepartment;
	}

	public RadioButton getRadioSortName() {
		return radioSortName;
	}

	public void setRadioSortName(RadioButton radioSortName) {
		this.radioSortName = radioSortName;
	}

	public RadioButton getRadioSortUserName() {
		return radioSortUserName;
	}

	public void setRadioSortUserName(RadioButton radioSortUserName) {
		this.radioSortUserName = radioSortUserName;
	}

	public HorizontalPanel getRadioPanel() {
		return radioPanel;
	}

	public void setRadioPanel(HorizontalPanel radioPanel) {
		this.radioPanel = radioPanel;
	}

	public Grid getFullGrid() {
		return fullGrid;
	}

	public void setFullGrid(Grid fullGrid) {
		this.fullGrid = fullGrid;
	}

	public ListBox getListAccounts() {
		return listAccounts;
	}

	public void setListAccounts(ListBox listAccounts) {
		this.listAccounts = listAccounts;
	}

	public Grid getGridEditing() {
		return gridEditing;
	}

	public void setGridEditing(Grid gridEditing) {
		this.gridEditing = gridEditing;
	}

	public TextBox getEnterLastName() {
		return enterLastName;
	}

	public void setEnterLastName(TextBox enterLastName) {
		this.enterLastName = enterLastName;
	}

	public TextBox getEnterDepartment() {
		return enterDepartment;
	}

	public void setEnterDepartment(TextBox enterDepartment) {
		this.enterDepartment = enterDepartment;
	}

	public IntegerBox getEnterRank() {
		return enterRank;
	}

	public void setEnterRank(IntegerBox enterRank) {
		this.enterRank = enterRank;
	}

	public IntegerBox getEnterCourseLoad() {
		return enterCourseLoad;
	}

	public void setEnterCourseLoad(IntegerBox enterCourseLoad) {
		this.enterCourseLoad = enterCourseLoad;
	}

	public TextBox getEnterOffice() {
		return enterOffice;
	}

	public void setEnterOffice(TextBox enterOffice) {
		this.enterOffice = enterOffice;
	}

	public MenuBar getMenuPrivelages() {
		return menuPrivelages;
	}

	public void setMenuPrivelages(MenuBar menuPrivelages) {
		this.menuPrivelages = menuPrivelages;
	}

	public MenuItem getDropdownAdmin() {
		return dropdownAdmin;
	}

	public void setDropdownAdmin(MenuItem dropdownAdmin) {
		this.dropdownAdmin = dropdownAdmin;
	}

	public MenuItem getDropdownNonAdmin() {
		return dropdownNonAdmin;
	}

	public void setDropdownNonAdmin(MenuItem dropdownNonAdmin) {
		this.dropdownNonAdmin = dropdownNonAdmin;
	}

	public TextBox getEnterEmail() {
		return enterEmail;
	}

	public void setEnterEmail(TextBox enterEmail) {
		this.enterEmail = enterEmail;
	}

	public Label getLabelUserName() {
		return labelUserName;
	}

	public Label getLabelFirstName() {
		return labelFirstName;
	}

	public Label getLabelSort() {
		return labelSort;
	}

	public Label getLabelLastName() {
		return labelLastName;
	}

	public Label getLabelDepartment() {
		return labelDepartment;
	}

	public Label getLabelRank() {
		return labelRank;
	}

	public Label getLabelCourseLoad() {
		return labelCourseLoad;
	}

	public Label getLabelOffice() {
		return labelOffice;
	}

	public Label getLabelPrivelages() {
		return labelPrivelages;
	}

	public Label getLabelEmail() {
		return labelEmail;
	}

	@Override
	public void setPresenter(AccountsPresenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public Widget getWidgetContainer() {
		return this;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return this.fullGrid;
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
	
}
