package com.application.modul3.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.appointment.Appointment;
import com.application.modul3.appointment.AppointmentDB;
import com.application.modul3.appointment.AppointmentMapper;
import com.application.modul3.appointment.AppointmentService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		UserDB userDB = userMapper.user2UserDB(user);
		UserDB savedUser = userService.createUser(userDB);
		return userMapper.userDB2User(savedUser);
	}

	@GetMapping("/list")
	public List<UserDB> listUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/get/{id}")
	public Optional<UserDB> getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user) {
		UserDB userDB = userMapper.user2UserDB(user);
		userDB.setId(id);
		UserDB updatedUser = userService.updateUser(userDB);
		return userMapper.userDB2User(updatedUser);
	}

	@GetMapping("/delete/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

	@GetMapping("/hello")
	public String isServerUp() {
		return "Sunt serverul, domnule client. :)";
	}

	@GetMapping("/appointments/{userId}")
	public List<Appointment> getAppointmentsForUser(@PathVariable Integer userId) {
		List<AppointmentDB> appointmentDBs = appointmentService.getAllAppointmentsForUser(userId);
		return appointmentMapper.appointmentDBList2AppointmentList(appointmentDBs);
	}
}
