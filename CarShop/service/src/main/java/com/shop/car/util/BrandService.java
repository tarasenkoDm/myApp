package com.shop.car.util;

import com.shop.car.Brand;

import java.util.List;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */
public interface BrandService {

    public void addBrand(Brand brand);

    public void updateBrand(Brand brand);

    public Brand getBrandById(int brandId);

    public List<Brand> getAllBrands();

    public void deleteBrand(int brandId);
}
