package com.mqDemo.rabbitmq.demo.handler;

import com.mqDemo.rabbitmq.demo.Student;
import com.mqDemo.rabbitmq.handler.IHandler;

/**
 * Created by baoping.zhang on 2017/6/5.
 */
public class StudentHandler implements IHandler<Student>{

    public void handler(Student attachment) {
        System.out.println(attachment.toString());
    }

    public void callBack(Student attachment) {

    }
}
