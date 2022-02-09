package com.application.modul3.exemplary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.application.modul3.appointment.Appointment;
import com.application.modul3.book.Book;
import com.application.modul3.publisher.Publisher;

@Entity(name = "exemplary")
@Table(name = "exemplary", schema = "administration")
public class Exemplary {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "code")
	private String code;

	@Column(name = "page_numbers")
	private Integer pageNumbers;

	@ManyToOne()
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne()
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	@OneToMany(mappedBy = "exemplary", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, orphanRemoval = true)
	private List<Appointment> appointments = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(Integer pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((appointments == null) ? 0 : appointments.hashCode());
//		result = prime * result + ((book == null) ? 0 : book.hashCode());
//		result = prime * result + ((code == null) ? 0 : code.hashCode());
//		result = prime * result + ((date == null) ? 0 : date.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((pageNumbers == null) ? 0 : pageNumbers.hashCode());
//		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Exemplary other = (Exemplary) obj;
//		if (appointments == null) {
//			if (other.appointments != null)
//				return false;
//		} else if (!appointments.equals(other.appointments))
//			return false;
//		if (book == null) {
//			if (other.book != null)
//				return false;
//		} else if (!book.equals(other.book))
//			return false;
//		if (code == null) {
//			if (other.code != null)
//				return false;
//		} else if (!code.equals(other.code))
//			return false;
//		if (date == null) {
//			if (other.date != null)
//				return false;
//		} else if (!date.equals(other.date))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (pageNumbers == null) {
//			if (other.pageNumbers != null)
//				return false;
//		} else if (!pageNumbers.equals(other.pageNumbers))
//			return false;
//		if (publisher == null) {
//			if (other.publisher != null)
//				return false;
//		} else if (!publisher.equals(other.publisher))
//			return false;
//		return true;
//	}
	
	
}
