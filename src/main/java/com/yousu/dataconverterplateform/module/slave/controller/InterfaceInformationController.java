package com.yousu.dataconverterplateform.module.slave.controller;

import com.yousu.dataconverterplateform.common.util.PageUtil;
import com.yousu.dataconverterplateform.common.util.ResultUtil;
import com.yousu.dataconverterplateform.common.vo.PageVo;
import com.yousu.dataconverterplateform.common.vo.Result;
import com.yousu.dataconverterplateform.common.vo.SearchVo;
import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import com.yousu.dataconverterplateform.module.slave.service.InterfaceInformationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @Author Liupeiqing
 * @Date 2020/3/15 13:44
 * @Version 1.0
 */

@Slf4j
@RestController
@RequestMapping("/system/interfaceInformation")
@AllArgsConstructor
public class InterfaceInformationController {

    private InterfaceInformationService interfaceInformationService;


    @Transactional
    @GetMapping(value = "/getByCondition")
    public Result<Page<InterfaceInformation>> getByCondition(@ModelAttribute InterfaceInformation interfaceInformation,
                                                                   @ModelAttribute SearchVo searchVo,
                                                                   @ModelAttribute PageVo pageVo){
        Page<InterfaceInformation> page =
                interfaceInformationService.findByCondition(interfaceInformation,searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<InterfaceInformation>>().setData(page);
    }

    @PostMapping("/save")
    public Result<InterfaceInformation> save(@RequestBody InterfaceInformation interfaceInformation){
        InterfaceInformation information = interfaceInformationService.save(interfaceInformation);
        return new ResultUtil<InterfaceInformation>().setData(information);
    }

    @PostMapping("/update")
    public Result<InterfaceInformation> update(@RequestBody InterfaceInformation interfaceInformation){
        InterfaceInformation information =  interfaceInformationService.update(interfaceInformation);
        return new ResultUtil<InterfaceInformation>().setData(information);
    }

    @GetMapping("/deleteById")
    public Result<Object> deleteById(@RequestParam("id") String id){
        interfaceInformationService.delete(id);
        return new ResultUtil<Object>().setSuccessMsg("删除成功");
    }
}
