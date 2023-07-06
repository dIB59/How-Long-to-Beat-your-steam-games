package com.steamgames.steamgames.fetcher;

import com.steamgames.steamgames.model.SteamUserDataResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class SteamUserFetcher {

    private static String API_KEY;
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/";

    @Autowired
    public SteamUserFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        Dotenv dotenv = Dotenv.load();
        API_KEY = dotenv.get("STEAM_API_KEY");
    }

    public SteamUserDataResponse fetchSteamUserData(long steamId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("steamid", steamId)
                .queryParam("format", "json")
                .queryParam("key", API_KEY)
                .queryParam("include_appinfo", "true")
                .queryParam("include_played_free_games", "true");

        System.out.println(builder.toUriString());
        WebClient webClient = WebClient.create();


        String res = webClient.get()
                .uri(builder.toUriString())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(res);

        SteamUserDataResponse responseBody = webClient.get()
                .uri(builder.toUriString())
                .retrieve()
                .bodyToMono(SteamUserDataResponse.class)
                .block();

        // Process the response
        if (responseBody != null) {
            System.out.println(responseBody);
            return responseBody;
        } else {
            System.out.println("Request failed or returned an empty response.");
        }
       return null;
    }

    public static String getApiKey() {
        return API_KEY;
    }

}
