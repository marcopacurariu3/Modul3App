package com.application.modul3.appointment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.appointment.dto.AppointmentDTO;
import com.application.modul3.appointment.dto.AppointmentInfoDTO;
import com.application.modul3.appointment.mapper.AppointmentMapper;
import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.dto.ExemplaryDTO;
import com.application.modul3.exemplary.mapper.ExemplaryMapper;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;
	@Autowired
	private ExemplaryMapper exemplaryMapper;

	@GetMapping("/list/{userId}")
	public List<AppointmentDTO> getAppointmentsForUser(@PathVariable Integer userId) {
		List<Appointment> appointmentDBs = new ArrayList<>(appointmentService.getAllAppointmentsForUser(userId));
		return appointmentMapper.appointmentDBList2AppointmentList(appointmentDBs);
	}

	@PostMapping("/find")
	public List<ExemplaryDTO> getExemplariesForUserAndPeriod(@RequestBody AppointmentInfoDTO appointmentInfoDTO) {
		List<Exemplary> exemplaries = appointmentService.getExemplariesForUserAndPeriod(appointmentInfoDTO);
		return exemplaryMapper.exemplaryList2ExemplaryDTOList(exemplaries);
	}

	@GetMapping("/book/{exemplaryId}/{userId}")
	public void book(@PathVariable Integer exemplaryId, @PathVariable Integer userId) {
		appointmentService.book(exemplaryId, userId);
	}
}
