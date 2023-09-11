package com.co0kie.repositoryedge.core.factory;

import com.co0kie.repositoryedge.core.PersistentEntry;
import com.co0kie.repositoryedge.core.PersistentEntryHandler;
import com.guapi.entity.base.BaseEntity;

import java.lang.reflect.Proxy;


/**
 *
 * @param <T>
 */
public class PersistentEntryFactory<T extends BaseEntity> {

    public PersistentEntry<T> createPersistentEntry() {
        return (PersistentEntry<T>) Proxy.newProxyInstance(
                PersistentEntry.class.getClassLoader(),
                new Class<?>[]{PersistentEntry.class},
                new PersistentEntryHandler<>()
        );
    }

}
