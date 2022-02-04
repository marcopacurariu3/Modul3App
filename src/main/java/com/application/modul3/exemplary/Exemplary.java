package com.application.modul3.exemplary;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
}
