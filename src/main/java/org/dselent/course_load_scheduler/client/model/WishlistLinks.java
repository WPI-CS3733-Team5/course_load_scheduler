package org.dselent.course_load_scheduler.client.model;

public class WishlistLinks extends Model{

	private Integer id;
	private Integer instructorInfoId;
	private Integer sectionInfoId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInstructorInfoId() {
		return instructorInfoId;
	}
	public void setInstructorInfoId(Integer instructorInfoId) {
		this.instructorInfoId = instructorInfoId;
	}
	public Integer getSectionInfoId() {
		return sectionInfoId;
	}
	public void setSectionInfoId(Integer sectionInfoId) {
		this.sectionInfoId = sectionInfoId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instructorInfoId == null) ? 0 : instructorInfoId.hashCode());
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
		WishlistLinks other = (WishlistLinks) obj;
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
		if (sectionInfoId == null) {
			if (other.sectionInfoId != null)
				return false;
		} else if (!sectionInfoId.equals(other.sectionInfoId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WishlistLinks [id=" + id + ", instructorInfoId=" + instructorInfoId + ", sectionInfoId=" + sectionInfoId
				+ "]";
	}
	
	
	
}
