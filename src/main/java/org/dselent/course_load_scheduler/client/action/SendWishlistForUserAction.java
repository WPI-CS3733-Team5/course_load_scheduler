package org.dselent.course_load_scheduler.client.action;

public class SendWishlistForUserAction extends Action {
	private String userName;
	
	public SendWishlistForUserAction(String userName) {
		this.userName = userName;
	}
	
	public String getUser() {
		return userName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendWishlistForUserAction [userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}
}
