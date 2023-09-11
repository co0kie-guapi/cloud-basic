package com.co0kie.repositoryedge.core;

import com.co0kie.repositoryedge.domain.AsyncResult;
import com.guapi.entity.base.BaseEntity;


/**
 * 持久化保存的PersistentEntry
 * @author co0kie
 */
public interface PersistentEntry<T extends BaseEntity> {

    /**
     * 初始化
     */
    void initialize();


    /**
     * 插入持久化
     * @param data
     * @return
     */
    Boolean doCreatPersistent(T data);


    /**
     * 更新持久化
     * @param data
     * @return
     */
    Boolean doUpdatePersistent(T data);


    /**
     * 删除
     * @param data
     * @return
     */
    Boolean doRemove(T data);



}
