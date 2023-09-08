package com.guapi.rocketmq.common.core;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * mq producer端
 * @author co0kie
 */
public class RocketMQProducer {
    private final DefaultMQProducer producer;

    public RocketMQProducer(String groupName, String namesrvAddrs) {
        producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddrs); // 支持多个Namesrv，格式: "ip1:port1;ip2:port2"
    }

    public void start() throws MQClientException {
        producer.start();
    }

    public SendResult send(String topic, String body) throws Exception {
        return producer.send(new org.apache.rocketmq.common.message.Message(topic, body.getBytes()));
    }

    public void shutdown() {
        producer.shutdown();
    }
}
