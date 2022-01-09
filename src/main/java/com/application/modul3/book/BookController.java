package com.application.modul3.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private BookMapper bookMapper;

	@PostMapping("/create")
	public Book createBook(@RequestBody Book book) {
		BookDB bookDB = bookMapper.book2BookDB(book);
		BookDB createdBook = bookService.createBook(bookDB);
		return bookMapper.bookDB2Book(createdBook);
	}

	@GetMapping("/book/{bookId}/{userId}")
	public void book(@PathVariable Integer bookId, @PathVariable Integer userId) {
		bookService.book(bookId, userId);
	}
}
