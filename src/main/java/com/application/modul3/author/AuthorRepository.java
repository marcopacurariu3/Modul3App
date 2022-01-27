package com.application.modul3.author;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	public Author findByNameContaining(String name);

	public List<Author> findByDeathDateIsNull();
}