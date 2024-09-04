package com.test.web.service;

import java.util.List;

import com.test.web.repository.CarRepository;
import com.test.web.vo.CarVO;

public class CarService {
	private CarRepository cr = new CarRepository();
	
	public int insertCar(CarVO car) {
		return cr.insertCar(car);
	}
	
	public int updateCar(CarVO car) {
		return cr.updateCar(car);
	}
	
	public int deleteCar(int ciNum) {
		return cr.deleteCar(ciNum);
	}
	
	public List<CarVO> selectCars(){
		return cr.selectCars();
	}
	
	public CarVO selectCar(int ciNum) {
		return cr.selectCar(ciNum);
	}
	
}
