package com.application.modul3.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
	@Autowired
	private CarService carService;
	@Autowired
	private CarMapper carMapper;

	@PostMapping("addToUser/{userId}")
	public Car addCarToUser(@PathVariable Integer userId, @RequestBody Car car) {
		CarDB savedCar = carService.addCarToUser(carMapper.car2CarDB(car), userId);
		if (savedCar == null) {
			return null;
		}
		return carMapper.carDB2Car(savedCar);
	}
	
	@GetMapping("removeFromUser/{userId}/{carId}")
	public void removeCarFromUser(@PathVariable Integer userId, @PathVariable Integer carId) {
		carService.removeCarFromUser(userId, carId);
	}
}
