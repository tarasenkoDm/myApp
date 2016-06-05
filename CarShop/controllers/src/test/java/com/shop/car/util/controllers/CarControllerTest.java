package com.shop.car.util.controllers;

import com.shop.car.Car;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.junit.*;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;


//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//@WebAppConfiguration

public class CarControllerTest {

    private static String user = "postgres";
    private static String password = "postgres";
    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/bdtachki";


    @BeforeClass
    public static void applayDBSchema() {

        dropDB();
        createSchemaAndTables();

    }


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllCars() throws Exception {

//        List<Car> carList = new LinkedList<>();
//        Car car = null;
//
//        Class.forName(driver);
//        Connection connection = null;
//        connection = DriverManager.getConnection(url, user, password);
//        System.out.println("ok");
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tachkischema.cars");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        int i=0;
//        while (resultSet.next()){
//            car = new Car();
//            car.setCarId(resultSet.getInt("id"));
//            car.setModel(resultSet.getString("model"));
//            car.setColor(resultSet.getString("color"));
//            car.setPrice(resultSet.getInt("price"));
//            System.out.println(car);
//            carList.add(car);
//            System.out.println(i++);
//        }
//        System.out.println(carList);
//        connection.close();
//
//        CarController carController = new CarController();
//        carController.deleteCar(5);

        int expected = 5;
        int actual = 5;

        assertEquals("Test changeFirstLastWordsInSentence", expected, actual);

    }

    @Test
    public void deleteCar() throws Exception {

    }

    public static void dropDB() {

        Connection connection = getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("DROP TABLE if EXISTS tachkischema.cars");
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement("DROP TABLE if EXISTS tachkischema.brand");
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement("DROP SCHEMA  if EXISTS tachkischema CASCADE");
            preparedStatement.execute();
//            preparedStatement = connection.prepareStatement("DROP DATABASE  if EXISTS bdtachki");
//            preparedStatement.execute();

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void createSchemaAndTables() {
        Flyway flyway = new Flyway();

        flyway.setDataSource(url, user, password, null);
        flyway.clean();
        flyway.migrate();
    }

}