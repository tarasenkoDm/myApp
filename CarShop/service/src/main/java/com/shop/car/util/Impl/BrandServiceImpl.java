package com.shop.car.util.Impl;

import com.shop.car.Brand;
import com.shop.car.util.BrandDAO;
import com.shop.car.util.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDAO brandDAO;

    @Transactional
    public void addBrand(Brand brand) {
        brandDAO.addBrand(brand);
    }

    @Transactional
    public void updateBrand(Brand brand) {
        brandDAO.updateBrand(brand);

    }

    @Transactional
    public Brand getBrandById(int brandId) {
        return brandDAO.getBrandById(brandId);
    }

    @Transactional
    public List<Brand> getAllBrands() {
        return brandDAO.getAllBrands();
    }

    @Transactional
    public void deleteBrand(int brandId) {
        brandDAO.deleteBrand(brandId);

    }
}
