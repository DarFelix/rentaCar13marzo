package com.iudigital.rentacar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.rentacar.data.CarRepository;
import com.iudigital.rentacar.domain.Car;
import com.iudigital.rentacar.domain.User;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public void createCar(Car car) {
		carRepository.save(car);
	}
	
	public List<Car> getCars() {
		List<Car> cars = (List<Car>) carRepository.findAll();
		return cars;
	}
	
	public Car getCarById(int id) {

		Car car = carRepository.findById(id).orElse(new Car());
		return car;

	}
	
	public void editCar(int id, Car car) {

		Car carUpdate = carRepository.findById(id).orElse(null);
		if (carUpdate != null) {
			carUpdate.setLicencePlate(car.getLicencePlate());
			carUpdate.setBrand(car.getBrand());
			carUpdate.setColor(car.getColor());
			carUpdate.setFuelType(car.getFuelType());
			carUpdate.setKilometres(car.getKilometres());
			carUpdate.setModel(car.getModel());
			carUpdate.setMotor(car.getMotor());
			carUpdate.setNumberDoors(car.getNumberDoors());
			carUpdate.setPhoto(car.getPhoto());
			carUpdate.setTransmission(car.getTransmission());
			carUpdate.setYear(car.getYear());
			
			carRepository.save(carUpdate);
		}

	}
	
	public void deleteCar(int id) {
			
			carRepository.deleteById(id);
		
	}
	 
}
