package org.dselent.course_load_scheduler.client.presenter.impl;

//created by David M.

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleGeneratorPresenter;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.view.ScheduleGeneratorView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class ScheduleGeneratorPresenterImpl extends BasePresenterImpl implements ScheduleGeneratorPresenter{
	private IndexPresenter parentPresenter;
	private ScheduleGeneratorView view;
	private String termOne;
	private String termTwo;
	private Integer yearOne;
	private Integer yearTwo;
	private UserInfo currentUser;
	private List<CourseInfo> courseList;
	private List<CourseInfo> requestedList;
	private Boolean taskInProgress;
	
	@Inject
	public ScheduleGeneratorPresenterImpl(IndexPresenter parentPresenter, ScheduleGeneratorView view)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		termOne = null;
		termTwo = null;
		yearOne = null;
		yearTwo = null;
		currentUser = null;
		courseList = null;
		requestedList = null;
		taskInProgress = false;
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		HandlerRegistration homeRegistration;
		homeRegistration = eventBus.addHandler(SendHomeEvent.TYPE, SendHomeEventHandler);
		eventBusRegistration.put(SendHomeEvent.TYPE, homeRegistration);
		
		HandlerRegistration invalidUserRegistration;
		invalidUserRegistration = eventBus.addHandler(InvalidUserEvent.TYPE, InvalidUserEventHandler);
		eventBusRegistration.put(InvalidUserEvent.TYPE, invalidUserRegistration);
		
		HandlerRegistration invalidCourseRegistration;
		invalidCourseRegistration = eventBus.addHandler(InvalidCourseEvent.TYPE, InvalidCourseEventHandler);
		eventBusRegistration.put(InvalidCourseEvent.TYPE, invalidCourseRegistration);
		
		HandlerRegistration sendUserInfoEventRegistration;
		sendUserInfoEventRegistration = eventBus.addHandler(SendUserInfoEvent.TYPE, SendUserInfoEventHandler);
		eventBusRegistration.put(SendUserInfoEvent.TYPE, sendUserInfoEventRegistration);
		
		HandlerRegistration sendCourseInfoEventRegistration;
		sendCourseInfoEventRegistration = eventBus.addHandler(SendCourseInfoEvent.TYPE, SendCourseInfoEventHandler);
		eventBusRegistration.put(SendCourseInfoEvent.TYPE, sendCourseInfoEventRegistration);
		
		HandlerRegistration sendWishlistEventRegistration;
		sendWishlistEventRegistration = eventBus.addHandler(SendWishlistEvent.TYPE, SendWishlistEventHandler);
		eventBusRegistration.put(SendWishlistEvent.TYPE, sendWishlistEventRegistration);
		
		HandlerRegistration sendGenerateEventRegistration;
		sendGenerateEventRegistration = eventBus.addHandler(SendGenerateEvent.TYPE, SendGenerateEventHandler);
		eventBusRegistration.put(SendGenerateEvent.TYPE, sendGenerateEventRegistration);
	}
		
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}
	
	public ScheduleGeneratorView getView() {
		return view;
	}
	
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
	}
	
	public String getTermOne() {
		return termOne;
	}
	public void setTermOne(String term) {
		this.termOne = term;
	}
	public String getTermTwo() {
		return termTwo;
	}
	public void setTermTwo(String term) {
		this.termTwo = term;
	}
	
	public Integer getYearOne() {
		return yearOne;
	}
	public void setYearOne(Integer year) {
		this.yearOne = year;
	}
	public Integer getYearTwo() {
		return yearTwo;
	}
	public void setYearTwo(Integer year) {
		this.yearTwo = year;
	}
	
	public UserInfo getUserInfo() {
		return currentUser;
	}
	public void setUserInfo(UserInfo user) {
		this.currentUser = user;
	}
	public void verifyUser(String user) throws EmptyStringException{
		checkEmptyString(user);
	}
	//set the active user and make their wishlist active
	public void setUserSubject(String toSet) {
		boolean validUser = true;
		
		try {
			verifyUser(toSet);
		}catch(EmptyStringException e) {
			validUser = false;
		}
		
		if(validUser) {
			sendUserRequest(toSet);
			sendWishlistRequest(toSet);
		}else {
			InvalidUserAction iua = new InvalidUserAction(toSet);
			InvalidUserEvent iue = new InvalidUserEvent(iua);
			eventBus.fireEvent(iue);
		}
	}
	public void sendUserRequest(String user) {
		SendUserInfoAction suia = new SendUserInfoAction(user);
		SendUserInfoEvent suie = new SendUserInfoEvent(suia);
		eventBus.fireEvent(suie);
	}
	public void sendWishlistRequest(String user) {
		SendWishlistAction swa = new SendWishlistAction(user);
		SendWishlistEvent swe = new SendWishlistEvent(swa);
		eventBus.fireEvent(swe);
	}
	
	public List<CourseInfo> getCourseList(){
		return courseList;
	}
	public void setCourseList(List<CourseInfo> courseList) {
		this.courseList = courseList;
	}
	public void verifyCourse(String course) throws EmptyStringException{
		checkEmptyString(course);
	}
	public void addToCourseList(String toAdd) {	
		boolean validCourse = true;
		
		try {
			verifyCourse(toAdd);
		}catch(EmptyStringException e) {
			validCourse = false;
		}
		
		if(validCourse) {
			sendCourseRequest(toAdd);
		}else {
			InvalidCourseAction ica = new InvalidCourseAction(toAdd);
			InvalidCourseEvent ice = new InvalidCourseEvent(ica);
			eventBus.fireEvent(ice);
		}
	}
	public void sendCourseRequest(String course) {
		SendCourseInfoAction scia = new SendCourseInfoAction(course);
		SendCourseInfoEvent scie = new SendCourseInfoEvent(scia);
		eventBus.fireEvent(scie);
	}
	public void removeFromCourseList(List<CourseInfo> removeList) {
		for(CourseInfo C: removeList) {
			for(CourseInfo D: courseList) {
				if(C.equals(D)) {
					courseList.remove(D);
				}
			}
		}
	}
	
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	public void addRequested() {
		if(!taskInProgress) {
			taskInProgress = true;
			for(CourseInfo c: requestedList) {
				view.getCourseList().addItem(c.getCourseName());
			}
			taskInProgress = false;
		}
	}
	public void selectRequested() {
		if(!taskInProgress) {
			taskInProgress = true;
			for(int i = 0; i < view.getCourseList().getItemCount(); i++) {
				for(int j = 0; j < requestedList.size(); j++) {
					if(requestedList.get(j).getCourseName() == view.getCourseList().getItemText(i)) {
						view.getCourseList().setItemSelected(i, true);
					}
				}
			}
		}
	}
	public void selectAll() {
		if(!taskInProgress) {
			taskInProgress = true;
			for(int i = 0; i < view.getCourseList().getItemCount(); i++) {
				view.getCourseList().setItemSelected(i, true);
			}
			taskInProgress = false;
		}
	}
	public void removeSelected() {
		if(!taskInProgress) {
			taskInProgress = true;
			for(int i = 0; i < view.getCourseList().getItemCount(); i++) {
				if(view.getCourseList().isItemSelected(i)) {
					view.getCourseList().removeItem(i);
				}
			}
			taskInProgress = false;
		}
	}
	public void removeAll() {
		if(!taskInProgress) {
			taskInProgress = true;
			view.getCourseList().clear();
			taskInProgress = false;			
		}
	}
	public void cancel() {
		if(!taskInProgress)
		{
			taskInProgress = true;			
			sendHome();
		}
	}
	private void sendHome()
	{
		SendHomeAction sha = new SendHomeAction();
		SendHomeEvent she = new SendHomeEvent(sha);
		eventBus.fireEvent(she);
	}
	public void generate() {
		if(!taskInProgress) {
			taskInProgress = true;
			
			List<String> selected = null;
			
			for(int i = 0; i < view.getCourseList().getItemCount(); i++) {
				if(view.getCourseList().isItemSelected(i)) {
					selected.add(view.getCourseList().getItemText(i));
				}
			}
			
			SendGenerateAction sga = new SendGenerateAction(selected, currentUser);
			SendGenerateEvent sge = new SendGenerateEvent(sga);
			eventBus.fireEvend(sge);
		}
	}
	
	@Override
	public void onSendSchedules(SendSchedulesEvent evt) {
		go(evt.getAction().getPanel());
	}
}
