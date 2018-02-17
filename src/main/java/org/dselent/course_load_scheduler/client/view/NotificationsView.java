package org.dselent.course_load_scheduler.client.view;

import org.dselent.course_load_scheduler.client.presenter.impl.NotificationsPresenterImpl;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;

public interface NotificationsView extends BaseView<NotificationsPresenterImpl>{
	
	public Button getBtnAccept();
	public void setBtnAccept(Button btnAccept);
	
	
	public Button getBtnReject();
	public void setBtnReject(Button btnReject);
	public Button getBtnArchive();
	public void setBtnArchive(Button btnArchive);
	public Label getLblSender();
	public void setLblSender(Label lblSender);
	public Label getLblSubject();
	public void setLblSubject(Label lblSubject);
	public Label getLblTitle();
	public void setLblTitle(Label lblTitle);
	public ListBox getListNotification();
	public void setListNotification(ListBox listNotification);
	public void setMainTextArea(TextArea mainTextArea);
	public TextArea getMainTextArea();
}
