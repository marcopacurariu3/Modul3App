package com.application.modul3.appointment;

import java.time.LocalDateTime;

public class Appointment {
	private LocalDateTime dateFrom;
	private LocalDateTime dateUntil;

	
	public LocalDateTime getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDateTime dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDateTime getDateUntil() {
		return dateUntil;
	}

	public void setDateUntil(LocalDateTime dateUntil) {
		this.dateUntil = dateUntil;
	}

}
