package com.co0kie.repositoryedge.core;

import com.co0kie.repositoryedge.domain.AsyncResult;


/**
 * 持久化保存的PersistentEntry
 * @author co0kie
 */
public interface PersistentEntry {

    /**
     * 初始化
     */
    void initialize();


    /**
     * 持久化之前
     * @return
     */
    Boolean beforeProcessor();


    /**
     * 做持久化
     * @return
     */
    Boolean doPersistent();


    /**
     * 后置处理
     * @return
     */
    Boolean postProcessor();


}
