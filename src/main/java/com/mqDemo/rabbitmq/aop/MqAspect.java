package com.mqDemo.rabbitmq.aop;

import com.mqDemo.rabbitmq.event.EventMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * rabbitmq 切面逻辑 发送消息
 * Created by baoping.zhang on 2017/6/5
 */
@Aspect
@Component
public class MqAspect {
    private static Logger logger = LoggerFactory.getLogger(MqAspect.class);

    @Resource
    private RabbitTemplate rabbitTemplate;
    //切入点，也就是上面那个注解的路径
    @Pointcut("@annotation(com.mqDemo.rabbitmq.aop.MqAnnotation)")
    public  void mqAnnotation() {
    }
    @Around("mqAnnotation()")
    public void sendDataToQueue (ProceedingJoinPoint pjp) throws Throwable {
        // 得到切面的返回值
        Object retVal = pjp.proceed();
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("发送的消息："+retVal.toString());
        MqAnnotation mqAnnotation =getMqAnnotiaon(pjp);
        EventMessage message = new EventMessage();
        message.setBody(retVal);
        message.setClazz(retVal.getClass());
        rabbitTemplate.convertAndSend(mqAnnotation.exchangeName(),mqAnnotation.routingKey(),message,correlationId);
    }
    public  static MqAnnotation getMqAnnotiaon(JoinPoint joinPoint)  throws Exception {
        MqAnnotation mqAnnotation= null;
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                     mqAnnotation = method.getAnnotation(MqAnnotation.class);
                    break;
                }
            }
        }
        return mqAnnotation;
    }
}
