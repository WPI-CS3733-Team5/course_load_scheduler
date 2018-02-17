package org.dselent.course_load_scheduler.client.presenter;

//created by David M.

import java.util.List;

import org.dselent.course_load_scheduler.client.exceptions.NullIndexException;
import org.dselent.course_load_scheduler.client.model.SectionInfo;
import org.dselent.course_load_scheduler.client.model.UserInfo;

public interface ScheduleSelectPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	UserInfo getUser();
	void setUser(UserInfo user);
	
	String getTerm();
	void setTerm(String term);
	
	Integer getYear();
	void setYear(Integer year);
	
	List<List<SectionInfo>> getScheduleList();
	void setScheduleList(List<List<SectionInfo>> scheduleList);
	
	List<SectionInfo> getDisplayedSchedule();
	void setDisplayedSchedule(List<SectionInfo> displayedSchedule);
		
	Integer findSelected() throws NullIndexException;
	void viewSchedule();
	void back();
	void delete();
	void accept();
}
