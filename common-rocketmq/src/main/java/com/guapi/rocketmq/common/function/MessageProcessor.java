package com.guapi.rocketmq.common.function;


/**
 * 消息处理器函数式接口
 * @author co0kie
 */
@FunctionalInterface
public interface MessageProcessor {
    /**
     * 执行
     * @param message
     * @return
     */
    boolean process(org.apache.rocketmq.common.message.MessageExt message);
}
