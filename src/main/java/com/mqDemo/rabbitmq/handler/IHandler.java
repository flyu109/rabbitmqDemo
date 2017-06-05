package com.mqDemo.rabbitmq.handler;

/**
 * 
 * Title: Class IHandler
 * Description:
 *	<p>rabbitmq 消费者统一封装接口 所有的消息处理器都要实现这个接口</p>
 * @param <T>
 */
public interface IHandler<T> {
    
	/**
	 * 
	 * 消费者处理对应的信息
	 * @version 
	 * @param attachment
	 * 	待处理的消息对象
	 */
    public void handler(T attachment);


	/**
	 * 消费者处理对应的信息
	 * @version
	 * @param attachment
	 * 	待处理的消息对象
	 */
	public void callBack(T attachment);

}
