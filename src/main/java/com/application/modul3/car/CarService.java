package com.application.modul3.car;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.user.UserDB;
import com.application.modul3.user.UserRepository;
import com.application.modul3.user.UserService;

@Service
public class CarService {

	@Autowired
	private UserService userService;
	@Autowired
	private CarRepository carRepository;
	@Autowired 
	private UserRepository userRepository;

	public CarDB addCarToUser(CarDB car, Integer userId) {
		Optional<UserDB> userDBOptional = userService.getUserById(userId);
		if (userDBOptional.isPresent()) {
			UserDB user = userDBOptional.get();
			user.addCar(car);
			return carRepository.saveAndFlush(car);
		}
		return null;
	}
	
	public void removeCarFromUser(Integer userId, Integer carId) {
		Optional<UserDB> userDBOptional = userService.getUserById(userId);
		Optional<CarDB> carDBOptional = carRepository.findById(carId);
		if(userDBOptional.isPresent() && carDBOptional.isPresent()) {
			UserDB user = userDBOptional.get();
			CarDB car = carDBOptional.get();
			user.removeCar(car);
			userRepository.saveAndFlush(user);
		}
	}
}
