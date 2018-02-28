package org.dselent.course_load_scheduler.client.translator.impl;

import org.dselent.course_load_scheduler.client.model.CourseInfo;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.KeyPrefix;
import org.dselent.course_load_scheduler.client.receive.jsonkeys.ReceiveCoursesKeys;
import org.dselent.course_load_scheduler.client.translator.ReceiveModelTranslator;
import org.dselent.course_load_scheduler.client.utils.JSONHelper;

import com.google.gwt.json.client.JSONObject;

public class CourseInfoTranslator implements ReceiveModelTranslator<CourseInfo>
{
	@Override
	public CourseInfo translateToModel(JSONObject json)
	{	
		String idKey = JSONHelper.createKey(KeyPrefix.COURSE_INFO, ReceiveCoursesKeys.ID);
		String courseNameKey = JSONHelper.createKey(KeyPrefix.COURSE_INFO, ReceiveCoursesKeys.COURSE_NAME);
		String requiredFrequencyPerTermKey = JSONHelper.createKey(KeyPrefix.COURSE_INFO, ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_TERM);
		String requiredFrequencyPerSemesterKey = JSONHelper.createKey(KeyPrefix.COURSE_INFO, ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_SEMESTER);
		String requiredFrequencyPerYearKey = JSONHelper.createKey(KeyPrefix.COURSE_INFO, ReceiveCoursesKeys.REQUIRED_FREQUENCY_PER_YEAR);
		String creditAmountKey = JSONHelper.createKey(KeyPrefix.COURSE_INFO, ReceiveCoursesKeys.CREDIT_AMOUNT);
		String deletedKey = JSONHelper.createKey(KeyPrefix.COURSE_INFO, ReceiveCoursesKeys.DELETED);
		String departmentKey = JSONHelper.createKey(KeyPrefix.COURSE_INFO, ReceiveCoursesKeys.DEPARTMENT);
		String courseNumberKey = JSONHelper.createKey(KeyPrefix.COURSE_INFO, ReceiveCoursesKeys.COURSE_NUMBER);
		
		Integer id = JSONHelper.getIntValue(json, idKey);
		String courseName = JSONHelper.getStringValue(json, courseNameKey);
		Integer requiredFrequencyPerTerm = JSONHelper.getIntValue(json, requiredFrequencyPerTermKey);
		Integer requiredFrequencyPerSemester = JSONHelper.getIntValue(json, requiredFrequencyPerSemesterKey);
		Integer requiredFrequencyPerYear = JSONHelper.getIntValue(json, requiredFrequencyPerYearKey);
		Integer creditAmount = JSONHelper.getIntValue(json, creditAmountKey);
		Boolean deleted = JSONHelper.getBooleanValue(json, deletedKey);
		String department = JSONHelper.getStringValue(json, departmentKey);
		Integer courseNumber = JSONHelper.getIntValue(json, courseNumberKey);

		CourseInfo courseInfo = new CourseInfo();
		courseInfo.setId(id);
		courseInfo.setCourseName(courseName);
		courseInfo.setRequiredFrequencyPerTerm(requiredFrequencyPerTerm);
		courseInfo.setRequiredFrequencyPerSemester(requiredFrequencyPerSemester);
		courseInfo.setRequiredFrequencyPerYear(requiredFrequencyPerYear);
		courseInfo.setCreditAmount(creditAmount);
		courseInfo.setDeleted(deleted);
		courseInfo.setDepartment(department);
		courseInfo.setCourseNumber(courseNumber);
		
		return courseInfo;
	}
}