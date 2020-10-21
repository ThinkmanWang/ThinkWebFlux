package com.thinkman.thinkwebflux.config;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DatabaseClient;

import java.time.Duration;

@Configuration
public class DBConfig {
    @Bean(name = "newDatabaseClient")
    public DatabaseClient databaseClient(@Qualifier("newConnectionPool") ConnectionPool connectionFactory) {
        return DatabaseClient.create(connectionFactory);
    }

    @Bean(name = "newConnectionPool")
    public ConnectionPool connectionPool() {

        MySqlConnectionConfiguration configuration = MySqlConnectionConfiguration.builder()
                .host("127.0.0.1")
                .port(3306)
                .database("db_thinkman")
                .username("root")
                .password("Ab123145")
                .build();

        ConnectionPoolConfiguration poolConfiguration = ConnectionPoolConfiguration.builder()
                .connectionFactory(MySqlConnectionFactory.from(configuration))
                .maxSize(30)
                .maxIdleTime(Duration.ofSeconds(300))
                .maxLifeTime(Duration.ofSeconds(1800))
                .build();

        return new ConnectionPool(poolConfiguration);
    }
}
