package com.shop.car.util.Interfaces;

import java.util.List;

public interface BaseDAO<T> {

    void add(T o);

    void update(T o);

    T getById(int id);

    List<T> getAll();

    void delete(int id);
}
