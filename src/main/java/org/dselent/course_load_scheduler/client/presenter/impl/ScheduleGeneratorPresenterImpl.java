package org.dselent.course_load_scheduler.client.presenter.impl;

import java.util.List;

import org.dselent.course_load_scheduler.client.event.InvalidLoginEvent;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
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
	private List<SectionInfo> sectionList;
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
		sectionList = null;
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
		HandlerRegistration registration;
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
	
	public List<SectionInfo> getSectionList(){
		return sectionList;
	}
	public boolean verifySection(SectionInfo section) {}
	public void setSectionList(List<SectionInfo> sectionList) {
		this.sectionList = sectionList;
	}
	public void addToCourseList(SectionInfo toAdd) {
		sectionList.add(toAdd);
	}
	public void removeFromCourseList(List<SectionInfo> removeList) {
		for(SectionInfo C: removeList) {
			for(SectionInfo D: sectionList) {
				if(C.equals(D)) {
					sectionList.remove(D);
				}
			}
		}
	}
	
	public void addRequested();
	public void selectRequested();
	public void selectAll();
	public void removeSelected();
	public void removeAll();
	public void cancel();
	public void generate();
}
