package org.dselent.course_load_scheduler.client.translator;

import org.dselent.course_load_scheduler.client.model.Model;

import com.google.gwt.json.client.JSONObject;

public interface ModelTranslator<M extends Model>
{
	public JSONObject translateToJson(M object);
	public M translateToModel(JSONObject json);
}