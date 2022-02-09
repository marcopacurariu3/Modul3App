package com.application.modul3.exemplary;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {
	//@Query(value = "SELECT exemplary FROM exemplary exemplary inner join exemplary.book book WHERE book.id = ?1")
	List<Exemplary> findByBookId(Integer bookId);
	
	@Query(value = "SELECT DISTINCT exemplary FROM exemplary exemplary inner join exemplary.book book left join exemplary.appointments appointment WHERE (((appointment.dateFrom NOT BETWEEN ?1 AND ?2) AND (appointment.dateUntil NOT BETWEEN ?1 AND ?2)) OR appointment.id IS NULL) AND (book.id = ?3)")
	List<Exemplary> getExemplariesForUserAndPeriod(LocalDateTime startDate, LocalDateTime endDate, Integer bookId, Integer userId);
}
