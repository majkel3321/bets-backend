package com.lewicki.betsbackend.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class LiveOddsConfig {

    @Value("${odds.live.key}")
    private String liveOddsKey;

    @Value("${odds.live.endpoint}")
    private String liveOddsEndpoint;
}
