package com.application.modul3.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.user.UserDB;
import com.application.modul3.user.UserService;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private UserService userService;

	public List<AppointmentDB> getAllAppointmentsForUser(Integer userId) {
		UserDB user = userService.getUserById(userId).get();
		return appointmentRepository.findByUser(user);
	}
}
