package org.dselent.course_load_scheduler.client.model;

public class SectionInfo {
	private Integer id;
	private Integer sectionNumber;
	private String sectionType;
	private Integer instructorInfoId;
	private String location;
	private Boolean deleted;
	private Integer courseInfoId;
	private Integer calendarInfoId;
	
	//constructor
	public SectionInfo() {}
	
	//getters & setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.calendarInfoId = id;
	}
	
	public Integer getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(Integer sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public String getSectionType() {
		return sectionType;
	}
	public void setSectionType(String sectionType) {
		this.sectionType = sectionType;
	}
	
	public Integer instructorInfoId() {
		return instructorInfoId;
	}
	public void setInstructorInfoId(Integer instructorInfoId) {
		this.instructorInfoId = instructorInfoId;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public Integer getCourseInfoId() {
		return courseInfoId;
	}
	public void setCourseInfoId(Integer courseInfoId) {
		this.courseInfoId = courseInfoId;
	}
	
	public Integer getCalendarInfoId() {
		return calendarInfoId;
	}
	public void setCalendarInfoId(Integer calendarInfoId) {
		this.calendarInfoId = calendarInfoId;
	}

	//utility methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionNumber == null) ? 0 : sectionNumber.hashCode());
		result = prime * result + ((sectionType == null) ? 0 : sectionType.hashCode());
		result = prime * result + ((instructorInfoId == null) ? 0 : instructorInfoId.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((courseInfoId == null) ? 0 : courseInfoId.hashCode());
		result = prime * result + ((calendarInfoId == null) ? 0 : calendarInfoId.hashCode());
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
		SectionInfo other = (SectionInfo) obj;
		if (sectionNumber == null) {
			if (other.sectionNumber != null)
				return false;
		} else if (!sectionNumber.equals(other.sectionNumber))
			return false;
		if (sectionType == null) {
			if (other.sectionType != null)
				return false;
		} else if (!sectionType.equals(other.sectionType))
			return false;
		if (instructorInfoId == null) {
			if (other.instructorInfoId != null)
				return false;
		} else if (!instructorInfoId.equals(other.instructorInfoId))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (courseInfoId == null) {
			if (other.courseInfoId != null)
				return false;
		} else if (!courseInfoId.equals(other.courseInfoId))
			return false;
		if (calendarInfoId == null) {
			if (other.calendarInfoId != null)
				return false;
		} else if (!calendarInfoId.equals(other.calendarInfoId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Section [id=" + id + ", sectionNumber=" + sectionNumber + ", sectionType=" + sectionType 
				+ ", instructorInfoId=" + instructorInfoId + ", location=" + location + ", deleted=" + deleted
				+ ", courseInfoId=" + courseInfoId + ", calendarInfoId=" + calendarInfoId + "]";
	}
}
