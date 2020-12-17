package com.yousu.dataconverterplateform.module.slave.service.impl;

import com.yousu.dataconverterplateform.module.slave.entity.OriginPerson;
import com.yousu.dataconverterplateform.module.slave.repository.OriginPersonRepository;
import com.yousu.dataconverterplateform.module.slave.service.OriginPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author peiqing Liu
 * @Date 2020/4/7 20:01
 * @Version 1.0
 */
@Slf4j
@Service
public class OriginPersonServiceImpl implements OriginPersonService {

    @Autowired
    private OriginPersonRepository originPersonRepository;

    @Override
    public OriginPerson save(OriginPerson originPerson) {
        return originPersonRepository.save(originPerson);
    }

    @Override
    public String findByIdNo(String idNo) {
        return originPersonRepository.findIdByIdNo(idNo);
    }

    @Override
    public void deleteById(String id) {
        originPersonRepository.deleteById(id);
    }


}
