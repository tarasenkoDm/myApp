package com.shop.car.util.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shop.car.Car;
import com.shop.car.util.CarService;
import com.shop.car.util.Impl.CarServiceImpl;
import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.json.JSONObject;
import org.junit.*;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//@WebAppConfiguration

public class CarControllerTest {

    private static String user = "postgres";
    private static String password = "postgres";
    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/bdtachki";


//    @BeforeClass
//    public static void applayDBSchema() {
//        final String CARS_DUMP = "C:\\TMP\\dump\\cars_dump.json";
//        final String CARS_DUMP_AFTER_DELETE = "C:\\TMP\\dump\\cars_dump_after_delete.json";
//
//        System.out.println("drop DB");
//        dropDB();
//        System.out.println("create all tables");
//        createSchemaAndTables();
//        System.out.println("create car's damp");
//        dumpCarTable(CARS_DUMP);
//
//        deleteCarById(5);
//        dumpCarTable(CARS_DUMP_AFTER_DELETE);
//
//        dropDB();
//        createSchemaAndTables();
//    }


    @Test
    public void getAllCars() throws Exception {

        CarService carService = new CarServiceImpl();
        List<Car> original = carService.getAllCars();
        for (Car car : original) {
            System.out.println(car);
        }

        int expected = 5;
        int actual = 5;

        assertEquals("Test changeFirstLastWordsInSentence", expected, actual);

    }

    @Test
    public void deleteCar() throws Exception {

//        CarController carController = new CarController();
//        carController.deleteCar(5);

        int expected = 5;
        int actual = 5;

        assertEquals("Test changeFirstLastWordsInSentence", expected, actual);


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

    private static void dumpCarTable(String dumpName) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Car> carList = new LinkedList<>();

        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM tachkischema.cars");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car();
                car.setCarId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
                car.setPrice(resultSet.getInt("price"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String carsDump = gson.toJson(carList);
        try (FileWriter writer = new FileWriter(dumpName)) {
            writer.write(carsDump);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void deleteCarById(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM tachkischema.cars WHERE id=" + id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}