package com.lewicki.betsbackend.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lewicki.betsbackend.domain.odds.Odd;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LiveOddsClient {

    public static void main(String[] args) throws IOException {
       /* URL url = new URL("https://api.the-odds-api.com/v3/odds?sport=soccer_china_superleague&region=uk&mkt=h2h&apiKey=5d379c40c098ec7b638b16c936fab782");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();
        System.out.println(jsonObject.get("data").toString());*/

        URL url = new URL("https://api.the-odds-api.com/v3/odds?sport=soccer_china_superleague&region=uk&mkt=h2h&apiKey=5d379c40c098ec7b638b16c936fab782");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Odd odd = new Gson().fromJson(reader,Odd.class);
        System.out.println(odd.getData().get(0).getTeams().toString());
    }
}
