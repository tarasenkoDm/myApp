package com.shop.car.util.controllers;

import com.shop.car.Car;
import com.shop.car.util.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class CarController {

//    @Autowired
    private CarService carService;

    @RequestMapping(value = "/allCars.html", method = RequestMethod.GET)
    @ResponseBody
    public List<Car> getAllCars() throws SQLException {
        return getCars();
    }

    @RequestMapping(value = "/deleteCar.html", method = RequestMethod.DELETE)
    @ResponseBody
    public List<Car> deleteCar(@RequestParam("carId") int carId) throws SQLException {
        carService.deleteCar(carId);
        return getCars();
    }

    private List<Car> getCars() {
        List<Car> carList = new LinkedList<>();
        carList = carService.getAllCars();
        System.out.println(carList);
        return carList;
    }
}
