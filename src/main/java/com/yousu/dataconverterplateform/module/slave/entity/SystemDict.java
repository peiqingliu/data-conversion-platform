package com.yousu.dataconverterplateform.module.slave.entity;

import com.yousu.dataconverterplateform.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author Liupeiqing
 * @Date 2020/3/15 22:02
 * @Version 1.0
 */

@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "t_system_dict")
public class SystemDict extends BaseEntity {

    /**
     * 字典key
     */
    private String dictKey;
    /**
     * 字典value值
     */
    private String dictValue;

    /**
     * 描述
     */
    private String description;

    /**
     * 类型
     */
    private String type;

    /**
     * 排序
     */
    private Integer sortOrder;
}
