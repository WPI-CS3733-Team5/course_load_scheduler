package org.dselent.course_load_scheduler.client.presenter;

import java.util.List;

public interface ScheduleGeneratorPresenter extends BasePresenter {
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	
	String getTermOne();
	void setTermOne(String term);
	String getTermTwo();
	void setTermTwo(String term);
	
	Integer getYearOne();
	void setYearOne(Integer year);
	Integer getYearTwo();
	void setYearTwo(Integer year);
	
	UserInfo getUserInfo();
	void setUserInfo(UserInfo user);
	
	List<CourseInfo> getCourseList();
	boolean verifyCourse(CourseInfo course);
	void setCourseList(List<CourseInfo> courseList);
	void addToCourseList(List<CourseInfo> addList);
	void removeFromCourseList(List<CourseInfo> removeList);
	
	void addRequested();
	void selectRequested();
	void selectAll();
	void removeSelected();
	void removeAll();
	void cancel();
	void generate();
}
