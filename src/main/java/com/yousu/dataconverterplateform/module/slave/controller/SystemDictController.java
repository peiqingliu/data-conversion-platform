package com.yousu.dataconverterplateform.module.slave.controller;

import com.yousu.dataconverterplateform.common.util.PageUtil;
import com.yousu.dataconverterplateform.common.util.ResultUtil;
import com.yousu.dataconverterplateform.common.vo.PageVo;
import com.yousu.dataconverterplateform.common.vo.Result;
import com.yousu.dataconverterplateform.common.vo.SearchVo;
import com.yousu.dataconverterplateform.module.slave.entity.SystemDict;
import com.yousu.dataconverterplateform.module.slave.service.SystemDictService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Liupeiqing
 * @Date 2020/3/15 22:16
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/system/dict")
@AllArgsConstructor
public class SystemDictController {

    private SystemDictService systemDictService;


    @Transactional
    @GetMapping(value = "/getByCondition")
    public Result<Page<SystemDict>> getByCondition(@ModelAttribute SystemDict systemDict,
                                                   @ModelAttribute SearchVo searchVo,
                                                   @ModelAttribute PageVo pageVo){
        Page<SystemDict> page =
                systemDictService.findByCondition(systemDict,searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<SystemDict>>().setData(page);
    }


    @PostMapping("/save")
    public Result<SystemDict> save(@RequestBody SystemDict systemDict){
        SystemDict s = systemDictService.save(systemDict);
        return new ResultUtil<SystemDict>().setData(s);
    }

    @PostMapping("/update")
    public Result<SystemDict> update(@RequestBody SystemDict systemDict){
        SystemDict s =  systemDictService.update(systemDict);
        return new ResultUtil<SystemDict>().setData(s);
    }

    @GetMapping("/deleteById")
    public Result<Object> deleteById(@RequestParam("id") String id){
        systemDictService.delete(id);
        return new ResultUtil<Object>().setSuccessMsg("删除成功");
    }


}
