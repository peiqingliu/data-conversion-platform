package com.yousu.dataconverterplateform.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Liupeiqing
 * @Date 2020/3/11 22:34
 * @Version 1.0
 */
@Data
public class PageVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 页号
     */
    private int currentPage;

    /**
     * 页面大小
     */
    private int pageSize;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序方式 asc/desc
     */
    private String order;

}
