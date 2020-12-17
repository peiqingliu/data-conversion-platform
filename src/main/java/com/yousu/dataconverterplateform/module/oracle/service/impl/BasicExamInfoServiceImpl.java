package com.yousu.dataconverterplateform.module.oracle.service.impl;

import com.yousu.dataconverterplateform.module.oracle.entity.BasicExamInfo;
import com.yousu.dataconverterplateform.module.oracle.repository.BasicExamInfoRepository;
import com.yousu.dataconverterplateform.module.oracle.service.BasicExamInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-17 22:35
 */
@Slf4j
@Service
@AllArgsConstructor
public class BasicExamInfoServiceImpl implements BasicExamInfoService {

    private BasicExamInfoRepository basicExamInfoRepository;

    @Override
    public void saveOrUpdate(BasicExamInfo basicExamInfo) {
        basicExamInfoRepository.save(basicExamInfo);
    }
}

