package com.yousu.dataconverterplateform.module.oracle.service;

import com.yousu.dataconverterplateform.module.oracle.entity.PersonPatientInfo;

import java.util.List;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/11 16:01
 * @File PersonPatientInfoService
 * @Software IntelliJ IDEA
 * @description todo
 */
public interface PersonPatientInfoService {

    void saveAll(List<PersonPatientInfo> personPatientInfos);

    void saveOrUpdate(PersonPatientInfo personPatientInfo);
}
