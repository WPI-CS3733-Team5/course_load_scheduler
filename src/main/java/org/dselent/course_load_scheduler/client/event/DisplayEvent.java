package org.dselent.course_load_scheduler.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.HasWidgets;

public abstract class DisplayEvent<E extends EventHandler> extends GwtEvent<E>
{
	// What should this be?
	// Would a "parent" view or associated presenter be better?
	//		Would that generalize/work?
	// When lacking an oracle, try and see what happens...
	private HasWidgets container;
	
	public DisplayEvent(HasWidgets container)
	{
		this.container = container;
	}
	
	public HasWidgets getContainer()
	{
		return container;
	}
}