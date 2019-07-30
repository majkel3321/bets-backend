package com.lewicki.betsbackend.client;

import com.lewicki.betsbackend.configuration.LiveOddsConfig;
import com.lewicki.betsbackend.domain.odds.Odd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class LiveOddsClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LiveOddsConfig liveOddsConfig;

    public Odd downloadMatches(String leagueName) {

        String url = liveOddsConfig.getLiveOddsEndpoint();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("sport", leagueName)
                .queryParam("region", "uk")
                .queryParam("mkt", "h2h")
                .queryParam("apiKey", liveOddsConfig.getLiveOddsKey());

        Odd odd = restTemplate.getForObject(builder.toUriString(), Odd.class);
        return odd;
    }
}
