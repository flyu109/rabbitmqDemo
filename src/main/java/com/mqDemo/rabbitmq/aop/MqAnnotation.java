package com.mqDemo.rabbitmq.aop;

import java.lang.annotation.*;

/**
 * 自定MQ 注解
 * Created by baoping.zhang on 2017/5/27.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MqAnnotation {
   String routingKey() default "";
}
