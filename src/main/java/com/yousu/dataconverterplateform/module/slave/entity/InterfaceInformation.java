package com.yousu.dataconverterplateform.module.slave.entity;

import com.yousu.dataconverterplateform.base.BaseEntity;
import com.yousu.dataconverterplateform.common.constant.CommonConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author Liupeiqing
 * @Date 2020/3/14 22:33
 * @Version 1.0
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "t_interface_information")
public class InterfaceInformation extends BaseEntity {

    /**
     * 接口名称
     */
    private String interfaceName;

    /**
     * 接口编码
     */
    private String interfaceCode;

    /**
     * 接口类型
     */
    private String interfaceType;

    /**
     * 接口执行sql
     */
    private String prepareExecuteSql;

    /**
     * 位置索引
     */
    private String siteIndex;

    /**
     * 定时任务表达式
     */
    private String cron;

    /**
     * 是否开启定时任务 0表示不开启,1开启
     */
    private int whetherOpen = CommonConstant.TASK_NO_OPEN;

    /**
     * 数据模型
     */
    private String dataModel;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 接口的soapAction
     */
    private String soapAction;

    /**
     * 是否是多个数据一起传输
     */
    private int multiple = CommonConstant.IS_MULTIPLE;

    /**
     * 查询时间
     */
    private int searchTime = CommonConstant.DEFAULT_VALUE;

}
