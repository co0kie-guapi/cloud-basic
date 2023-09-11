package com.co0kie.repositoryedge.core;

import com.guapi.entity.base.BaseEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersistentEntryHandler <T extends BaseEntity> implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Handle method calls here
        System.out.println("Called method: " + method.getName());
        return Boolean.TRUE; // as an example, since your methods return Boolean
    }

}
