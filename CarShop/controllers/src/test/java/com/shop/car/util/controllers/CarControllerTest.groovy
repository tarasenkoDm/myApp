package com.shop.car.util.controllers

import com.shop.car.Car
import com.shop.car.util.CarService
import org.eclipse.jetty.server.Connector
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.ServerConnector
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration

class CarControllerTest {

    List<Car> expactedListOfCars = new ArrayList<>();


    @Before
    public void startJetty() {

        Server server = new Server();

        server.start();
        createList();


    }


    @Mock
    private CarService carService;
    @InjectMocks
    private CarController carController;
    private MockMvc mockMvc;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
   public void testGetAllCars() throws Exception {
        when(carService.getAllCars()).thenReturn(new Car(1, "Q7", "red", 30000, 1))


    }

    @Test
    void testDeleteCar() {

    }


    private void createList() {
        Car car1 = new Car();
        car1.carId = 1;
        car1.model = "Q7";
        car1.color = "red";
        car1.brand = "Audi";
        car1.price = 30000;

        Car car2 = new Car();
        car1.carId = 2;
        car1.model = "TT";
        car1.color = "black";
        car1.brand = "Audi";
        car1.price = 26000;

        Car car3 = new Car();
        car1.carId = 3;
        car1.model = "X5";
        car1.color = "blue";
        car1.brand = "BMW";
        car1.price = 43000;

        Car car4 = new Car();
        car1.carId = 4;
        car1.model = "X3";
        car1.color = "white";
        car1.brand = "BMW";
        car1.price = 18000;

        Car car5 = new Car();
        car1.carId = 5;
        car1.model = "Jetta";
        car1.color = "green";
        car1.brand = "VW";
        car1.price = 16000;

        Car car6 = new Car();
        car1.carId = 6;
        car1.model = "CC";
        car1.color = "grey";
        car1.brand = "VW";
        car1.price = 23000;

        Car car7 = new Car();
        car1.carId = 7;
        car1.model = "CLK";
        car1.color = "black";
        car1.brand = "Mercedes";
        car1.price = 19000;

        Car car8 = new Car();
        car1.carId = 8;
        car1.model = "600";
        car1.color = "white";
        car1.brand = "Mercedes";
        car1.price = 9000;

        Car car9 = new Car();
        car1.carId = 9;
        car1.model = "kengoo";
        car1.color = "red";
        car1.brand = "Renault";
        car1.price = 8500;

        Car car10 = new Car();
        car1.carId = 10;
        car1.model = "logan";
        car1.color = "red";
        car1.brand = "Renault";
        car1.price = 6000;


        Car car11 = new Car();
        car1.carId = 11;
        car1.model = "2108";
        car1.color = "red";
        car1.brand = "Lada";
        car1.price = 3000;

        Car car12 = new Car();
        car1.carId = 12;
        car1.model = "samara";
        car1.color = "red";
        car1.brand = "Lada";
        car1.price = 3700;

        Car car13 = new Car();
        car1.carId = 13;
        car1.model = "CR-V";
        car1.color = "red";
        car1.brand = "Honda";
        car1.price = 15800;

        Car car14 = new Car();
        car1.carId = 14;
        car1.model = "accord";
        car1.color = "red";
        car1.brand = "Honda";
        car1.price = 9000;

        Car car15 = new Car();
        car1.carId = 15;
        car1.model = "civik";
        car1.color = "red";
        car1.brand = "Honda";
        car1.price = 6000;

        expactedListOfCars.add(car1);
        expactedListOfCars.add(car2);
        expactedListOfCars.add(car3);
        expactedListOfCars.add(car4);
        expactedListOfCars.add(car5);
        expactedListOfCars.add(car6);
        expactedListOfCars.add(car7);
        expactedListOfCars.add(car8);
        expactedListOfCars.add(car9);
        expactedListOfCars.add(car10);
        expactedListOfCars.add(car11);
        expactedListOfCars.add(car12);
        expactedListOfCars.add(car13);
        expactedListOfCars.add(car14);
        expactedListOfCars.add(car15);
    }


}
