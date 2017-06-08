package com.mqDemo.rabbitmq.demo.producer;

import com.alibaba.fastjson.JSON;
import com.mqDemo.rabbitmq.aop.MqAnnotation;
import com.mqDemo.rabbitmq.demo.Student;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by baoping.zhang on 2017/6/5.
 */
@Component
public class StudentMQ {

    @MqAnnotation(exchangeName = "exchangeTest",routingKey = "com.mqdemo.student")
    public Object sendStudent() throws IOException {
        Student student = new Student();
        student.setName("zbp109");
        student.setAge(30);
        return student;
    }
}
