package com.yousu.dataconverterplateform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-02 20:22
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryOracle",
        transactionManagerRef = "transactionManagerOracle",
        basePackages = {"com.yousu.dataconverterplateform.module.oracle.**.repository"}
        ) //设置DAO接口层所在包位置
public class OracleConfig {

    @Autowired
    @Qualifier("oracleDataSource")
    private DataSource oracleDataSource;

    @Bean(name = "entityManagerOracle")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryOracle().getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryOracle")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryOracle() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.ORACLE);
        vendorAdapter.setShowSql(true);
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(oracleDataSource);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan("com.yousu.dataconverterplateform.module.oracle.**entity");
        return factoryBean;
    }

//    @Bean(name = "entityManagerFactoryOracle")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryOracle(EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(oracleDataSource)
//                //.properties(getVendorProperties())
//                .packages("com.yousu.dataconverterplateform.module.oracle.**entity")        //设置实体类所在包的位置
//                .persistenceUnit("oraclePersistenceUnit")
//                .build();
//    }
//
//    private Map getVendorProperties() {
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.ddl-auto",
//                env.getProperty("update"));
//        properties.put("hibernate.dialect",
//                "org.hibernate.dialect.PostgreSQLDialect");
//        properties.put("hibernate.physical_naming_strategy",
//                "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
//        properties.put("hibernate.implicit_naming_strategy",
//                "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
//        return properties;
//    }

    @Autowired
    private Environment env;

    @Bean(name = "transactionManagerOracle")
    PlatformTransactionManager transactionManagerOracle(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryOracle().getObject());
    }
}

