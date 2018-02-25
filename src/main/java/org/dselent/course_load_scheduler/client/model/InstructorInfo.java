package org.dselent.course_load_scheduler.client.model;

import java.sql.Timestamp;
import java.time.Instant;


public class InstructorInfo extends Model
{	
	// attributes
	
	private Integer id;
	private Integer rank;
	private Integer courseLoad;
	private String office;
	private Integer userInfoId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getCourseLoad() {
		return courseLoad;
	}
	public void setCourseLoad(Integer courseLoad) {
		this.courseLoad = courseLoad;
	}
	
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Integer getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(Integer userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	private String department;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseLoad == null) ? 0 : courseLoad.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((office == null) ? 0 : office.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((userInfoId == null) ? 0 : userInfoId.hashCode());
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
		InstructorInfo other = (InstructorInfo) obj;
		if (courseLoad == null) {
			if (other.courseLoad != null)
				return false;
		} else if (!courseLoad.equals(other.courseLoad))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (userInfoId == null) {
			if (other.userInfoId != null)
				return false;
		} else if (!userInfoId.equals(other.userInfoId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "InstructorInfo [id=" + id + ", rank=" + rank + ", courseLoad=" + courseLoad + ", office=" + office + ", userInfoId=" + userInfoId + ", department=" + department
				+ "]";
	}
	
	
	
}