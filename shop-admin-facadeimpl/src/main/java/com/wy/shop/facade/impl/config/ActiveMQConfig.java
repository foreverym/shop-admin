package com.wy.shop.facade.impl.config;

import com.wy.shop.common.constants.ActiveMQQueueConstants;
import com.wy.shop.common.constants.ActiveMQTopicConstants;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @description ActiveMQ消息队列配置类
 */
public class ActiveMQConfig
{

    @Bean(name = ActiveMQQueueConstants.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public JmsListenerContainerFactory jmsQueueListenerContainerFactory(ConnectionFactory connectionFactory)
    {
        DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsQueueListenerContainerFactory.setConnectionFactory(connectionFactory);
        // 设置 PTP or Pub/Sub
        jmsQueueListenerContainerFactory.setPubSubDomain(Boolean.FALSE);
        /*
         * 消息认领模式，默认自动认领 AUTO,CLIENT DUPS_OK
         */
        jmsQueueListenerContainerFactory.setSessionAcknowledgeMode(JmsProperties.AcknowledgeMode.AUTO.getMode());
        // 是否开启事务
        jmsQueueListenerContainerFactory.setSessionTransacted(Boolean.FALSE);
        return jmsQueueListenerContainerFactory;
    }


    @Bean(name = ActiveMQTopicConstants.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory)
    {
        DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsQueueListenerContainerFactory.setConnectionFactory(connectionFactory);
        // 设置 PTP or Pub/Sub
        jmsQueueListenerContainerFactory.setPubSubDomain(Boolean.TRUE);
        // 设置客户端ID
        // jmsQueueListenerContainerFactory.setClientId("topicClientId");
        // 持久化订阅, 持久化订阅必须设置客户端ID
        // jmsQueueListenerContainerFactory.setSubscriptionDurable(Boolean.TRUE);
        return jmsQueueListenerContainerFactory;
    }

}
