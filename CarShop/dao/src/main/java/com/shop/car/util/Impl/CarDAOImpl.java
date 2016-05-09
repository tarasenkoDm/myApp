package com.shop.car.util.Impl;

import com.shop.car.Car;
import com.shop.car.util.CarDAO;
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
public class CarDAOImpl implements CarDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public void updateCar(Car car) {
        sessionFactory.getCurrentSession().update(car);

    }

    @Override
    public Car getCarById(long carId) {
        return sessionFactory.getCurrentSession().get(Car.class, carId);
    }

    @Override
    public List<Car> getAllCars() {
        return sessionFactory.getCurrentSession().createCriteria(Car.class).list();
    }

    @Override
    public void deleteCar(long carId) {
        sessionFactory.getCurrentSession().delete(getCarById(carId));
    }
}
