package com.lewicki.betsbackend.client;

import com.lewicki.betsbackend.domain.odds.Odd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class LiveOddsClient {

    @Autowired
    private RestTemplate restTemplate;

    public Odd downloadMatches() {

        String url = "https://api.the-odds-api.com/v3/odds";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("sport", "soccer_china_superleague")
                .queryParam("region", "uk")
                .queryParam("mkt", "h2h")
                .queryParam("apiKey", "5d379c40c098ec7b638b16c936fab782");

        Odd odd = restTemplate.getForObject(builder.toUriString(), Odd.class);
        return odd;
    }
}
