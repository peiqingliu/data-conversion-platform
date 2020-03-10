package com.yousu.dataconverterplateform.module.slave.handler;

import com.yousu.dataconverterplateform.module.slave.entity.SystemUser;
import com.yousu.dataconverterplateform.module.slave.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

/**
 * @Author Liupeiqing
 * @Date 2020/3/9 21:24
 * @Version 1.0
 */
@Slf4j
@Component
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> getUserById(ServerRequest serverRequest){
        log.info("获取单个用户");
        return ServerResponse.status(HttpStatus.OK)
                .body(Mono.justOrEmpty(userRepository.findById(serverRequest.pathVariable("userId"))), SystemUser.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest){
        printlnThread("获取所有的数据");
        Flux<SystemUser> userFlux = Flux.fromIterable(userRepository.findAll());
        return ServerResponse.status(HttpStatus.OK).body(userFlux,SystemUser.class);
    }

    /**
     * 打印当前线程
     * @param object
     */
    private void printlnThread(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName + "]: " + object);
    }
}
