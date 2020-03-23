package com.yousu.dataconverterplateform.module.slave.service;

import com.yousu.dataconverterplateform.common.vo.SearchVo;
import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author Liupeiqing
 * @Date 2020/3/14 22:36
 * @Version 1.0
 */
public interface InterfaceInformationService {

    /**
     * 多条件分页获取接口列表
     * @param user
     * @param searchVo
     * @param pageable
     * @return
     */
    Page<InterfaceInformation> findByCondition(InterfaceInformation user, SearchVo searchVo, Pageable pageable);

    InterfaceInformation save(InterfaceInformation interfaceInformation);

    InterfaceInformation update(InterfaceInformation interfaceInformation);

    void delete(String id);

    List<InterfaceInformation> findAllByWhetherOpen(int whetherOpen);
}
