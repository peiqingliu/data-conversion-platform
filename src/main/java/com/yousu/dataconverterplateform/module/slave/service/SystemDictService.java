package com.yousu.dataconverterplateform.module.slave.service;

import com.yousu.dataconverterplateform.common.vo.SearchVo;
import com.yousu.dataconverterplateform.module.slave.entity.SystemDict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author Liupeiqing
 * @Date 2020/3/15 22:05
 * @Version 1.0
 */
public interface SystemDictService {

    Page<SystemDict> findByCondition(SystemDict systemDict, SearchVo searchVo, Pageable pageable);

    SystemDict save(SystemDict systemDict);

    SystemDict update(SystemDict systemDict);

    void delete(String id);
}
