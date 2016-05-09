package com.shop.car.util;

import com.shop.car.Car;

import java.util.List;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */
public interface CarService {

    public void addCar(Car car);

    public void updateCar(Car car);

    public Car getCarById(long carId);

    public List<Car> getAllCars();

    public void deleteCar(long carId);
}
