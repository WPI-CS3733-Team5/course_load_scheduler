package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.model.WishlistLinks;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.KeyPrefix;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveLabsKeys;
import org.dselent.course_load_scheduler.client.translator.ReceiveModelTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class WishlistLinksTranslator implements ReceiveModelTranslator<WishlistLinks>
{
	@Override
	public WishlistLinks translateToModel(JSONObject json)
	{		
		String idKey = JSONHelper.createKey(KeyPrefix.WISHLIST_LINKS, ReceiveLabsKeys.ID);
		String instructorInfoIdKey = JSONHelper.createKey(KeyPrefix.WISHLIST_LINKS, ReceiveLabsKeys.INSTRUCTOR_INFO_ID);
		String sectionInfoIdKey = JSONHelper.createKey(KeyPrefix.WISHLIST_LINKS, ReceiveLabsKeys.SECTION_INFO_ID);
		
		Integer id = JSONHelper.getIntValue(json, idKey);
		Integer instructorInfoId= JSONHelper.getIntValue(json, instructorInfoIdKey);
		Integer sectionInfoId = JSONHelper.getIntValue(json, sectionInfoIdKey);

		WishlistLinks wishlistLinks = new WishlistLinks();
		wishlistLinks.setId(id);
		wishlistLinks.setInstructorInfoId(instructorInfoId);
		wishlistLinks.setSectionInfoId(sectionInfoId);

		return wishlistLinks;
	}
}