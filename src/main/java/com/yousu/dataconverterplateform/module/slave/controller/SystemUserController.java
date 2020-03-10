package com.yousu.dataconverterplateform.module.slave.controller;

import com.yousu.dataconverterplateform.module.primary.handler.PersonHandler;
import com.yousu.dataconverterplateform.module.slave.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @Author Liupeiqing
 * @Date 2020/3/9 22:04
 * @Version 1.0
 */
@Configuration
public class SystemUserController {

    @Autowired
    private UserHandler userHandler;

    @Autowired
    private PersonHandler personHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return route(GET("/system/user/{userId}"), userHandler::getUserById)
                .andRoute(GET("/system/users"),userHandler::getAll)
                .andRoute(GET("/system/person/{userId}"),personHandler :: getUserById)
                .andRoute(GET("/system/person/findAll"),personHandler::getAll);
    }
}
