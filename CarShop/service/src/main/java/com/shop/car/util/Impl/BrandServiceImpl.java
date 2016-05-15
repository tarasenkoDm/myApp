package com.shop.car.util.Impl;

import com.shop.car.Brand;
import com.shop.car.util.Interfaces.BrandDAO;
import com.shop.car.util.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDAO brandDAO;

    @Transactional
    public void addBrand(Brand brand) {
        brandDAO.add(brand);
    }

    @Transactional
    public void updateBrand(Brand brand) {
        brandDAO.update(brand);
    }

    @Transactional
    public Brand getBrandById(int brandId) {
        return brandDAO.getById(brandId);
    }

    @Transactional
    public List<Brand> getAllBrands() {
        return brandDAO.getAll();
    }

    @Transactional
    public void deleteBrand(int brandId) {
        brandDAO.delete(brandId);
    }
}
