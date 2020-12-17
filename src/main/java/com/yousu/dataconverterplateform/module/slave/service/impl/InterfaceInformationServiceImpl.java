package com.yousu.dataconverterplateform.module.slave.service.impl;

import cn.hutool.core.date.DateUtil;
import com.google.common.base.Strings;
import com.yousu.dataconverterplateform.common.vo.SearchVo;
import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import com.yousu.dataconverterplateform.module.slave.repository.InterfaceInformationRepository;
import com.yousu.dataconverterplateform.module.slave.service.InterfaceInformationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Liupeiqing
 * @Date 2020/3/14 22:39
 * @Version 1.0
 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class InterfaceInformationServiceImpl implements InterfaceInformationService {

    private InterfaceInformationRepository interfaceInformationRepository;

    @Override
    public Page<InterfaceInformation> findByCondition(InterfaceInformation interfaceInformation, SearchVo searchVo, Pageable pageable) {
        return interfaceInformationRepository.findAll(new Specification<InterfaceInformation>() {

            @Nullable
            @Override
            public Predicate toPredicate(Root<InterfaceInformation> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                Path<String> interfaceNameFiled = root.get("interfaceName");
                Path<String> interfaceCodeField = root.get("interfaceCode");
                Path<Integer> statusField = root.get("status");
                Path<Date> createTimeField = root.get("createTime");
                List<Predicate> list = new ArrayList<Predicate>();

                //接口名称
                if (!Strings.isNullOrEmpty(interfaceInformation.getInterfaceName())){
                    list.add(cb.like(interfaceNameFiled,'%' + interfaceInformation.getInterfaceName() + '%'));
                }

                //接口code
                if (!Strings.isNullOrEmpty(interfaceInformation.getInterfaceCode())){
                    list.add(cb.equal(interfaceCodeField,interfaceInformation.getInterfaceCode()));
                }


                //状态
                list.add(cb.equal(statusField,interfaceInformation.getStatus()));

                //创建时间
                if (!Strings.isNullOrEmpty(searchVo.getStartDate()) && Strings.isNullOrEmpty(searchVo.getEndDate())){
                    Date start = DateUtil.parse(searchVo.getStartDate());
                    Date end = DateUtil.parse(searchVo.getEndDate());
                    list.add(cb.between(createTimeField,start,DateUtil.endOfDay(end)));
                }
                Predicate[] arr = new Predicate[list.size()];
                cq.where(list.toArray(arr));
                return null;
            }
        },pageable);
    }

    @Override
    public InterfaceInformation save(InterfaceInformation interfaceInformation) {
        return interfaceInformationRepository.save(interfaceInformation);
    }

    @Override
    public InterfaceInformation update(InterfaceInformation interfaceInformation) {
        return interfaceInformationRepository.saveAndFlush(interfaceInformation);
    }

    @Override
    public void delete(String id) {
        interfaceInformationRepository.deleteById(id);
    }

    @Override
    public List<InterfaceInformation> findAllByWhetherOpen(int whetherOpen) {
        return interfaceInformationRepository.findAllByWhetherOpen(whetherOpen);
    }

    @Override
    public InterfaceInformation getOne(String id) {
        return interfaceInformationRepository.getOne(id);
    }
}
