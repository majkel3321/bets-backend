package com.lewicki.betsbackend.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApiFootballConfig {

    @Value("${football.api.key}")
    private String apiFootballKey;

    @Value("${football.api.endpoint}")
    private String apiFootballEndpoint;
}
