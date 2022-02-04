package com.application.modul3.exemplary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {
	//@Query(value = "SELECT exemplary FROM exemplary exemplary inner join exemplary.book book WHERE book.id = ?1")
	List<Exemplary> findByBookId(Integer bookId);
}
