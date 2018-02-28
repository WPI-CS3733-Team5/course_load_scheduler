package org.dselent.course_load_scheduler.client.translator;

import org.dselent.course_load_scheduler.client.model.Model;

import com.google.gwt.json.client.JSONObject;

public interface ReceiveModelTranslator<M extends Model>
{
	public M translateToModel(JSONObject json);
}