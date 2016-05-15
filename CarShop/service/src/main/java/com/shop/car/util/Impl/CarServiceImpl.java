package com.shop.car.util.Impl;

import com.shop.car.Car;
import com.shop.car.util.Interfaces.CarDAO;
import com.shop.car.util.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CarServiceImpl implements CarService {

    @Autowired
    private CarDAO carDAO;

    @Transactional
    public void addCar(Car car) {
        carDAO.add(car);
    }

    @Transactional
    public void updateCar(Car car) {
        carDAO.update(car);
    }

    @Transactional
    public Car getCarById(int carId) {
        return carDAO.getById(carId);
    }

    @Transactional
    public List<Car> getAllCars() {
        return carDAO.getAll();
    }

    @Transactional
    public void deleteCar(int carId) {
        carDAO.delete(carId);
    }
}
