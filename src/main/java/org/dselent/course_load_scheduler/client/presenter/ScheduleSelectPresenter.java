package org.dselent.course_load_scheduler.client.presenter;

//created by David M.

import java.util.List;

import org.dselent.course_load_scheduler.client.model.SectionInfo;

public interface ScheduleSelectPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	String getTerm();
	void setTerm(String term);
	
	Integer getYear();
	void setYear(Integer year);
	
	List<SectionInfo> getCourseList();
	void setCourseList(List<SectionInfo> courseList);
	
	List<ScheduleInfo> getScheduleList();
	void setScheduleList(List<ScheduleInfo> scheduleList);
	void removeSelectedSchedule(ScheduleInfo toRemove);
	
	void displaySchedule();
	void back();
	void delete();
	void accept();
}
