package org.dselent.course_load_scheduler.client.presenter.impl;

//created by David M.

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesCoursesAction;
import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesUsersAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSchedulesCoursesEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveSchedulesUsersEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.model.WishlistLinks;
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
	private Boolean taskInProgress;
	
	private ArrayList<SectionInfo> scheduleInProgress;
	
	private ArrayList<CourseInfo> courses;
	private ArrayList<SectionInfo> sections;
	private ArrayList<LabInfo> labs;
	private ArrayList<CalendarInfo> calendars;
	private ArrayList<UserInfo> users;
	private ArrayList<InstructorInfo> instructors;
	private ArrayList<WishlistLinks> wishlist;
	
	private boolean usersPopulated = false;
	private boolean coursesPopulated = false;
	
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
		taskInProgress = false;
		courses = null;
		sections = null;
		labs = null;
		calendars = null;
		users = null;
		instructors = null;
		wishlist = null;
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{
		/*
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
		*/
		}
		
	@Override
	public void go(HasWidgets container)
	{
		usersPopulated = false;
		coursesPopulated = false;
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
	
	public UserInfo getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(UserInfo user) {
		this.currentUser = user;
	}
	
	public ArrayList<CourseInfo> getCourses(){
		return courses;
	}
	public void setCourses(ArrayList<CourseInfo> courses) {
		this.courses = courses;
	}
	
	public ArrayList<SectionInfo> getSections(){
		return sections;
	}
	public void setSections(ArrayList<SectionInfo> sections) {
		this.sections = sections;
	}
	
	public ArrayList<LabInfo> getLabs(){
		return labs;
	}
	public void setLabs(ArrayList<LabInfo> labs) {
		this.labs = labs;
	}
	
	public ArrayList<CalendarInfo> getCalendars(){
		return calendars;
	}
	public void setCalendars(ArrayList<CalendarInfo> calendars) {
		this.calendars = calendars;
	}
	
	public ArrayList<UserInfo> getUsers(){
		return users;
	}
	public void setUsers(ArrayList<UserInfo> users) {
		this.users = users;
	}
	
	public ArrayList<InstructorInfo> getInstructors(){
		return instructors;
	}
	public void setInstructors(ArrayList<InstructorInfo> instructors) {
		this.instructors = instructors;
	}
	
	public ArrayList<WishlistLinks> getWishlist(){
		return wishlist;
	}
	public void setWishlist(ArrayList<WishlistLinks> wishlist) {
		this.wishlist = wishlist;
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
			//temporary variables to store user info and identify unique results
			boolean uniqueFirst = true;
			boolean uniqueLast = true;
			UserInfo userTempFull = null;
			UserInfo userTempFirst = null;
			UserInfo userTempLast = null;
			
			//search user list
			for(UserInfo u:users) {
				// set active user according to input if userName, firstNamelastName, or firstName lastName matches
				if((toSet == u.getFirstName() + u.getLastName())
						|| toSet == u.getFirstName() + " " + u.getLastName()
						|| toSet == u.getUserName()) {
					userTempFull = u;
				}
				// set active user according to input if only one lastName or firstName matches
				else if (toSet == u.getFirstName()){
					if(userTempFirst == null) {
						userTempFirst = u;
					}else {
						uniqueFirst = false;
					}
				}else if (toSet == u.getLastName()) {
					if(userTempLast == null) {
						userTempLast = u;
					}else {
						uniqueLast = false;
					}
				}
			}
			
			//populate current user field based on result of search
			//will remain null if no valid result or multiple valid results are present
			if(userTempFull == null) {
				if(uniqueFirst) {
					currentUser = userTempFirst;
				}else if(uniqueLast) {
					currentUser = userTempLast;
				}else {
					currentUser = null;
				}
			}else {
				currentUser = userTempFull;
			}
			
			//if a valid user has been selected, and they are identified as an instructor, request their wishlist
			if(currentUser != null) {
				boolean isInstructor = false;
				InstructorInfo instTemp;
				
				for(InstructorInfo i:instructors) {
					if(i.getUserInfoId() == currentUser.getId()) {
						isInstructor = true;
						instTemp = i;
					}
				}
				
				SendFullWishlistAction act = new SendFullWishlistAction(instTemp);
				SendFullWishlistEvent evt = new SendFullWishlistEvent(act);
				eventBus.fireEvent(evt);
			}
		}else {}
	}

	//helper method
	public void verifyCourse(String course) throws EmptyStringException{
		checkEmptyString(course);
	}
	
	//add a section to the schedule based on input in the course box
	public void addToSchedule(String toAdd) {	
		boolean validCourse = true;
		
		try {
			verifyCourse(toAdd);
		}catch(EmptyStringException e) {
			validCourse = false;
		}
		
		if(validCourse) {			
			String dept;
			String num;
			String name;
			String sect;
	
			for(SectionInfo s:sections) {
				for(CourseInfo c:courses) {
					if(c.getId() == s.getCourseInfoId()) {
						dept = c.getDepartment();
						num = Integer.toString(c.getCourseNumber());
						name = c.getCourseName();
						sect = Integer.toString(s.getSectionNumber());
					}
					
				}
				if(toAdd.equals(dept + num + sect) || toAdd.equals(dept + " " + num + " " + sect)
						|| toAdd.equals(name + sect) || toAdd.equals(name + " " + sect)) {
					scheduleInProgress.add(s);
					refreshSchedule();
				}
			}
		}else {}
	}

	//convert selections in the list box to a list of SectionInfo models
	public ArrayList<SectionInfo> parseSelected(){
		ArrayList<SectionInfo> output = new ArrayList<SectionInfo>();
		String selected;
		String dept;
		String num;
		String sect;
		
		//cycle through all items in the schedule list
		for(int i = 0; i < view.getCourseList().getItemCount(); i++) {
			if(view.getCourseList().isItemSelected(i)) {
				//if an item is selected, break its header down into substrings
				selected = view.getCourseList().getItemText(i);
				dept = selected.substring(0,2);
				num = selected.substring(3,7);
				sect = selected.substring(8,10);
				
				//search the sections list for a section with the appropriate details
				for(SectionInfo s:sections) {
					for(CourseInfo c:courses) {
						if(s.getCourseInfoId() == c.getId()
								&&c.getDepartment().equals(dept) 
								&& Integer.toString(c.getCourseNumber()).equals(num)
								&& Integer.toString(s.getSectionNumber()).equals(sect)) {
							output.add(s);
						}
					}
				}
				
				//reset selector variables for safety
				selected = null;
				dept = null;
				num = null;
				sect = null;
			}
		}
		
		return output;
	}
	
	//remove all items on a given list from the schedule
	public void removeFromSchedule(List<SectionInfo> removeList) {
		for(SectionInfo r: removeList) {
			for(SectionInfo s: scheduleInProgress) {
				if(s.equals(r)) {
					scheduleInProgress.remove(r);
				}
			}
		}
		
		refreshSchedule();
	}
	
	//remove all selected items from the schedule list
	public void removeSelected() {
		if(!taskInProgress) {
			taskInProgress = true;
			removeFromSchedule(parseSelected());
			taskInProgress = false;
		}
	}
	
	//helper method, does what it says on the tin
	private void checkEmptyString(String string) throws EmptyStringException
	{
		if(string == null || string.equals(""))
		{
			throw new EmptyStringException();
		}
	}
	
	//add all sections in the wishlist to the schedule in progress
	public void addRequested() {
		if(!taskInProgress) {
			taskInProgress = true;
			for(WishlistLinks w: wishlist) {
				for(SectionInfo s:sections) {
					if(s.getId() == w.getSectionInfoId()) {
						scheduleInProgress.add(s);
					}
				}
			}
			refreshSchedule();
			taskInProgress = false;
		}
	}
	
	//set all wishlist courses in the schedule in progress as selected
	public void selectRequested() {
		if(!taskInProgress) {
			taskInProgress = true;
			for(int i = 0; i < view.getCourseList().getItemCount(); i++) {
				if(view.getCourseList().getItemText(i).contains("(Requested)")) {
					view.getCourseList().setItemSelected(i, true);
				}
			}
		}
	}
	
	//if you can't suss out what this one does it might be time for another cup o' joe
	public void selectAll() {
		if(!taskInProgress) {
			taskInProgress = true;
			for(int i = 0; i < view.getCourseList().getItemCount(); i++) {
				view.getCourseList().setItemSelected(i, true);
			}
			taskInProgress = false;
		}
	}
	
	//nuke the schedule from orbit, it's the only way to be sure
	public void removeAll() {
		if(!taskInProgress) {
			taskInProgress = true;
			scheduleInProgress.clear();
			refreshSchedule();
			taskInProgress = false;			
		}
	}
	
	//clears the schedule list and repopulates it based on the stored sections
	public void refreshSchedule() {
		view.getCourseList().clear();
		
		for(SectionInfo s:scheduleInProgress) {
			view.getCourseList().addItem(writeSection(s));
		}
	}
	
	//write course info for a section to a string for placement in the list box
	public String writeSection(SectionInfo sectionIn) {
		String name;
		String dept;
		String num;
		boolean requested;
		
		for(WishlistLinks w:wishlist) {
			if(w.getSectionInfoId() == sectionIn.getId()) {
				requested = true;
			}
		}
		
		for(CourseInfo c: courses) {
			if(sectionIn.getCourseInfoId() == c.getId()) {
				name = c.getCourseName();
				dept = c.getDepartment();
				num = Integer.toString(c.getCourseNumber());
			}
		}
		
		if(requested) {
			return dept + " " + num + ", " + name + " (Requested)";
		}else {
			return dept + " " + num + ", " + name;
		}
	}
	
	public void cancel() {
		if(!taskInProgress)
		{
			taskInProgress = true;			
			//sendHome();
		}
	}
	//private void sendHome()
	//{
	//	SendHomeAction sha = new SendHomeAction();
	//	SendHomeEvent she = new SendHomeEvent(sha);
	//	eventBus.fireEvent(she);
	//}
	public void generate() {
		if(!taskInProgress) {
			taskInProgress = true;
			
			List<String> selected = null;
			
			for(int i = 0; i < view.getCourseList().getItemCount(); i++) {
				if(view.getCourseList().isItemSelected(i)) {
					selected.add(view.getCourseList().getItemText(i));
				}
			}
			
		//	SendGenerateAction sga = new SendGenerateAction(selected, currentUser);
		//	SendGenerateEvent sge = new SendGenerateEvent(sga);
		//	eventBus.fireEvend(sge);
		}
	}
	
	@Override
	public void onReceiveSchedulesUsers(ReceiveSchedulesUsersEvent evt) {
		HasWidgets container = evt.getContainer();
		ReceiveSchedulesUsersAction rsua = evt.getAction();
		users = rsua.getUsers();
		instructors = rsua.getInstructors();
		usersPopulated = true;
		if(usersPopulated && coursesPopulated) {
			go(container);
			Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
		}
	}
	
	@Override
	public void onReceiveSchedulesCourses(ReceiveSchedulesCoursesEvent evt) {
		HasWidgets container = evt.getContainer();
		ReceiveSchedulesCoursesAction rsca = evt.getAction();
		courses = rsca.getCourses();
		sections = rsca.getSections();
		labs = rsca.getLabs();
		calendars = rsca.getCalendars();
		coursesPopulated = true;
		if(usersPopulated && coursesPopulated) {
			go(container);
			Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
		}
	}
}
