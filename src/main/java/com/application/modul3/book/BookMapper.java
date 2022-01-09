package com.application.modul3.book;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {

	public Book bookDB2Book(BookDB bookDB) {
		Book book = new Book();

		book.setId(bookDB.getId());
		book.setName(bookDB.getName());

		return book;
	}

	public BookDB book2BookDB(Book book) {
		BookDB bookDB = new BookDB();

		bookDB.setName(book.getName());

		return bookDB;
	}
}
