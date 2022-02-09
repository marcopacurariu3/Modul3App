package com.application.modul3.appointment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AppointmentId implements Serializable {

	private static final long serialVersionUID = -954491387826183146L;

	@Column(name = "exemplary_id")
	private Integer exemplaryId;

	@Column(name = "user_id")
	private Integer userId;

	@SuppressWarnings("unused")
	private AppointmentId() {

	}

	public AppointmentId(Integer exemplaryId, Integer userId) {
		this.exemplaryId = exemplaryId;
		this.userId = userId;
	}

	public Integer getExemplaryId() {
		return exemplaryId;
	}

	public void setExemplaryId(Integer exemplaryId) {
		this.exemplaryId = exemplaryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exemplaryId == null) ? 0 : exemplaryId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		AppointmentId other = (AppointmentId) obj;
		if (exemplaryId == null) {
			if (other.exemplaryId != null)
				return false;
		} else if (!exemplaryId.equals(other.exemplaryId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppointmentId [exemplaryId=" + exemplaryId + ", userId=" + userId + "]";
	}

}
