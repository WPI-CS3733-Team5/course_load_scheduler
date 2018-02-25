package org.dselent.course_load_scheduler.client.presenter;

import java.util.ArrayList;

//created by David M.

import java.util.List;

import org.dselent.course_load_scheduler.client.model.UserInfo;
import org.dselent.course_load_scheduler.client.view.ScheduleGeneratorView;
import org.dselent.course_load_scheduler.client.exceptions.EmptyStringException;
import org.dselent.course_load_scheduler.client.model.CalendarInfo;
import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.model.LabInfo;
import org.dselent.course_load_scheduler.client.model.SectionInfo;

public interface ScheduleGeneratorPresenter extends BasePresenter {

	public ScheduleGeneratorView getView();
	IndexPresenter getParentPresenter();
	void setParentPresenter(IndexPresenter parentPresenter);
	Integer getTermOne();
	void setTermOne(Integer term);
	Integer getTermTwo();
	void setTermTwo(Integer term);
	Integer getYearOne();
	void setYearOne(Integer year);
	Integer getYearTwo();
	void setYearTwo(Integer year);
	UserInfo getCurrentUser();
	void setCurrentUser(UserInfo user);
	ArrayList<CourseInfo> getCourses();
	void setCourses(ArrayList<CourseInfo> courses);
	ArrayList<SectionInfo> getSections();
	void setSections(ArrayList<SectionInfo> sections);
	ArrayList<LabInfo> getLabs();
	void setLabs(ArrayList<LabInfo> labs);
	ArrayList<CalendarInfo> getCalendars();
	void setCalendars(ArrayList<CalendarInfo> calendars);
	ArrayList<UserInfo> getUsers();
	void setUsers(ArrayList<UserInfo> users);
	ArrayList<InstructorInfo> getInstructors();
	void setInstructors(ArrayList<InstructorInfo> instructors);
	ArrayList<SectionInfo> getWishlist();
	void setWishlist(ArrayList<SectionInfo> wishlist);
	
	void verifyUser(String user) throws EmptyStringException;
	void setUserSubject(String toSet);
	void addToSchedule(String toAdd);
	ArrayList<SectionInfo> parseSelected();
	void removeFromSchedule(List<SectionInfo> removeList);
	void removeSelected();
	void checkEmptyString(String string) throws EmptyStringException;
	void addRequested();
	void selectRequested();
	void selectAll();
	void removeAll();
	void refreshSchedule();
	String writeSection(SectionInfo sectionIn);
	void cancel();
	void sendHome();
}
