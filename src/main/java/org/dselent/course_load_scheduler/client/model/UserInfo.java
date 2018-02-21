package org.dselent.course_load_scheduler.client.model;

import java.util.Date;
import java.sql.Timestamp;
import java.time.Instant;

public class UserInfo extends Model
{	
	//A lot of stuff is commented out. This is to make it easier to require it if we need it later. 
	
	// attributes
	
	private Integer id;
	private Integer userRole;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private Integer accountState;
	private Date createdAt;
	private Date updatedAt;
	private Date loginTime;
	// methods
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAccountState() {
		return accountState;
	}
	public void setAccountState(Integer accountState) {
		this.accountState = accountState;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountState == null) ? 0 : accountState.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((loginTime == null) ? 0 : loginTime.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (accountState == null) {
			if (other.accountState != null)
				return false;
		} else if (!accountState.equals(other.accountState))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (loginTime == null) {
			if (other.loginTime != null)
				return false;
		} else if (!loginTime.equals(other.loginTime))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userRole=" + userRole + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", accountState=" + accountState + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", loginTime=" + loginTime + "]";
	}
	
	
	
}
