package com.application.modul3.appointment;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.user.User;

@Entity(name = "appointment")
@Table(name = "appointment", schema = "administration")
public class Appointment {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exemplary_id")
	private Exemplary exemplary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "date_from")
	private LocalDateTime dateFrom;

	@Column(name = "date_until")
	private LocalDateTime dateUntil;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
}
