package com.co0kie.repositoryedge.domain;


import com.co0kie.repositoryedge.domain.enums.AsyncResultEnums;
import lombok.*;

import java.util.function.Supplier;

/**
 * 异步任务的状态
 * @author yanghx
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsyncResult<T> {

    /**
     * 成功与否
     */
    private AsyncResultEnums resultEnums;


    /**
     * 数据
     */
    private T data;


    /**
     * 解包
     * @return
     * @throws NullPointerException
     */
    public T unwrap() throws NullPointerException {
        if (data == null){
            throw new NullPointerException();
        }
        return data;
    }

    /**
     * 匹配
     */
    public void match(



    ){

    }



}
