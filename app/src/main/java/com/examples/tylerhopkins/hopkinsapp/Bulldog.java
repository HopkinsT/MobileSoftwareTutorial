package com.examples.tylerhopkins.hopkinsapp;

import java.io.Serializable;

/**
 * Created by Tyler Hopkins on 9/13/2017.
 */

public class Bulldog implements Serializable {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Bulldog()
    {
        name = "Generic Dog";
        age = "NULL";
    }

     public Bulldog(String name, String age)
    {
        this.name = name;
        this.age = age;
    }
}
