package com.shop.car.util.controllers;

import com.shop.car.Brand;

import com.shop.car.util.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/allBrands.html", method = RequestMethod.GET)
    @ResponseBody
    public List<Brand> getAllBrands() throws SQLException {
        return getBrands();
    }

    @RequestMapping(value = "/deleteBrand", method = RequestMethod.DELETE)
    @ResponseBody
    public List<Brand> deleteBrand(@RequestParam("brandId") int brandId) throws SQLException {
        brandService.deleteBrand(brandId);
        return getBrands();
    }

    private List<Brand> getBrands() {
        List<Brand> brandList = brandService.getAllBrands();
        return brandList;
    }
}
