package com.yousu.dataconverterplateform.module.oracle.service.impl;

import com.yousu.dataconverterplateform.module.oracle.entity.ExamDeatailInfo;
import com.yousu.dataconverterplateform.module.oracle.repository.ExamDeatailInfoRepository;
import com.yousu.dataconverterplateform.module.oracle.service.ExamDeatailInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-17 22:55
 */
@Service
@Slf4j
@AllArgsConstructor
public class ExamDeatailInfoServiceImpl implements ExamDeatailInfoService {
    private ExamDeatailInfoRepository examDeatailInfoRepository;
    @Override
    public void saveOrUpdate(ExamDeatailInfo examDeatailInfo) {
        examDeatailInfoRepository.save(examDeatailInfo);
    }
}

