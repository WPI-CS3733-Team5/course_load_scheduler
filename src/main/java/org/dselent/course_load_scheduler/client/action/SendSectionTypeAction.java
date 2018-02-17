package org.dselent.course_load_scheduler.client.action;

public class SendSectionTypeAction {
	
	private String sectionType;
	
	public SendSectionTypeAction(String sectionType) {
		this.sectionType = sectionType;
	}

	public String getSectionType() {
		return sectionType;
	}

	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendSectionTypeAction [sectionType=");
		builder.append(sectionType);
		builder.append("]");
		return builder.toString();
	}

}
