package org.dselent.course_load_scheduler.client.presenter;

//created by David M.

import java.util.List;

import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.CourseInfo;

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
	void verifyUserInfo(String user) throws EmptyStringException;
	
	List<CourseInfo> getCourseList();
	void verifyCourse(String course) throws EmptyStringException;
	void setCourseList(List<CourseInfo> sectionList);
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
