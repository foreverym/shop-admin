package com.wy.shop.common.constants;

public class ActiveMQQueueConstants
{
    /**
     * 在Queue模式中，对消息的监听需要对containerFactory进行配置，工厂标识
     */
    public static final String BEAN_NAME_JMSLISTENERCONTAINERFACTORY = "queueJmsListenerContainerFactory";
    /**
     * 队列名称 B2B自动任务
     */
    public static final String QUEUE_B2B_AUTO_TASK = "PBX.B2B.QUEUE.AUTO.TASK";

    /**
     * 队列名称:创建msg的任务处理
     */
    public static final String QUEUE_B2B_MSG_CREATE = "PBX.B2B.QUEUE.MSG.CREATE.PROCESS";

    /**
     * 队列名称:结束msg的任务处理
     */
    public static final String QUEUE_B2B_MSG_FINISH = "PBX.B2B.QUEUE.MSG.FINISH.PROCESS";
}