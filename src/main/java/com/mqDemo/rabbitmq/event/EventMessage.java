
package com.mqDemo.rabbitmq.event;

import java.io.Serializable;
import java.util.Map;

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

    private Map<String ,Object> header;

    private Object body;

    private Class<?> clazz;

    public Map<String, Object> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Object> header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
