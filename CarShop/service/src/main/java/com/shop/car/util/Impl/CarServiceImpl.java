package com.shop.car.util.Impl;

import com.shop.car.Car;
import com.shop.car.util.CarDAO;
import com.shop.car.util.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDAO carDAO;

    @Transactional
    public void addCar(Car car) {
        carDAO.addCar(car);
    }

    @Transactional
    public void updateCar(Car car) {
        carDAO.updateCar(car);
    }

    @Transactional
    public Car getCarById(long carId) {
        return carDAO.getCarById(carId);
    }

    @Transactional
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Transactional
    public void deleteCar(long carId) {
        carDAO.deleteCar(carId);
    }
}
