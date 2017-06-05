package com.mqDemo.rabbitmq.demo;

import java.io.Serializable;

/**
 * Created by baoping.zhang on 2017/6/5.
 */
public class Student implements Serializable{
    private static final long serialVersionUID = -2635101375063954156L;
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
