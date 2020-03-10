package com.yousu.dataconverterplateform.module.primary.entity;

import com.yousu.dataconverterplateform.common.util.SnowFlakeUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author Liupeiqing
 * @Date 2020/3/9 22:28
 * @Version 1.0
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    private String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    private String name;
    private int age;
}
