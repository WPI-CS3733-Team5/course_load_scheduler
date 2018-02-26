package org.dselent.course_load_scheduler.client.model;

public class Notifications extends Model{

	private Integer id;
	private String message;
	private Integer fromUserInfoId;
	private Integer toUserInfoId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getFromUserInfoId() {
		return fromUserInfoId;
	}
	public void setFromUserInfoId(Integer fromUserInfoId) {
		this.fromUserInfoId = fromUserInfoId;
	}
	public Integer getToUserInfoId() {
		return toUserInfoId;
	}
	public void setToUserInfoId(Integer toUserInfoId) {
		this.toUserInfoId = toUserInfoId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromUserInfoId == null) ? 0 : fromUserInfoId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((toUserInfoId == null) ? 0 : toUserInfoId.hashCode());
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
		Notifications other = (Notifications) obj;
		if (fromUserInfoId == null) {
			if (other.fromUserInfoId != null)
				return false;
		} else if (!fromUserInfoId.equals(other.fromUserInfoId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (toUserInfoId == null) {
			if (other.toUserInfoId != null)
				return false;
		} else if (!toUserInfoId.equals(other.toUserInfoId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Notifications [id=" + id + ", message=" + message + ", fromUserInfoId=" + fromUserInfoId
				+ ", toUserInfoId=" + toUserInfoId + "]";
	}
	
	
}
