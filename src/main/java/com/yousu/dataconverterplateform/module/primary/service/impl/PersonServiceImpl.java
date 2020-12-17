package com.yousu.dataconverterplateform.module.primary.service.impl;

import com.yousu.dataconverterplateform.module.primary.entity.Person;
import com.yousu.dataconverterplateform.module.primary.repository.PersonRepository;
import com.yousu.dataconverterplateform.module.primary.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAllData() {
        return personRepository.findAll();
    }
}
