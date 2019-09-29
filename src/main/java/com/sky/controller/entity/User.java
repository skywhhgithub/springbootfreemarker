package com.sky.controller.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String name;
    private Integer age;
    private Double cash;
    private Boolean isMan;
    private Date bath;

    public User(String id,String name, Integer age, Double cash, Boolean isMan, Date bath) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cash = cash;
        this.isMan = isMan;
        this.bath = bath;
    }
}
