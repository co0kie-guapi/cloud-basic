package com.guapi.entity.base;

import lombok.Data;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 基础实体类
 * @author co0kie
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;


    /**
     * 更新人
     */
    private String updateBy;



}
