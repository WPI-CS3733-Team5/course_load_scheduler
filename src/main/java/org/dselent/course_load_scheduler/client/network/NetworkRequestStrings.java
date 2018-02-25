package org.dselent.course_load_scheduler.client.network;

public final class NetworkRequestStrings
{
	public static final String SERVER_LOCATION = "http://localhost:8080/";
	public static final String BASE_REQUEST = "course_load_scheduler/";
	public static final String LOGIN = "userInfo/GetOneUser";
	public static final String GET_ALL_USER_AND_INSTRUCTOR_INFO = "userInfo/getAll";
	public static final String GET_ONE_USER_AND_INSTRUCTOR_INFO = "userInfo/GetOneUser";
	public static final String GET_ALL_COURSE_SECTION_LAB_CALENDAR_INFO = "courses/getAllCourses";
	public static final String GET_ALL_USER_INSTRUCTOR_COURSE_SECTION_LAB_CALENDAR_SCHEDULE_INFO = "userInfo/theBigOne";
	
	private NetworkRequestStrings() {};
}