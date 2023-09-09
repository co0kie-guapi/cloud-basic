package com.co0kie.repositoryedge.handler;


import com.co0kie.repositoryedge.domain.AsyncResult;
import com.guapi.entity.base.BaseEntity;

import java.util.function.Function;

/**
 * 事件处理的模板方法
 * @param <T>
 */
public abstract class AbstractEventHandler<T extends BaseEntity> implements EventHandler<T>{

    @Override
    public void doHandler(T data) {

    }





}
