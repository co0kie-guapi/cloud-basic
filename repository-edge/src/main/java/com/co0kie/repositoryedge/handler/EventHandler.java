package com.co0kie.repositoryedge.handler;


import com.co0kie.repositoryedge.domain.AsyncResult;
import com.guapi.entity.base.BaseEntity;

import java.util.function.Function;

/**
 * 用于事件处理的handler
 * @author co0kie
 */
public interface EventHandler<T extends BaseEntity> {

    /**
     * 执行handler
     * @param data
     * @return
     */
    void doHandler(T data);



}
