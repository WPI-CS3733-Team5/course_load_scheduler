package org.dselent.course_load_scheduler.client.model;

public class LabInfo extends Model{
	private Integer id;
	private Integer sectionInfoId;
	private Integer instructorInfoId;
	private String location;
	private Integer calendarInfoId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSectionInfoId() {
		return sectionInfoId;
	}
	public void setSectionInfoId(Integer sectionInfoId) {
		this.sectionInfoId = sectionInfoId;
	}
	public Integer getInstructorInfoId() {
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
	public Integer getCalendarInfoId() {
		return calendarInfoId;
	}
	public void setCalendarInfoId(Integer calendarInfoId) {
		this.calendarInfoId = calendarInfoId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calendarInfoId == null) ? 0 : calendarInfoId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instructorInfoId == null) ? 0 : instructorInfoId.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((sectionInfoId == null) ? 0 : sectionInfoId.hashCode());
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
		LabInfo other = (LabInfo) obj;
		if (calendarInfoId == null) {
			if (other.calendarInfoId != null)
				return false;
		} else if (!calendarInfoId.equals(other.calendarInfoId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (sectionInfoId == null) {
			if (other.sectionInfoId != null)
				return false;
		} else if (!sectionInfoId.equals(other.sectionInfoId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LabInfo [id=" + id + ", sectionInfoId=" + sectionInfoId + ", instructorInfoId=" + instructorInfoId
				+ ", location=" + location + ", calendarInfoId=" + calendarInfoId + "]";
	}
	
	
}
