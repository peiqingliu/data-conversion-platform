package com.yousu.dataconverterplateform.module.slave.repository;

import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import com.yousu.dataconverterplateform.module.slave.entity.OriginPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author peiqing Liu
 * @Date 2020/4/7 20:00
 * @Version 1.0
 */
public interface OriginPersonRepository extends JpaRepository<OriginPerson, String>, JpaSpecificationExecutor<InterfaceInformation> {



    @Query(value = "select id from t_origin_person WHERE 1=1 and  id_no = ?1 ",nativeQuery = true)
    String findIdByIdNo(String IdNo);

}
