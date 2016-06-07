package com.shop.car.util.Impl;

import com.shop.car.Car;
import com.shop.car.util.Interfaces.CarDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CarDAOImpl implements CarDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public void update(Car car) {
        sessionFactory.getCurrentSession().update(car);
    }

    @Override
    public Car getById(int carId) {
        return sessionFactory.getCurrentSession().get(Car.class, carId);
    }

    @Override
    public List<Car> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Car.class).list();
    }

    @Override
    public void delete(int carId) {
        sessionFactory.getCurrentSession().delete(getById(carId));
    }
}
