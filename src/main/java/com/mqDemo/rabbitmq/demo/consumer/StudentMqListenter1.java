package com.mqDemo.rabbitmq.demo.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mqDemo.rabbitmq.aop.MqAspect;
import com.mqDemo.rabbitmq.event.EventMessage;
import com.mqDemo.rabbitmq.handler.IHandler;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * Created by baoping.zhang on 2017/6/5.
 */
public class StudentMqListenter1 implements ChannelAwareMessageListener {
    private static Logger logger = LoggerFactory.getLogger(StudentMqListenter1.class);
    private IHandler iHandler;
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println("第二次监听");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
        byte[] body = message.getBody();
        String source = new String(body);
        EventMessage em = JSONObject.parseObject(source, EventMessage.class);
        Object obj = JSONObject.parseObject(JSON.toJSONString(em.getBody()),em.getClazz());
        try {
            iHandler.handler(obj);
        } catch (Exception e) {
            logger.error("消息处理错误",e);
            iHandler.callBack(obj);
        }
    }
    public void setiHandler(IHandler iHandler) {
        this.iHandler = iHandler;
    }
}
