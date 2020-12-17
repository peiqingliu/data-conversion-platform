package com.yousu.dataconverterplateform.module.slave.entity;
import cn.hutool.db.DaoTemplate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yousu.dataconverterplateform.common.util.SnowFlakeUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "t_origin_person")
public class OriginPerson {

    private static final long serialVersionUID = 1L;

    @Id
    private String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    /**
     * 人口主索引
     */
    private String patient_id;
    /**
     * 居民健康档案 留空
     */
    private String health_record_code;
    /**
     * 居民电子健康卡二维码 留空
     */
    private String health_card_id;

    /**
     * 姓名
     */
    private String name;
    /**
     * 姓名拼音
     */
    private String name_phonetic;

    /**
     * 性别
     */
    private String sex;

    /**
     * 婚姻状况代码
     */
    private String marital_status;

    /**
     * 出生日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date_of_birth;

    /**
     * 出生地-省市县（区）代码
     */
    private String birth_place1;
    /**
     * 出生地-区划内详细地址代码
     */
    private String birth_place2;
    /**
     * 国籍代码
     */
    private String citizenship;
    /**
     * 民族代码
     */
    private String nation;

    /**
     * 证件号码
     */
    private String id_no;

    /**
     * 身份代码
     */
    private String identity;

    /**
     * 费别代码
     */
    private String charge_type;

    /**
     * 合同单位
     */
    private String unit_in_contract;

    /**
     * 户籍地址-省市县（区）代码
     */
    private String mailing_address1;
    /**
     * 户籍地址-区划内详细地址代
     * 码
     */
    private String mailing_address2;
    /**
     * 实际居住地址-省市县（区）代
     * 码
     */
    private String mailing_address3;
    /**
     * 实际居住地址-区划内详细地
     * 址代码
     */
    private String mailing_address4;

    /**
     * 邮政编码
     */
    private String zip_code;

    /**
     * 家庭电话号码
     */
    private String phone_number_home;

    /**
     * 办公电话
     */
    private String phone_number_business;

    /**
     * 联系人姓名
     */
    private String next_of_kin;

    /**
     *与联系人关系代码，夫妻、父
     * 子等
     */
    private String relationship;

    /**
     * 联系人地址
     */
    private String next_of_kin_addr;

    /**
     * 联系人邮政编码
     */
    private String next_of_kin_zip_code;

    /**
     * 联系人电话号码
     */
    private String next_of_kin_phone;

    /**
     * 是否贫困人口（0 否 1 是） 查
     * 询返回值 新建更新不添加该
     * 节点
     */
    private String ispoor;

    /**
     * 死亡标识(0，在世；1，死亡)
     */
    private String dead_tag;

    /**
     * 脱贫日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date tprq;

    /**
     * 脱贫状态 新建更新不添加该
     * 节点
     */
    private String out_poverty_status;

    /**
     * 附加地址，对现住址扩展补充
     */
    private String attached_address;

    /**
     * 附加地址，对户籍地址扩展补
     * 充-门牌
     */
    private String attached_hujiaddress;

}
