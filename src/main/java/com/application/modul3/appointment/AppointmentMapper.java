package com.application.modul3.appointment;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class AppointmentMapper {

	public Appointment appointmentDB2Appointment(AppointmentDB appointmentDB) {
		Appointment appointment = new Appointment();
		appointment.setDateFrom(appointmentDB.getDateFrom());
		appointment.setDateUntil(appointmentDB.getDateUntil());
		return appointment;
	}
	
	public List<Appointment> appointmentDBList2AppointmentList(List<AppointmentDB> appointmentDBList){
		return appointmentDBList.stream().map(app -> appointmentDB2Appointment(app)).collect(Collectors.toList());
	}
}
