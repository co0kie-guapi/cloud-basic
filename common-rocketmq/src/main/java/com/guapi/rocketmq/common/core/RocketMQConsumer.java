package com.guapi.rocketmq.common.core;

import com.guapi.rocketmq.common.function.MessageProcessor;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;


/**
 * mq consumer端
 * @author co0kie
 */
public class RocketMQConsumer {
    private final DefaultMQPushConsumer consumer;

    public RocketMQConsumer(String groupName, String namesrvAddrs, String topic, MessageProcessor messageProcessor){
        consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddrs); // 支持多个Namesrv，格式: "ip1:port1;ip2:port2"
        try {
            consumer.subscribe(topic, "*");
        } catch (MQClientException e) {
            throw new RuntimeException(e);
        }
        consumer.registerMessageListener((List<org.apache.rocketmq.common.message.MessageExt> msgs, org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext context) -> {
            for (org.apache.rocketmq.common.message.MessageExt msg : msgs) {
                if (!messageProcessor.process(msg)) {
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
    }

    public void start() throws Exception {
        consumer.start();
    }

    public void shutdown() {
        consumer.shutdown();
    }
}
