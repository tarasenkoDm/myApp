package com.shop.car;


import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Tarasenko Dmitriy <lordtda@gmail.com>
 * @version 0.1
 */


@Entity
@Table(name = "dd11")
public class User {

    private long userId;
    private String iserName;
    private String email;
    private String password;
    private boolean checkAdmin;

    public User(){

    }


}
