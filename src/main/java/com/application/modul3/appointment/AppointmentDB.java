package com.application.modul3.appointment;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.application.modul3.book.BookDB;
import com.application.modul3.user.UserDB;

@Entity(name = "appointment")
@Table(name = "appointment", schema = "administration")
public class AppointmentDB {

	@EmbeddedId
	private AppointmentId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("bookId")
	private BookDB book;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	private UserDB user;

	@Column(name = "date_from")
	private LocalDateTime dateFrom;

	@Column(name = "date_until")
	private LocalDateTime dateUntil;

	public AppointmentDB(BookDB bookDB, UserDB userDB) {
		this.id = new AppointmentId(bookDB.getId(), userDB.getId());
		this.book = bookDB;
		this.user = userDB;
	}

	// used for Hibernate
	@SuppressWarnings("unused")
	private AppointmentDB() {

	}

	public BookDB getBook() {
		return book;
	}

	public void setBook(BookDB book) {
		this.book = book;
	}

	public UserDB getUser() {
		return user;
	}

	public void setUser(UserDB user) {
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
		result = prime * result + ((book == null) ? 0 : book.hashCode());
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
		AppointmentDB other = (AppointmentDB) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
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
