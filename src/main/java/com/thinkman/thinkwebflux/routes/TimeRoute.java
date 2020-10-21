package com.thinkman.thinkwebflux.routes;

import com.thinkman.thinkwebflux.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class TimeRoute {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    RouterFunction<ServerResponse> date() {
        return route(GET("/date"), timeHandler::getDate);
    }

    @Bean
    RouterFunction<ServerResponse> time() {
        return route(GET("/time"), timeHandler::getTime);
    }
}
