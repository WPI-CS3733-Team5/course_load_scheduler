package org.dselent.course_load_scheduler.client.presenter;

import java.util.List;

import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;

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
	
	List<SectionInfo> getCourseList();
	boolean verifyCourse(SectionInfo section);
	void setCourseList(List<SectionInfo> sectionList);
	void addToCourseList(List<SectionInfo> addList);
	void removeFromCourseList(List<SectionInfo> removeList);
	
	void addRequested();
	void selectRequested();
	void selectAll();
	void removeSelected();
	void removeAll();
	void cancel();
	void generate();
}
