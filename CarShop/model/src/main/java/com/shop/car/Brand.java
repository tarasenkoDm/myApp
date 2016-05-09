package com.shop.car;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */

@Entity
@Table(name = "Brand")
public class Brand implements Serializable{

    private static final long serialVersionUID = -7483986012966198271L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int brandId;
    @NotBlank(message = "please add Brand")
    @Column(name = "brand")
    private String brand;

    @OneToMany(mappedBy = "Brand", fetch = FetchType.LAZY)
    private Set<Car> carList = new HashSet<Car>();

    public Brand(){

    }

    public Brand(String brand) {
        this.brand = brand;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Set<Car> getCarList() {
        return carList;
    }

    public void setCarList(Set<Car> carList) {
        this.carList = carList;
    }
}
