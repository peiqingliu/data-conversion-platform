package com.yousu.dataconverterplateform.module.slave.controller;

import com.yousu.dataconverterplateform.common.util.PageUtil;
import com.yousu.dataconverterplateform.common.util.ResultUtil;
import com.yousu.dataconverterplateform.common.vo.PageVo;
import com.yousu.dataconverterplateform.common.vo.Result;
import com.yousu.dataconverterplateform.common.vo.SearchVo;
import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import com.yousu.dataconverterplateform.module.slave.service.BaseService;
import com.yousu.dataconverterplateform.module.slave.service.InterfaceInformationService;
import com.yousu.dataconverterplateform.module.task.CronTaskRegistrar;
import com.yousu.dataconverterplateform.module.task.SchedulingRunnable;
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
    private CronTaskRegistrar cronTaskRegistrar;
    private BaseService baseService;


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
        if (information != null){
            if (information.getWhetherOpen() == 1){
                //SchedulingRunnable task = new SchedulingRunnable(information);
                cronTaskRegistrar.addCronTask(information);
            }
        }
        return new ResultUtil<InterfaceInformation>().setData(information);
    }

    /**
     * 修改定时任务，先移除原来的任务，再启动新任务
     * @param interfaceInformation
     * @return
     */
    @PostMapping("/update")
    public Result<InterfaceInformation> update(@RequestBody InterfaceInformation interfaceInformation){
        InterfaceInformation information =  interfaceInformationService.update(interfaceInformation);
        if (information !=null){
            cronTaskRegistrar.removeCronTask(interfaceInformation.getId());
            if(information.getWhetherOpen() == 1){
                SchedulingRunnable task =
                        new SchedulingRunnable(information);
                cronTaskRegistrar.addCronTask(information);
            }
        }
        return new ResultUtil<InterfaceInformation>().setData(information);
    }

    @GetMapping("/deleteById")
    public Result<Object> deleteById(@RequestParam("id") String id){
        interfaceInformationService.delete(id);
        cronTaskRegistrar.removeCronTask(id);
        return new ResultUtil<Object>().setSuccessMsg("删除成功");
    }

    @PostMapping("/startOrStop")
    public Result<Object> startOrStop(@RequestBody InterfaceInformation interfaceInformation){
        if (interfaceInformation.getWhetherOpen() == 1){
            //SchedulingRunnable task = new SchedulingRunnable(interfaceInformation);
            cronTaskRegistrar.addCronTask(interfaceInformation);
        }else {
            cronTaskRegistrar.removeCronTask(interfaceInformation.getId());
        }
        return new ResultUtil<Object>().setSuccessMsg("设置成功。");
    }


    @PostMapping("/startTask")
    public Result<Object> startTask(@RequestBody InterfaceInformation interfaceInformation){
        baseService.executeSql(interfaceInformation);
        return new ResultUtil<Object>().setSuccessMsg("开启任务成功");
    }


}
