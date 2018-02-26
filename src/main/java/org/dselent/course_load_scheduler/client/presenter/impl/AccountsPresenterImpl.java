package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.ArrayList;

import javax.inject.Inject;

import org.dselent.course_load_scheduler.client.action.ReceiveAccountsAction;
import org.dselent.course_load_scheduler.client.action.SendCreateAccountAction;
import org.dselent.course_load_scheduler.client.action.SendEditAccountAction;
import org.dselent.course_load_scheduler.client.action.SendRemoveAccountAction;
import org.dselent.course_load_scheduler.client.event.ReceiveAccountsEvent;
import org.dselent.course_load_scheduler.client.event.SendCreateAccountEvent;
import org.dselent.course_load_scheduler.client.event.SendEditAccountEvent;
import org.dselent.course_load_scheduler.client.event.SendRemoveAccountEvent;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.AccountsPresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.utils.Pair;
import org.dselent.course_load_scheduler.client.view.AccountsView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;


public class AccountsPresenterImpl extends BasePresenterImpl implements AccountsPresenter{
	private IndexPresenter parentPresenter;
	private AccountsView view;
	
	private boolean applySortInProgress;
	private boolean editInProgress;
	private boolean creationInProgress;
	private boolean populateAccountsInProgress;
	
	private ArrayList<UserInfo> userInfoList;
	private ArrayList<InstructorInfo> instructorInfoList;
	
	@Inject
	public AccountsPresenterImpl(IndexPresenter parentPresenter, AccountsView view) {
		this.parentPresenter = parentPresenter;
		this.view = view;
		applySortInProgress = false;
		editInProgress = false;
		creationInProgress = false;
		populateAccountsInProgress = false;

		enableUserFields(false);
		view.getButtonApply().setEnabled(false);
		view.getButtonCancel().setEnabled(false);
	}
	
	private void enableUserFields(boolean active) {
		view.getEnterUserName().setEnabled(active);
		view.getEnterFirstName().setEnabled(active);
		view.getEnterLastName().setEnabled(active);
		view.getEnterDepartment().setEnabled(active);
		view.getEnterRank().setEnabled(active);
		view.getEnterCourseLoad().setEnabled(active);
		view.getEnterOffice().setEnabled(active);
		view.getMenuPrivelages().setVisible(active);
		view.getDropdownAdmin().setEnabled(active);
		view.getDropdownNonAdmin().setEnabled(active);
		view.getEnterEmail().setEnabled(active);
	}
	private void clearUserFields() {
		view.getEnterUserName().setText("");
		view.getEnterFirstName().setText("");
		view.getEnterLastName().setText("");
		view.getEnterDepartment().setText("");
		view.getEnterRank().setText("");
		view.getEnterCourseLoad().setText("");
		view.getEnterOffice().setText("");
		view.getEnterEmail().setText("");
	}
	@Override
	public void go(HasWidgets container) {
		
		view.getRadioSortDepartment().setValue(true);
		view.getRadioSortName().setValue(false);
		
		accountsFilter(view.getRadioSortDepartment().getValue(), view.getRadioSortName().getValue());
		
		container.clear();
		container.add(view.getWidgetContainer());
	}
	
	private void accountsFilter(Boolean departmentsRadioButton, Boolean nameRadioButton) {
		parentPresenter.showLoadScreen();
		if(departmentsRadioButton) {
			filterByDepartment();
		} else {
			filterByAlphabetical();
		}
		parentPresenter.hideLoadScreen();
	}
	
	private void filterByDepartment() {
		ArrayList<String> departments = new ArrayList<>();
		
		for(int i = 0; i < instructorInfoList.size(); i++) {
			boolean onList = false;
			for(int b = 0; b < departments.size(); b++) {
				if(instructorInfoList.get(i).getDepartment().equals(departments.get(b))){
					onList = true;
				}
			}
			if(!onList) {
				departments.add(instructorInfoList.get(i).getDepartment());
			}
		}
		
		java.util.Collections.sort(departments);
				
		ArrayList<UserInfo> alphaUserInfoList = alphabatize(userInfoList);
		
		ArrayList<Pair<InstructorInfo, UserInfo>> instructorsAndUsers = new ArrayList<>();

		for(int i = 0; i < alphaUserInfoList.size(); i++) {
			Boolean hasInstructor = false;
			for(int b = 0; b < instructorInfoList.size(); b++) {
				if(instructorInfoList.get(b).getUserInfoId() == alphaUserInfoList.get(i).getId()) {
					Pair<InstructorInfo, UserInfo> temp = new Pair(instructorInfoList.get(b), alphaUserInfoList.get(i));
					instructorsAndUsers.add(temp);
					hasInstructor = true;
					break;
				}
			}
			if(!hasInstructor) {
				Pair<InstructorInfo, UserInfo> temp2 = new Pair(new InstructorInfo(), alphaUserInfoList.get(i));
				instructorsAndUsers.add(temp2);
			}
			hasInstructor = false;
		}
		
		ArrayList<Pair<InstructorInfo, UserInfo>> sortedInstructorsAndUsers = new ArrayList<>();
				
		for(int i = 0; i < departments.size(); i++) {
			for(int b = 0; i < instructorsAndUsers.size(); b++) {
				if(departments.get(i).equals(instructorsAndUsers.get(b).getValue1().getDepartment())) {
					sortedInstructorsAndUsers.add(instructorsAndUsers.get(b));
				}
			}
		}
		
		for(int i = 0; i < instructorsAndUsers.size(); i++) {
			if(instructorsAndUsers.get(i).getValue1().getDepartment().isEmpty()) {
				sortedInstructorsAndUsers.add(instructorsAndUsers.get(i));
			}
		}
		
		for(int i = 0; i < sortedInstructorsAndUsers.size(); i++) {
			view.getListAccounts().addItem(sortedInstructorsAndUsers.get(i).getValue2().getUserName()
					+ " --- "
					+ sortedInstructorsAndUsers.get(i).getValue2().getFirstName()
					+ " "
					+ sortedInstructorsAndUsers.get(i).getValue2().getLastName()
					+ " "
					+ sortedInstructorsAndUsers.get(i).getValue1().getDepartment());
		}
	}
	
	private void filterByAlphabetical() {
		
		ArrayList<UserInfo> alphaUserInfoList = alphabatize(userInfoList);
		
		ArrayList<Pair<InstructorInfo, UserInfo>> instructorsAndUsers = new ArrayList<>();

		for(int i = 0; i < alphaUserInfoList.size(); i++) {
			Boolean hasInstructor = false;
			for(int b = 0; b < instructorInfoList.size(); b++) {
				if(instructorInfoList.get(b).getUserInfoId() == alphaUserInfoList.get(i).getId()) {
					Pair<InstructorInfo, UserInfo> temp = new Pair(instructorInfoList.get(b), alphaUserInfoList.get(i));
					instructorsAndUsers.add(temp);
					hasInstructor = true;
					break;
				}
			}
			if(!hasInstructor) {
				Pair<InstructorInfo, UserInfo> temp2 = new Pair(new InstructorInfo(), alphaUserInfoList.get(i));
				instructorsAndUsers.add(temp2);
			}
			hasInstructor = false;
		}
		
		for(int i = 0; i < instructorsAndUsers.size(); i++) {
			view.getListAccounts().addItem(instructorsAndUsers.get(i).getValue2().getUserName()
					+ " --- "
					+ instructorsAndUsers.get(i).getValue2().getFirstName()
					+ " "
					+ instructorsAndUsers.get(i).getValue2().getLastName()
					+ " "
					+ instructorsAndUsers.get(i).getValue1().getDepartment());
		}
	}
	
	private ArrayList<UserInfo> alphabatize(ArrayList<UserInfo> unsortedUsers){
		ArrayList<UserInfo> sortedUsers = new ArrayList<>();
		
		ArrayList<String> usernames = new ArrayList<>();
		
		for(int i = 0; i < unsortedUsers.size(); i++) {
			usernames.add(unsortedUsers.get(i).getUserName());
		}
		
		java.util.Collections.sort(usernames);
		
		for(int i = 0; i < usernames.size(); i++) {
			for(int a = 0; a < unsortedUsers.size(); a++) {
				if(usernames.get(i).equals(unsortedUsers.get(a).getUserName())) {
					sortedUsers.add(unsortedUsers.get(a));
					break;
				}
			}
		}
		
		return sortedUsers;
	}

	@Override
	public AccountsView getView() {
		return this.view;
	}

	@Override
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}

	@Override
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
	}

	@Override
	public void init() {
		bind();
	}
	@Override
	public void bind() {
		HandlerRegistration createAccountRegistration;
		createAccountRegistration = eventBus.addHandler(SendCreateAccountEvent.TYPE, this);
		eventBusRegistration.put(SendCreateAccountEvent.TYPE, createAccountRegistration);
		
		HandlerRegistration editAccountRegistration;
		editAccountRegistration = eventBus.addHandler(SendEditAccountEvent.TYPE,  this);
		eventBusRegistration.put(SendEditAccountEvent.TYPE, editAccountRegistration);
		
		HandlerRegistration removeAccountRegistration;
		removeAccountRegistration = eventBus.addHandler(SendRemoveAccountEvent.TYPE,  this);
		eventBusRegistration.put(SendRemoveAccountEvent.TYPE, removeAccountRegistration);
		
	}
	
	@Override
	public void applySort() {
		if(!applySortInProgress) {
			applySortInProgress = true;
			view.getButtonApply().setEnabled(false);
			accountsFilter(view.getRadioSortDepartment().getValue(), view.getRadioSortName().getValue());
			view.getButtonApply().setEnabled(true);
			applySortInProgress = false;
		}
	}
	
	@Override
	public void editCourse() {
		if (!editInProgress && !creationInProgress) {
			editInProgress = true;
			enableUserFields(true);
			view.getButtonApply().setEnabled(true);
			view.getButtonCancel().setEnabled(true);
			
		}
	}
	
	@Override
	public void populateAccountsViewer() {
		if(!populateAccountsInProgress) {
			populateAccountsInProgress = true;
			view.getButtonSort().setEnabled(false);
			populateViewer(view.getListAccounts().getValue(view.getListAccounts().getSelectedIndex()));
			view.getButtonSort().setEnabled(true);
			populateAccountsInProgress = false;
		}
	}
	
	private void populateViewer(String parsableString) {
		String username = "";
		
		for(int i = 0; i < parsableString.length(); i++) {
			if(parsableString.charAt(i) != ' ') {
				username = username + parsableString.charAt(i);
			} else {
				break;
			}
		}
		
		UserInfo user = new UserInfo();
		InstructorInfo instructor = new InstructorInfo();
		
		for(int i = 0; i < userInfoList.size(); i++) {
			if(userInfoList.get(i).getUserName().equals(username)) {
				user = userInfoList.get(i);
				break;
			}
		}
		
		boolean noInstructor = true;
		for(int i = 0; i < instructorInfoList.size(); i++) {
			if(instructorInfoList.get(i).getUserInfoId() == user.getId()) {
				instructor = instructorInfoList.get(i);
				noInstructor = false;
				break;
			}
		}
		if(noInstructor) {
			instructor.setDepartment("N/A");
			instructor.setCourseLoad(0);
			instructor.setOffice("N/A");
			instructor.setRank(0);
		}
		
		view.getEnterFirstName().setText(user.getFirstName());
		view.getEnterCourseLoad().setText(instructor.getCourseLoad().toString());
		view.getEnterDepartment().setText(instructor.getDepartment());
		view.getEnterEmail().setText(user.getEmail());
		view.getEnterFirstName().setText(user.getFirstName());
		view.getEnterLastName().setText(user.getLastName());
		view.getEnterOffice().setText(instructor.getOffice());
		view.getEnterRank().setText(instructor.getRank().toString());
		view.getEnterUserName().setText(user.getUserName());
	}

	@Override
	public void applyChanges() {
		if (editInProgress) {
			editInProgress = false;
			enableUserFields(false);
			view.getButtonApply().setEnabled(false);
			view.getButtonCancel().setEnabled(false);
			UserInfo user = new UserInfo();
			InstructorInfo instructor = new InstructorInfo();
			
			
			String username = view.getEnterUserName().getText();
			user.setUserName(username);
			String firstName = view.getEnterFirstName().getText();
			user.setFirstName(firstName);
			String lastName = view.getEnterLastName().getText();
			user.setLastName(lastName);
			String department = view.getEnterDepartment().getText();
			instructor.setDepartment(department);
			Integer rank = view.getEnterRank().getValue();
			instructor.setRank(rank);
			Integer courseLoad = view.getEnterCourseLoad().getValue();
			instructor.setCourseLoad(courseLoad);
			String office = view.getEnterOffice().getText();
			instructor.setOffice(office);
			String email = view.getEnterEmail().getText();
			user.setEmail(email);
			
			SendEditAccountAction seaa = new SendEditAccountAction(user, instructor);
			SendEditAccountEvent seae = new SendEditAccountEvent(seaa);
			eventBus.fireEvent(seae);
			
			
			
		}
		else if (creationInProgress) {
			creationInProgress = false;
			enableUserFields(false);
			view.getButtonApply().setEnabled(false);
			view.getButtonCancel().setEnabled(false);
			UserInfo user = new UserInfo();
			InstructorInfo instructor = new InstructorInfo();
			
			String username = view.getEnterUserName().getText();
			user.setUserName(username);
			String firstName = view.getEnterFirstName().getText();
			user.setFirstName(firstName);
			String lastName = view.getEnterLastName().getText();
			user.setLastName(lastName);
			String department = view.getEnterDepartment().getText();
			instructor.setDepartment(department);
			Integer rank = view.getEnterRank().getValue();
			instructor.setRank(rank);
			Integer courseLoad = view.getEnterCourseLoad().getValue();
			instructor.setCourseLoad(courseLoad);
			String office = view.getEnterOffice().getText();
			instructor.setOffice(office);
			String email = view.getEnterEmail().getText();
			user.setEmail(email);
			
			SendCreateAccountAction scaa = new SendCreateAccountAction(user, instructor);
			SendCreateAccountEvent scae = new SendCreateAccountEvent(scaa);
			eventBus.fireEvent(scae);
			
			
			
		}
	}

	@Override
	public void cancelChanges() {
		if (editInProgress) {
			editInProgress = false;
			clearUserFields();
			enableUserFields(false);
			view.getButtonApply().setEnabled(false);
			view.getButtonCancel().setEnabled(false);
		}
		else if (creationInProgress) {
			creationInProgress = false;
			clearUserFields();
			enableUserFields(false);
			view.getButtonApply().setEnabled(false);
			view.getButtonCancel().setEnabled(false);
		}
	}

	@Override
	public void removeAccount() {
		//String itemToRemove = view.getListAccounts().getValue(view.getListAccounts().getSelectedIndex());
		String accountInfo = view.getListAccounts().getItemText(view.getListAccounts().getSelectedIndex());
		
		SendRemoveAccountAction sraa = new SendRemoveAccountAction(accountInfo);
		SendRemoveAccountEvent srae = new SendRemoveAccountEvent(sraa);
		eventBus.fireEvent(srae);
		
		
	}

	@Override
	public void createAccount() {
		if (!creationInProgress && !editInProgress) {
			creationInProgress = true;
			enableUserFields(true);
			clearUserFields();
			view.getButtonApply().setEnabled(true);
			view.getButtonCancel().setEnabled(true);
		}
	}
	
	@Override
	public void onReceiveAccounts(ReceiveAccountsEvent evt) {
		HasWidgets container = evt.getContainer();
		ReceiveAccountsAction raa = evt.getAction();
		userInfoList = raa.getUserinfoList();
		instructorInfoList = raa.getInstructorInfoList();
		go(container);
		Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
	}
}
