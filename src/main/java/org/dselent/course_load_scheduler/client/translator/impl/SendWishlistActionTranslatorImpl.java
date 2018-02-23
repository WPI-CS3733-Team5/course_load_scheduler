package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.action.ReceiveWishlistAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.model.WishlistLinks;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveWishlistKeys;
import org.dselent.course_load_scheduler.client.translator.ActionTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;


public class SendWishlistActionTranslatorImpl implements ActionTranslator<SendWishlistAction, ReceiveWishlistAction>
{
	@Override
	public JSONObject translateToJson(SendWishlistAction action)
	{
		JSONObject jsonObject = new JSONObject();
		return jsonObject;
		
	}
	
	@Override
	public ReceiveWishlistAction translateToAction(JSONObject json)
	{

		JSONValue jsonObject = json.get("success");
		JSONObject userObject = jsonObject.isArray().get(0).isObject();
		
		Integer id = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveWishlistKeys.ID));
		Integer instructorInfoId= JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveWishlistKeys.INSTRUCTOR_INFO_ID));
		Integer sectionInfoId = JSONHelper.getIntValue(userObject, JSONHelper.convertKeyName(ReceiveWishlistKeys.SECTION_INFO_ID));
		
		// TODO look into time conversion more
		// put into JSONHelper?
		
		WishlistLinks wishlist = new WishlistLinks();
		wishlist.setId(id);
		wishlist.setInstructorInfoId(instructorInfoId);
		wishlist.setSectionInfoId(sectionInfoId);
		
		ReceiveWishlistAction action = new ReceiveWishlistAction(wishlist);
		return action;	
		
	}

}