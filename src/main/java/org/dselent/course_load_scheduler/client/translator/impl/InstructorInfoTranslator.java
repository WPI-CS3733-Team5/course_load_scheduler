package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.model.InstructorInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.KeyPrefix;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveInstructorInfoKeys;
import org.dselent.course_load_scheduler.client.translator.ReceiveModelTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class InstructorInfoTranslator implements ReceiveModelTranslator<InstructorInfo>
{
	@Override
	public InstructorInfo translateToModel(JSONObject json)
	{		
		String idKey = JSONHelper.createKey(KeyPrefix.INSTRUCTOR_INFO, ReceiveInstructorInfoKeys.ID);
		String rankKey = JSONHelper.createKey(KeyPrefix.INSTRUCTOR_INFO, ReceiveInstructorInfoKeys.RANK);
		String courseLoadKey = JSONHelper.createKey(KeyPrefix.INSTRUCTOR_INFO, ReceiveInstructorInfoKeys.COURSE_LOAD);
		String officeKey = JSONHelper.createKey(KeyPrefix.INSTRUCTOR_INFO, ReceiveInstructorInfoKeys.OFFICE);
		String userInfoIdKey = JSONHelper.createKey(KeyPrefix.INSTRUCTOR_INFO, ReceiveInstructorInfoKeys.USER_INFO_ID);
		
		Integer id = JSONHelper.getIntValue(json, idKey);
		Integer rank = JSONHelper.getIntValue(json, rankKey);
		Integer courseLoad = JSONHelper.getIntValue(json, courseLoadKey);
		String office = JSONHelper.getStringValue(json, officeKey);
		Integer userInfoId = JSONHelper.getIntValue(json, userInfoIdKey);

		InstructorInfo instructorInfo = new InstructorInfo();
		instructorInfo.setId(id);
		instructorInfo.setRank(rank);
		instructorInfo.setCourseLoad(courseLoad);
		instructorInfo.setOffice(office);
		instructorInfo.setUserInfoId(userInfoId);
		
		return instructorInfo;
	}
}