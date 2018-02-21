package org.dselent.course_load_scheduler.client.network;

public final class NetworkRequestStrings
{
	public static final String SERVER_LOCATION = "http://localhost:8080/";
	public static final String BASE_REQUEST = "course_load_scheduler/";
	public static String LOGIN = "user/login";
	public static String HOME = "userInfo/getAll";
	public static String PROFILE = "userInfo/GetOneUser";
	
	private NetworkRequestStrings() {};
}