package com.yousu.dataconverterplateform.module.slave.service;

import com.yousu.dataconverterplateform.module.slave.entity.OriginPerson;

/**
 * @Author peiqing Liu
 * @Date 2020/4/7 20:01
 * @Version 1.0
 */
public interface OriginPersonService {

    OriginPerson save(OriginPerson originPerson);

    String findByIdNo(String idNo);

    void deleteById(String id);
}
