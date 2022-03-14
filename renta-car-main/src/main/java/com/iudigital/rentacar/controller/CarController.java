package com.iudigital.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.rentacar.domain.Car;
import com.iudigital.rentacar.service.CarService;

@RestController
@RequestMapping("/car")
@CrossOrigin("*")
public class CarController {

	@Autowired
	private CarService carService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createCar(@RequestBody Car car) {
		carService.createCar(car);
	}
	
	@GetMapping
	public List<Car> getCars() {
		return carService.getCars();
	}
	
	@GetMapping("/{Id}")
	public Car getCar(@PathVariable int Id) {
		return carService.getCarById(Id);
	}
	
	@PutMapping("/{Id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  editCar(@PathVariable int Id, @RequestBody Car car) {
		 carService.editCar(Id, car );
	}
	
	@DeleteMapping("/{Id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCar(@PathVariable int Id) {
		 carService.deleteCar(Id);
	}
	
	
	
	
}
