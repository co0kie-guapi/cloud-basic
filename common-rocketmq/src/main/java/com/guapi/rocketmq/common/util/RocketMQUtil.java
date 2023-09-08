package com.guapi.rocketmq.common.util;

import com.guapi.rocketmq.common.config.RocketMqConfig;
import com.guapi.rocketmq.common.core.RocketMQConsumer;
import com.guapi.rocketmq.common.core.RocketMQProducer;
import com.guapi.rocketmq.common.function.MessageProcessor;

import java.util.concurrent.ConcurrentHashMap;

/**
 * rocketMq工具
 * @author co0kie
 */
public class RocketMQUtil {
    // 使用ConcurrentHashMap来存储单例对象
    private static final ConcurrentHashMap<String, RocketMQProducer> producerMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, RocketMQConsumer> consumerMap = new ConcurrentHashMap<>();

    public static RocketMQProducer getProducer(RocketMqConfig config) {
        return producerMap.computeIfAbsent(config.getGroupName(), key -> {
            RocketMQProducer producer = new RocketMQProducer(config.getGroupName(), config.getNamesrvAddr());
            try {
                producer.start();
            } catch (Exception e) {
                throw new RuntimeException("Failed to start producer for group: " + key, e);
            }
            return producer;
        });
    }

    public static RocketMQConsumer getConsumer(RocketMqConfig config, MessageProcessor messageProcessor) {
        return consumerMap.computeIfAbsent(config.getGroupName() + "_" + config.getTopic(), key -> {
            RocketMQConsumer consumer = new RocketMQConsumer(config.getGroupName(), config.getNamesrvAddr(), config.getTopic(), messageProcessor);
            try {
                consumer.start();
            } catch (Exception e) {
                throw new RuntimeException("Failed to start consumer for group: " + config.getGroupName() + " and topic: " + config.getTopic(), e);
            }
            return consumer;
        });
    }

    // 如果需要，你可以提供关闭Producer和Consumer的方法
    public static void shutdownAll() {
        producerMap.values().forEach(RocketMQProducer::shutdown);
        consumerMap.values().forEach(RocketMQConsumer::shutdown);
    }
}