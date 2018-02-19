package org.dselent.course_load_scheduler.client.view.impl;


import org.dselent.course_load_scheduler.client.presenter.NotificationsPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;

/**
 * @author Leo Gonsalves
 *
 */
public class NotificationsViewImpl extends BaseViewImpl<NotificationsPresenter> {

	private static NotificationsViewUiBinder uiBinder = GWT.create(NotificationsViewUiBinder.class);
	@UiField Button btnAccept;
	@UiField Button btnReject;
	@UiField Button btnArchive;
	@UiField Label lblSender;
	@UiField Label lblSubject;
	@UiField Label lblTitle;
	@UiField ListBox listNotification;
	@UiField TextArea mainTextArea;
	@UiField HTMLPanel mainPanel;

	interface NotificationsViewUiBinder extends UiBinder<Widget, NotificationsViewImpl> {}

	public NotificationsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("btnAccept")
	void onBtnAcceptClick(ClickEvent event) {
		
	}

	public Button getBtnAccept() {
		return btnAccept;
	}

	public void setBtnAccept(Button btnAccept) {
		this.btnAccept = btnAccept;
	}

	@UiHandler("btnReject")
	void onBtnRejectClick(ClickEvent event) {
		
	}
	
	public Button getBtnReject() {
		return btnReject;
	}

	public void setBtnReject(Button btnReject) {
		this.btnReject = btnReject;
	}

	@UiHandler("btnArchive")
	void onBtnArchiveClick(ClickEvent event) {
		
	}
	
	public Button getBtnArchive() {
		return btnArchive;
	}

	public void setBtnArchive(Button btnArchive) {
		this.btnArchive = btnArchive;
	}

	public Label getLblSender() {
		return lblSender;
	}

	public void setLblSender(Label lblSender) {
		this.lblSender = lblSender;
	}

	public Label getLblSubject() {
		return lblSubject;
	}

	public void setLblSubject(Label lblSubject) {
		this.lblSubject = lblSubject;
	}

	public Label getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(Label lblTitle) {
		this.lblTitle = lblTitle;
	}

	@UiHandler("listNotification")
	void onSelection(ChangeEvent event) {
		presenter.selectNotification(listNotification.getSelectedIndex());
	}
	
	public ListBox getListNotification() {
		return listNotification;
	}

	public void setListNotification(ListBox listNotification) {
		this.listNotification = listNotification;
	}

	@Override
	public void setPresenter(NotificationsPresenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public Widget getWidgetContainer() {
		return this.getParent();
	}

	public TextArea getMainTextArea() {
		return mainTextArea;
	}

	public void setMainTextArea(TextArea mainTextArea) {
		this.mainTextArea = mainTextArea;
	}

	@Override
	public HasWidgets getViewRootPanel() {
		return mainPanel;
	}
}
