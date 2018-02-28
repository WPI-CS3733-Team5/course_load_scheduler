package org.dselent.course_load_scheduler.client.presenter.impl;

//created by David M.

import java.util.ArrayList;
import java.util.List;

import org.dselent.course_load_scheduler.client.action.ReceiveSchedulesAction;
import org.dselent.course_load_scheduler.client.action.ReceiveWishlistForUserAction;
import org.dselent.course_load_scheduler.client.action.SendGenerateAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistForUserAction;
import org.dselent.course_load_scheduler.client.event.ReceiveSchedulesEvent;
import org.dselent.course_load_scheduler.client.event.ReceiveWishlistForUserEvent;
import org.dselent.course_load_scheduler.client.event.SendGenerateEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistForUserEvent;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.exceptions.ScheduleConflictException;
import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleGeneratorPresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleGeneratorView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class ScheduleGeneratorPresenterImpl extends BasePresenterImpl implements ScheduleGeneratorPresenter{
	private IndexPresenter parentPresenter;
	private ScheduleGeneratorView view;
	private Integer termOne;
	private Integer termTwo;
	private Integer yearOne;
	private Integer yearTwo;
	private UserInfo currentUser;
	private InstructorInfo instructor;
	private Boolean taskInProgress;
	
	private ArrayList<SectionInfo> scheduleInProgress;
	
	private ArrayList<CourseInfo> courses;
	private ArrayList<SectionInfo> sections;
	private ArrayList<LabInfo> labs;
	private ArrayList<CalendarInfo> calendars;
	private ArrayList<UserInfo> users;
	private ArrayList<InstructorInfo> instructors;
	private ArrayList<SectionInfo> wishlist;
	
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
		
		HandlerRegistration homeRegistration;
		homeRegistration = eventBus.addHandler(SendHomeEvent.TYPE, this);
		eventBusRegistration.put(SendHomeEvent.TYPE, homeRegistration);
		
		/*
		HandlerRegistration sendWishlistEventRegistration;
		sendWishlistEventRegistration = eventBus.addHandler(SendWishlistForUserEvent.TYPE, this);
		eventBusRegistration.put(SendWishlistForUserEvent.TYPE, sendWishlistEventRegistration);
		
		HandlerRegistration sendGenerateEventRegistration;
		sendGenerateEventRegistration = eventBus.addHandler(SendGenerateEvent.TYPE, this);
		eventBusRegistration.put(SendGenerateEvent.TYPE, sendGenerateEventRegistration);
		*/
		HandlerRegistration receiveScheduleRegistration;
		receiveScheduleRegistration = eventBus.addHandler(ReceiveSchedulesEvent.TYPE, this);
		eventBusRegistration.put(ReceiveSchedulesEvent.TYPE, receiveScheduleRegistration);
		
		HandlerRegistration receiveWishlistRegistration;
		receiveWishlistRegistration = eventBus.addHandler(ReceiveWishlistForUserEvent.TYPE, this);
		eventBusRegistration.put(ReceiveWishlistForUserEvent.TYPE, receiveWishlistRegistration);
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
	
	public Integer getTermOne() {
		return termOne;
	}
	public void setTermOne(Integer term) {
		this.termOne = term;
	}
	public Integer getTermTwo() {
		return termTwo;
	}
	public void setTermTwo(Integer term) {
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
	
	public InstructorInfo getInstructor() {
		return instructor;
	}
	public void setInstructor(InstructorInfo instructor) {
		this.instructor = instructor;
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
	
	public ArrayList<SectionInfo> getWishlist(){
		return wishlist;
	}
	public void setWishlist(ArrayList<SectionInfo> wishlist) {
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
				
				for(InstructorInfo i:instructors) {
					if(i.getUserInfoId() == currentUser.getId()) {
						instructor = i;
						SendWishlistForUserAction act = new SendWishlistForUserAction(currentUser.getUserName());
						SendWishlistForUserEvent evt = new SendWishlistForUserEvent(act, view.getViewRootPanel());
						eventBus.fireEvent(evt);
					}
				}
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
			String dept = null;
			String num = null;
			String name = null;
			String sect = null;
			
			SectionInfo tempSect = null;
			CalendarInfo tempCal = null;
	
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
					tempSect = s;
				}
			}
			
			//logic to exclude sections outside the given term and year range
			for(CalendarInfo c:calendars) {
				if(c.getId() == tempSect.getCalendarInfoId()) {
					tempCal = c;
				}
			}
			
			if(tempCal.getYear() >= yearOne 
					&& tempCal.getYear() <= yearTwo
					&&tempCal.getTerm() >= termOne 
					&& tempCal.getTerm() <= termTwo) {
				scheduleInProgress.add(tempSect);
				refreshSchedule();
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
	public void checkEmptyString(String string) throws EmptyStringException
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
			for(SectionInfo w: wishlist) {
				scheduleInProgress.add(w);
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
		String name = null;
		String dept = null;
		String num = null;
		boolean requested = false;
		
		for(SectionInfo w:wishlist) {
			if(w.getId() == sectionIn.getId()) {
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
			sendHome();
		}
	}
	public void sendHome()
	{
		//TODO FIX THIS
		SendHomeAction sha = new SendHomeAction();
		SendHomeEvent she = new SendHomeEvent(sha, parentPresenter.getView().getViewRootPanel());
		eventBus.fireEvent(she);
	}
	public void generate() {
		if(!taskInProgress) {
			taskInProgress = true;
			
			ArrayList<CalendarInfo> calOut = new ArrayList<>();
			
			for(SectionInfo s:scheduleInProgress) {
				for(CalendarInfo c:calendars) {
					if(c.getId() == s.getCalendarInfoId()) {
						calOut.add(c);
					}
				}
			}
			
			try {
				for(CalendarInfo c1:calOut) {
					for(CalendarInfo c2:calOut) {
						if(calOut.indexOf(c1) != calOut.indexOf(c2)) {
							if(c1.getYear() == c2.getYear()
									&& c1.getSemester().contentEquals(c2.getSemester())
									&& c1.getTerm() == c2.getTerm()
									&& c1.getDays().contentEquals(c2.getDays())
									&& (c1.getStartTime() < c2.getEndTime()
											|| c1.getEndTime() > c2.getStartTime())) {
								throw new ScheduleConflictException();
							}
						}
					}
					
					SendGenerateAction act = new SendGenerateAction(instructor, scheduleInProgress);
					SendGenerateEvent evt = new SendGenerateEvent(act, view.getViewRootPanel());
					eventBus.fireEvent(evt);
				}
			}catch(ScheduleConflictException e) {
				
			}
		}
	}
	
	@Override
	public void onReceiveSchedules(ReceiveSchedulesEvent evt) {
		HasWidgets container = evt.getContainer();
		ReceiveSchedulesAction rha = evt.getReceiveSchedulesAction();
		users = rha.getUsers();
		instructors = rha.getInstructors();
		courses = rha.getCourses();
		sections = rha.getSections();
		labs = rha.getLabs();
		calendars = rha.getCalendars();
		go(container);
		Injector.INSTANCE.getIndexPresenter().hideLoadScreen();
	}
	
	@Override
	public void onReceiveWishlistForUser(ReceiveWishlistForUserEvent evt) {
		ReceiveWishlistForUserAction act = evt.getAction();
		wishlist = act.getSections();
	}
}
