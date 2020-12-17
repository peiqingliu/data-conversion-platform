package com.yousu.dataconverterplateform.module.oracle.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-17 22:56
 * 3.4.3.	检查报告信息
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "EXAM_DEATAIL_INFO")
public class ExamReportInfo {
}

