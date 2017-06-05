package com.mqDemo.rabbitmq.demo;

import com.mqDemo.rabbitmq.demo.producer.StudentMQ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by baoping.zhang on 2017/6/5.
 */
public class StudenMqTest {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        StudentMQ studentMQ = (StudentMQ) context.getBean("studentMQ");
        studentMQ.sendStudent();
    }
}
