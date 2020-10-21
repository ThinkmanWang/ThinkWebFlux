package com.thinkman.thinkwebflux.routes;

import com.thinkman.thinkwebflux.handler.TimeHandler;
import com.thinkman.thinkwebflux.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRoute {
    @Autowired
    private TimeHandler timeHandler;

    @Autowired
    private UserHandler userHandler;

    @Bean
    RouterFunction<ServerResponse> login() {
        return route(GET("/user/login"), userHandler::login);
    }

}
