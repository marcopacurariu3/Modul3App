package com.application.modul3.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.modul3.book.BookDB;

public interface BookRepository extends JpaRepository<BookDB, Integer> {

}
