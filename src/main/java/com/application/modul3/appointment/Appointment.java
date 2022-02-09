package com.application.modul3.appointment;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.user.User;

@Entity(name = "appointment")
@Table(name = "appointment", schema = "administration")
public class Appointment {

	@EmbeddedId
	private AppointmentId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("exemplaryId")
	private Exemplary exemplary;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	private User user;

	@Column(name = "date_from")
	private LocalDateTime dateFrom;

	@Column(name = "date_until")
	private LocalDateTime dateUntil;

	public Appointment(Exemplary exemplary, User user) {
		this.id = new AppointmentId(exemplary.getId(), user.getId());
		this.exemplary = exemplary;
		this.user = user;
	}

	// used for Hibernate
	@SuppressWarnings("unused")
	private Appointment() {

	}

	public AppointmentId getId() {
		return id;
	}

	public void setId(AppointmentId id) {
		this.id = id;
	}

	public Exemplary getExemplary() {
		return exemplary;
	}

	public void setExemplary(Exemplary exemplary) {
		this.exemplary = exemplary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDateTime dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDateTime getDateUntil() {
		return dateUntil;
	}

	public void setDateUntil(LocalDateTime dateUntil) {
		this.dateUntil = dateUntil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exemplary == null) ? 0 : exemplary.hashCode());
		result = prime * result + ((dateFrom == null) ? 0 : dateFrom.hashCode());
		result = prime * result + ((dateUntil == null) ? 0 : dateUntil.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Appointment other = (Appointment) obj;
		if (exemplary == null) {
			if (other.exemplary != null)
				return false;
		} else if (!exemplary.equals(other.exemplary))
			return false;
		if (dateFrom == null) {
			if (other.dateFrom != null)
				return false;
		} else if (!dateFrom.equals(other.dateFrom))
			return false;
		if (dateUntil == null) {
			if (other.dateUntil != null)
				return false;
		} else if (!dateUntil.equals(other.dateUntil))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
