package com.yousu.dataconverterplateform.module.primary.controller;

import com.yousu.dataconverterplateform.module.primary.handler.PersonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @Author Liupeiqing
 * @Date 2020/3/9 22:35
 * @Version 1.0
 */
@Configuration
public class PersonRouter {

    @Autowired
    private PersonHandler personHandler;


}
