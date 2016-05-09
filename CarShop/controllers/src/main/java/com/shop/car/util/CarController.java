package com.shop.car.util;

import com.shop.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/allCars.html", method = RequestMethod.GET)
    public ModelAndView listCars() throws SQLException{
        List<Car> carsList = carService.getAllCars();
        return new ModelAndView("list-of-cars", "carListJSP", carsList);
    }


    @RequestMapping(value = "/deleteCar.html", method = RequestMethod.DELETE)
    public ModelAndView deleteCar(@RequestParam("carId") long carId)throws SQLException{
        carService.deleteCar(carId);
        return  new ModelAndView(new RedirectView("allCars.html"));
    }
}
