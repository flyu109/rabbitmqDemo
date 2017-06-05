
package com.mqDemo.rabbitmq.event;

import java.io.Serializable;

/**
 * 
 * Title: Class EventMessage
 * Description:
 *	rabbitmq 消息载体
 *
 * @author guoqiang.zhao
 * @email  guoqiang.zhao@chinaredstar.com
 * @version 1.0.0
 */
public class EventMessage implements Serializable{

    private static final long serialVersionUID = 6742149452746213290L;
    private Class<?> clazz;
    private String attachment;


    public Class<?> getClazz() {
        return clazz;
    }
    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
    public String getAttachment() {
        return attachment;
    }
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "EventMessage{" +
                "clazz=" + clazz +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
