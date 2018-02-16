package org.dselent.course_load_scheduler.client.presenter;

import java.util.List;

public interface ScheduleSelectPresenter extends BasePresenter{
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	String getTerm();
	void setTerm(String term);
	
	Integer getYear();
	void setYear(Integer year);
	
	List<CourseInfo> getCourseList();
	void setCourseList(List<CourseInfo> courseList);
	
	List<ScheduleInfo> getScheduleList();
	void setScheduleList(List<ScheduleInfo> scheduleList);
	void removeSelectedSchedule(ScheduleInfo toRemove);
	
	void displaySchedule();
	void back();
	void delete();
	void accept();
}
