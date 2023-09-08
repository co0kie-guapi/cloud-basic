package com.co0kie.repositoryedge.domain.enums;

/**
 * 异步任务
 * @author co0k1e
 */
public enum AsyncResultEnums {
    //成功
    SUCCESS("1"),
    //失败
    failed("2"),
    //不确定
    unknown("3");

    /**
     * 具体的值
     */
    private String value;


    AsyncResultEnums(String value){
        this.value = value;
    }



}
