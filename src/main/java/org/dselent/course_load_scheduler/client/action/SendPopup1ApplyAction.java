package org.dselent.course_load_scheduler.client.action;

public class SendPopup1ApplyAction {
	
	private String sectionType;
	
	public SendPopup1ApplyAction(String sectionType) {
		this.sectionType = sectionType;
	}
	
	public String getSectionType() {
		return sectionType;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendAddToWishlistAction [sectionType=");
		builder.append(sectionType);
		builder.append("]");
		return builder.toString();
	}

}
