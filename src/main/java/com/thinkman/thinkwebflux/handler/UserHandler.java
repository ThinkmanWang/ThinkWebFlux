package com.thinkman.thinkwebflux.handler;

import com.thinkman.thinkwebflux.entity.User;
import com.thinkman.thinkwebflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UserHandler {

    @Autowired
    UserRepository userRepository;

    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        try {
            Mono<User> user = userRepository.login("thinkman", "123456");
            return ServerResponse.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(Mono.just("SUCCESS!!!"), String.class);
        } catch (Exception ex) {
            return ServerResponse.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(Mono.just("FAILED"), String.class);

        }
    }
}
