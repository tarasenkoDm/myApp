package com.shop.car.util.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    static {

// get configurations
        Configuration cfg = new Configuration().configure();

// конфигурируем их
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());

// build SessionFactory after that we can create Sessions, activate/deactivate transaction
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
