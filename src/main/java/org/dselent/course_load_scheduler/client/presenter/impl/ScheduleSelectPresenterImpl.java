package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.List;

import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;
import org.dselent.course_load_scheduler.client.exceptions.NullIndexException;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleSelectPresenter;
import org.dselent.course_load_scheduler.client.view.ScheduleGeneratorView;
import org.dselent.course_load_scheduler.client.view.ScheduleSelectView;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;

public class ScheduleSelectPresenterImpl extends BasePresenterImpl implements ScheduleSelectPresenter {
	private IndexPresenter parentPresenter;
	private ScheduleSelectView view;
	private UserInfo user;
	private String term;
	private Integer year;
	private List<List<SectionInfo>> scheduleList;
	private List<SectionInfo> displayedSchedule;
	private Boolean taskInProgress;
	
	public ScheduleSelectPresenterImpl(IndexPresenter parentPresenter, ScheduleSelectView view, List<List<SectionInfo>> scheduleList)
	{
		this.view = view;
		this.parentPresenter = parentPresenter;
		view.setPresenter(this);
		this.scheduleList = scheduleList;
		term = null;
		year = null;
		displayedSchedule = null;
		taskInProgress = false;
		
		int i = 1;
		for(List<SectionInfo> s:scheduleList) {
			view.getScheduleListBox().addItem("Schedule" + i);
		}
	}
	
	@Override
	public ScheduleSelectView getView() {
		return view;
	}
	
	@Override
	public void go(HasWidgets container)
	{
		container.clear();
		container.add(view.getWidgetContainer());
	}
	
	@Override
	public void init()
	{
		bind();
	}
	
	@Override
	public void bind()
	{
//		HandlerRegistration schedulesRegistration;
//		schedulesRegistration = eventBus.addHandler(SendSchedulesEvent.TYPE, SendSchedulesEventHandler);
//		eventBusRegistration.put(SendSchedulesEvent.TYPE, schedulesRegistration);
//		
//		HandlerRegistration invalidSelectionRegistration;
//		invalidSelectionRegistration = eventBus.addHandler(InvalidSelectionEvent.TYPE, InvalidSelectionEventHandler);
//		eventBusRegistration.put(InvalidSelectionEvent.TYPE, invalidSelectionRegistration);
//		
//		HandlerRegistration commitScheduleRegistration;
//		commitScheduleRegistration = eventBus.addHandler(SendCommitScheduleEvent.TYPE, SendCommitScheduleEventHandler);
//		eventBusRegistration.put(SendCommitScheduleEvent.TYPE, commitScheduleRegistration);
	}
	
	public IndexPresenter getParentPresenter() {
		return parentPresenter;
	}
	public void setParentPresenter(IndexPresenter parentPresenter) {
		this.parentPresenter = parentPresenter;
	}
	
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public List<List<SectionInfo>> getScheduleList(){
		return scheduleList;
	}
	public void setScheduleList(List<List<SectionInfo>> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	public List<SectionInfo> getDisplayedSchedule(){
		return displayedSchedule;
	}
	public void setDisplayedSchedule(List<SectionInfo> displayedSchedule) {
		this.displayedSchedule = displayedSchedule;
	}
	
	//helper method to find the currently selected item in the schedule list box
	public Integer findSelected() throws NullIndexException{
		Integer targetIndex = null;
		
		for(int i = 0; i < view.getScheduleListBox().getItemCount(); i++) {
			if(view.getScheduleListBox().isItemSelected(i)) {
				targetIndex = i;
			}
		}
		
		if(targetIndex == null) {
			throw new NullIndexException();
		}else {
			return targetIndex;
		}
		
	}
	//method to set the displayed schedule to match the line selected in the schedule selector box
	public void viewSchedule(){
		Integer targetIndex = null;
		Boolean proceed = true;
		
		try {
			targetIndex = findSelected();
		}catch(NullIndexException e) {
			proceed = false;
		}
		
		if(proceed) {
			setDisplayedSchedule(scheduleList.get(targetIndex));
			for(SectionInfo c:displayedSchedule) {
				view.getCourseListBox().addItem(c.getSectionNumber() + c.getSectionType());
			}
		}else {
//			InvalidSelectionAction isa = new InvalidSelectionAction();
//			InvalidSelectionEvent ise = new InvalidSelectionEvent(isa);
//			eventBus.fireEvent(ise);
		}
	}
	//returns to the schedule generator pane
	public void back() {
		SendSchedulesAction ssa = new SendSchedulesAction(view.getViewRootPanel());
		SendSchedulesEvent sse = new SendSchedulesEvent(ssa);
		eventBus.fireEvent(sse);
	}
	//deletes the currently selected item from the schedule list. cannot be reversed
	public void delete() {
		Integer targetIndex = null;
		Boolean proceed = true;
		
		try {
			targetIndex = findSelected();
		}catch(NullIndexException e) {
			proceed = false;
		}
		
		if(proceed) {
			scheduleList.remove(targetIndex);
			view.getScheduleListBox().removeItem(targetIndex);
			view.getCourseListBox().clear();
		}else {
//			InvalidSelectionAction isa = new InvalidSelectionAction();
//			InvalidSelectionEvent ise = new InvalidSelectionEvent(isa);
//			eventBus.fireEvent(ise);
		}
	}
	public void accept() {
		Integer targetIndex = null;
		Boolean proceed = true;
		
		try {
			targetIndex = findSelected();
		}catch(NullIndexException e) {
			proceed = false;
		}
		
		if(proceed) {
//			SendCommitScheduleAction scsa = new SendCommitScheduleAction(scheduleList.get(targetIndex));
//			SendCommitScheduleEvent scse = new SendCommitScheduleEvent(scsa);
//			eventBus.fireEvent(scse);
		}
	}
}
