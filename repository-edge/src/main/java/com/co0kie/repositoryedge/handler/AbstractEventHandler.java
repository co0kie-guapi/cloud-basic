package com.co0kie.repositoryedge.handler;


import com.co0kie.repositoryedge.domain.AsyncResult;

import java.util.function.Function;

public class AbstractEventHandler<T> implements EventHandler{
    @Override
    public AsyncResult doHandler(Function callBack) {
        return null;
    }
}
