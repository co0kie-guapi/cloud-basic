package com.co0kie.repositoryedge.handler;


import com.co0kie.repositoryedge.core.PersistentEntry;
import com.co0kie.repositoryedge.domain.AsyncResult;
import com.guapi.entity.base.BaseEntity;

import java.util.function.Function;

/**
 * 事件处理的模板方法
 * @param <T>
 */
public abstract class AbstractEventHandler<T extends BaseEntity> implements EventHandler<T>{

    /**
     *  持久化entry
     */
    private PersistentEntry<T> persistentEntry;


    @Override
    public void doHandler(T data) {
        checkAndInitialized(data);
        beforeEventHandle(data);


    }


    /**
     * 检查以及初始化
     */
    public void checkAndInitialized(T data){
        if (persistentEntry == null){

        }
    }



    /**
     * 前置处理
     */
    abstract void beforeEventHandle(T data);





}
