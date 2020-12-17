package com.yousu.dataconverterplateform.module.slave.entity;


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

/**
 * 地贫检验设备报告上传日志
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "t_get_dpcsex_log")
public class GetDPCSExLog {

    private static final long serialVersionUID = 1L;

    @Id
    private String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    private String reportNum;

    private String visitNo;


    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date prescDate;

    private String name;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateDate;

    /**
     * 是否已上传 0 未上传  1已上传
     */
    private int alreadyUploaded;

    /**
     * 检验项目编码
     */
    private String examinationcode;

    private String idNo;

    private String patientId;
}
