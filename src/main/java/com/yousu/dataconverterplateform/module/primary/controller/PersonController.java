package com.yousu.dataconverterplateform.module.primary.controller;

import com.yousu.dataconverterplateform.common.util.ResultUtil;
import com.yousu.dataconverterplateform.common.vo.Result;
import com.yousu.dataconverterplateform.module.primary.entity.Person;
import com.yousu.dataconverterplateform.module.primary.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/system/origin/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping
    public Result<List<Person>> findAllData(){
        List<Person> peopleList = personService.findAllData();
        return new ResultUtil<List<Person>>().setData(peopleList);
    }
}
