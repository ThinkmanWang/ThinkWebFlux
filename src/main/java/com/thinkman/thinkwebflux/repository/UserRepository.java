package com.thinkman.thinkwebflux.repository;

import com.thinkman.thinkwebflux.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository {

    @Autowired
    @Qualifier("newDatabaseClient")
    DatabaseClient databaseClient;

    public Mono<User> login(String szName, String szPwd) {
        return databaseClient.execute("SELECT * FROM t_user WHERE `name` = :name AND password = :password")
                .bind("name", szName)
                .bind("password", szPwd)
                .map((row, rowData) -> new User(
                        row.get("id", Long.class)
                        , row.get("name", String.class)
                        , row.get("password", String.class)
                )).first()
                .switchIfEmpty(Mono.error(new RuntimeException("User not found!")));
    }

}
