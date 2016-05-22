package com.shop.car.util.controllers

import com.shop.car.Car
import com.shop.car.util.CarService
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
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
//@WebAppConfiguration

class CarControllerTest {

    @Mock
    private CarService carService;
    @InjectMocks
    private CarController carController;
    private MockMvc mockMvc;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    void testGetAllCars() throws Exception {
        when(carService.getAllCars()).thenReturn(new Car(1, "Q7", "red", 30000,1))

    }

    void testDeleteCar() {

    }
}
