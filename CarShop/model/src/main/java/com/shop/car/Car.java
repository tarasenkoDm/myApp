package com.shop.car;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */


@Entity
@Table(name = "Cars")
public class Car implements Serializable{

    private static final long serialVersionUID = 7048446688653800272L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long carId;
    @Column(name = "model")
    @NotBlank (message = "please add model")
    private String model;
    @Column(name = "color")
    @NotBlank (message = "please add color")
    private String color;
    @Column(name = "price")
    @NotBlank (message = "please add price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;

    public Car(){}

    public Car(long carId){
        this.carId = carId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
