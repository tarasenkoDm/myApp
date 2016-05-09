package com.shop.car.util;

import com.shop.car.Brand;
import com.sun.javafx.sg.prism.NGShape;
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
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/allBrands.html", method = RequestMethod.GET)
    public ModelAndView listBrands() {
        List<Brand> brands = brandService.getAllBrands();
        return new ModelAndView("list-of-brands", "brandListJSP", listBrands());
    }

    @RequestMapping(value = "/deleteBrand", method = RequestMethod.DELETE)
    public ModelAndView deleteBrand(@RequestParam("brandId") int brandId)throws SQLException{
        brandService.deleteBrand(brandId);
        return new ModelAndView(new RedirectView("allBrands.html"));
    }
}
