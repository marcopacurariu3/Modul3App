package com.application.modul3.car;

import org.springframework.stereotype.Service;

@Service
public class CarMapper {
	public CarDB car2CarDB(Car car) {
		CarDB carDB = new CarDB();
		carDB.setId(car.getId());
		carDB.setName(car.getName());
		carDB.setYear(car.getYear());

		return carDB;
	}

	public Car carDB2Car(CarDB carDB) {
		Car car = new Car();
		car.setId(carDB.getId());
		car.setName(carDB.getName());
		car.setYear(carDB.getYear());

		return car;
	}
}
