package com.application.modul3.appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.appointment.dto.AppointmentInfoDTO;
import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.ExemplaryRepository;
import com.application.modul3.user.User;
import com.application.modul3.user.UserService;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private UserService userService;

	public Set<Appointment> getAllAppointmentsForUser(Integer userId) {
		return appointmentRepository.findByUser(userId);
	}

	public List<Exemplary> getExemplariesForUserAndPeriod(AppointmentInfoDTO appointmentInfoDTO) {
		return exemplaryRepository.getExemplariesForUserAndPeriod(appointmentInfoDTO.getDateFrom(),
				appointmentInfoDTO.getDateUntil(), appointmentInfoDTO.getBookId(), appointmentInfoDTO.getUserId());
	}

	public void book(Integer exemplaryId, Integer userId) {
		Exemplary exemplary = exemplaryRepository.getById(exemplaryId);
		User user = userService.getUserById(userId);

//		if(user == null || exemplary == null) {
//			//exception
//		}

		Appointment appointment = new Appointment();
		appointment.setDateFrom(LocalDateTime.now());
		appointment.setDateUntil(LocalDateTime.now());
		exemplary.addAppointment(appointment);
		user.addAppointment(appointment);

		appointmentRepository.flush();
	}

}
