package com.shop.car.util.Impl;

import com.shop.car.Brand;
import com.shop.car.util.BrandDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */

@Repository
@Transactional
public class BrandDAOImpl implements BrandDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBrand(Brand brand) {

        sessionFactory.getCurrentSession().save(brand);
    }

    @Override
    public void updateBrand(Brand brand) {

        sessionFactory.getCurrentSession().update(brand);
    }

    @Override
    public Brand getBrandById(int brandId) {
        return sessionFactory.getCurrentSession().get(Brand.class, brandId);
    }

    @Override
    public List<Brand> getAllBrands() {

        return sessionFactory.getCurrentSession().createCriteria(Brand.class).list();
    }

    @Override
    public void deleteBrand(int brandId) {

        sessionFactory.getCurrentSession().delete(getBrandById(brandId)); ;
    }
}
