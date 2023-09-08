package com.co0kie.repositoryedge.handler;


import com.co0kie.repositoryedge.domain.AsyncResult;

import java.util.function.Function;

/**
 * 用于事件处理的handler
 * @author co0kie
 */
public interface EventHandler<T> {

    /**
     *
     * @param callBack
     * @return
     */
    AsyncResult<T> doHandler(Function callBack);

}
