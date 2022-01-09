package com.application.modul3.book;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.appointment.AppointmentDB;
import com.application.modul3.appointment.AppointmentRepository;
import com.application.modul3.user.UserDB;
import com.application.modul3.user.UserRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;

	public BookDB createBook(BookDB bookToCreate) {
		return bookRepository.saveAndFlush(bookToCreate);
	}

	public void book(Integer bookId, Integer userId) {
		BookDB bookDB = bookRepository.getById(bookId);
		UserDB userDB = userRepository.getById(userId);

		AppointmentDB appointment = new AppointmentDB(bookDB, userDB);
		appointment.setDateFrom(LocalDateTime.now());
		appointment.setDateUntil(LocalDateTime.now());
		userDB.addAppointment(appointment);
		bookDB.addAppointment(appointment);

		appointmentRepository.flush();
	}
	
}
