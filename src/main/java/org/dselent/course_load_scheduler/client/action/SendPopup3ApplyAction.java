package org.dselent.course_load_scheduler.client.action;

public class SendPopup3ApplyAction {
	
	private String apply;
	
	public SendPopup3ApplyAction(String apply) {
		
		this.apply = apply;
		
	}
	
	public String getApply() {
		return apply;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("SendPopup3ApplyAction [apply=");
		builder.append(apply);
		builder.append("]");
		return builder.toString();
	}

}
