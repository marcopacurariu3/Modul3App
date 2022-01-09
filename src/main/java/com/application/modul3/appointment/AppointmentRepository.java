package com.application.modul3.appointment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.modul3.user.UserDB;

public interface AppointmentRepository extends JpaRepository<AppointmentDB, Integer> {

	List<AppointmentDB> findByUser(UserDB user);
}
