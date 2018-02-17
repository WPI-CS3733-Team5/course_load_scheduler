package org.dselent.course_load_scheduler.client.model;

// created by David M.

public class CourseInfo {
	private Integer id;
	private String courseName;
	private Integer requiredFrequencyPerTerm;
	private Integer requiredFrequencyPerSemester;
	private Integer requiredFrequencyPerYear;
	private Integer creditAmount;
	private Boolean deleted;
	private String department;
	private Integer courseNumber;
	
	//constructor
	public CourseInfo(){}
	
	//getters & setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Integer getRequiredFrequencyPerTerm() {
		return requiredFrequencyPerTerm;
	}
	public void setRequiredFrequencyPerTerm(Integer frequency) {
		this.requiredFrequencyPerTerm = frequency;
	}
	
	public Integer getRequiredFrequencyPerSemester() {
		return requiredFrequencyPerSemester;
	}
	public void setRequiredFrequencyPerSemester(Integer frequency) {
		this.requiredFrequencyPerSemester = frequency;
	}
	
	public Integer getRequiredFrequencyPerYear() {
		return requiredFrequencyPerYear;
	}
	public void setRequiredFrequencyPerYear(Integer frequency) {
		this.requiredFrequencyPerYear = frequency;
	}
	
	public Integer getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(Integer creditAmount) {
		this.creditAmount = creditAmount;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Integer getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	//utility methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((requiredFrequencyPerTerm == null) ? 0 : requiredFrequencyPerTerm.hashCode());
		result = prime * result + ((requiredFrequencyPerSemester == null) ? 0 : requiredFrequencyPerSemester.hashCode());
		result = prime * result + ((requiredFrequencyPerYear == null) ? 0 : requiredFrequencyPerYear.hashCode());
		result = prime * result + ((creditAmount == null) ? 0 : creditAmount.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((courseNumber == null) ? 0 : courseNumber.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseInfo other = (CourseInfo) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (requiredFrequencyPerTerm == null) {
			if (other.requiredFrequencyPerTerm != null)
				return false;
		} else if (!requiredFrequencyPerTerm.equals(other.requiredFrequencyPerTerm))
			return false;
		if (requiredFrequencyPerSemester == null) {
			if (other.requiredFrequencyPerSemester != null)
				return false;
		} else if (!requiredFrequencyPerSemester.equals(other.requiredFrequencyPerSemester))
			return false;
		if (requiredFrequencyPerYear == null) {
			if (other.requiredFrequencyPerYear != null)
				return false;
		} else if (!requiredFrequencyPerYear.equals(other.requiredFrequencyPerYear))
			return false;
		if (creditAmount == null) {
			if (other.creditAmount != null)
				return false;
		} else if (!creditAmount.equals(other.creditAmount))
			return false;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (courseNumber == null) {
			if (other.courseNumber != null)
				return false;
		} else if (!courseNumber.equals(other.courseNumber))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Section [id=" + id + ", courseName=" + courseName + ", requiredFrequencyPerTerm=" + requiredFrequencyPerTerm 
				+ ", requiredFrequencyPerSemester=" + requiredFrequencyPerSemester 
				+ ", requiredFrequencyPerYear=" + requiredFrequencyPerYear + ", creditAmount=" + creditAmount
				+ ", deleted=" + deleted + ", department=" + department + ", courseNumber =" + courseNumber + "]";
	}
}
