package com.yousu.dataconverterplateform.module.primary.repository;

import com.yousu.dataconverterplateform.module.primary.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author Liupeiqing
 * @Date 2020/3/9 22:32
 * @Version 1.0
 */
public interface PersonRepository extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {
}
