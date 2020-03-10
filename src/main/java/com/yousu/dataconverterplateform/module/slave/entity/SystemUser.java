package com.yousu.dataconverterplateform.module.slave.entity;

import com.yousu.dataconverterplateform.base.BaseEntity;
import com.yousu.dataconverterplateform.common.constant.CommonConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author Liupeiqing
 * @Date 2020/3/9 21:05
 * @Version 1.0
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "t_system_user")
public class SystemUser extends BaseEntity {

    private String username;
    private String password;
    private String fullname;
    @Column(length = 1000)
    private String avatar = CommonConstant.USER_DEFAULT_AVATAR;
    private String description;

}
