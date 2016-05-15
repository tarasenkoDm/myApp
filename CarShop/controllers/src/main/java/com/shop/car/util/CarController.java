package com.shop.car.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shop.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/allCars.html", method = RequestMethod.GET)
    public ModelAndView listCars() throws SQLException {
        List<Car> carsList = carService.getAllCars();
        return new ModelAndView("list-of-cars", "carListJSP", carsList);
    }

//    @RequestMapping(value = "/allCars.html", method = RequestMethod.GET)
//    public Model listCars2() throws SQLException {
//        List<Car> carList = carService.getAllCars();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String allCars = gson.toJson(carList);
//        Model dd;
//        dd.addAllAttributes("ded", carList);
//        return dd;
//    }

    @RequestMapping(value = "/deleteCar.html", method = RequestMethod.DELETE)
    public ModelAndView deleteCar(@RequestParam("carId") int carId) throws SQLException {
        carService.deleteCar(carId);
        return new ModelAndView(new RedirectView("allCars.html"));
    }
}