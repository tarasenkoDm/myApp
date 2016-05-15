package com.shop.car.util.Impl;

import com.shop.car.Brand;
import com.shop.car.util.Interfaces.BrandDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BrandDAOImpl implements BrandDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Brand brand) {

        sessionFactory.getCurrentSession().save(brand);
    }

    @Override
    public void update(Brand brand) {

        sessionFactory.getCurrentSession().update(brand);
    }

    @Override
    public Brand getById(int brandId) {
        return sessionFactory.getCurrentSession().get(Brand.class, brandId);
    }

    @Override
    public List<Brand> getAll() {

        return sessionFactory.getCurrentSession().createCriteria(Brand.class).list();
    }

    @Override
    public void delete(int brandId) {

        sessionFactory.getCurrentSession().delete(getById(brandId));
    }
}
