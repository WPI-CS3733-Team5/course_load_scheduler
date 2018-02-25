package org.dselent.course_load_scheduler.client.action;

import java.util.ArrayList;

import org.dselent.course_load_scheduler.client.model.SectionInfo;

public class ReceiveWishlistForUserAction extends Action{
	private ArrayList<SectionInfo> sections;
	
	public ReceiveWishlistForUserAction(ArrayList<SectionInfo> sections) {
		this.sections = sections;
	}
	
	public ArrayList<SectionInfo> getSections(){
		return sections;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendWishlistForUserAction [user=");
		builder.append(sections.toString());
		builder.append("]");
		return builder.toString();
	}

}
