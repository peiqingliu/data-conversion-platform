package com.yousu.dataconverterplateform.module.primary.handler;

import com.yousu.dataconverterplateform.module.primary.entity.Person;
import com.yousu.dataconverterplateform.module.primary.repository.PersonRepository;
import com.yousu.dataconverterplateform.module.slave.entity.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author Liupeiqing
 * @Date 2020/3/9 22:33
 * @Version 1.0
 */
@Slf4j
@Component
public class PersonHandler {

    @Autowired
    private PersonRepository personRepository;

    public Mono<ServerResponse> getUserById(ServerRequest serverRequest){
        log.info("获取单个用户");
        return ServerResponse.status(HttpStatus.OK)
                .body(Mono.justOrEmpty(personRepository.findById(serverRequest.pathVariable("userId"))), Person.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest){
        Flux<Person> userFlux = Flux.fromIterable(personRepository.findAll());
        return ServerResponse.status(HttpStatus.OK).body(userFlux,Person.class);
    }
}
