package com.yousu.dataconverterplateform.module.slave.service.impl;

import cn.hutool.core.date.DateUtil;
import com.google.common.base.Strings;
import com.yousu.dataconverterplateform.common.vo.SearchVo;
import com.yousu.dataconverterplateform.module.slave.entity.SystemDict;
import com.yousu.dataconverterplateform.module.slave.repository.SystemDictRepository;
import com.yousu.dataconverterplateform.module.slave.service.SystemDictService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Liupeiqing
 * @Date 2020/3/15 22:06
 * @Version 1.0
 */
@AllArgsConstructor
@Service
@Slf4j
public class SystemDictServiceImpl implements SystemDictService {

    private SystemDictRepository systemDictRepository;

    @Override
    public Page<SystemDict> findByCondition(SystemDict systemDict, SearchVo searchVo, Pageable pageable) {

        return systemDictRepository.findAll(new Specification<SystemDict>() {

            @Nullable
            @Override
            public Predicate toPredicate(Root<SystemDict> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                Path<String> dictKeyFiled = root.get("dictKey");
                Path<String> dictValueFiled = root.get("dictValue");
                Path<Integer> statusField = root.get("status");
                Path<Date> createTimeField = root.get("createTime");
                List<Predicate> list = new ArrayList<Predicate>();

                //字典key
                if (!Strings.isNullOrEmpty(systemDict.getDictKey())){
                    list.add(cb.equal(dictKeyFiled,systemDict.getDictKey()));
                }

                //字典名称
                if (!Strings.isNullOrEmpty(systemDict.getDictValue())){
                    list.add(cb.like(dictValueFiled,'%' + systemDict.getDictValue() + '%'));
                }


                //状态
                list.add(cb.equal(statusField,systemDict.getStatus()));

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
    public SystemDict save(SystemDict systemDict) {
        return systemDictRepository.save(systemDict);
    }

    @Override
    public SystemDict update(SystemDict systemDict) {
        return systemDictRepository.saveAndFlush(systemDict);
    }

    @Override
    public void delete(String id) {
        systemDictRepository.deleteById(id);
    }
}
