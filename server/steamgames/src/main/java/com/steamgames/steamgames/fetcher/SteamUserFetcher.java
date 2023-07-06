package com.steamgames.steamgames.fetcher;

import com.steamgames.steamgames.model.SteamUserDataResponse;
import com.steamgames.steamgames.model.usersummary.SteamUserSummaryDataResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class SteamUserFetcher {

    private final String API_KEY;

    @Autowired
    public SteamUserFetcher() {
        Dotenv dotenv = Dotenv.load();
        API_KEY = dotenv.get("STEAM_API_KEY");
    }

    public SteamUserDataResponse fetchSteamUserGamesData(long steamId) {
        String baseUrl = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("steamid", steamId)
                .queryParam("format", "json")
                .queryParam("key", API_KEY)
                .queryParam("include_appinfo", "true")
                .queryParam("include_played_free_games", "true");

        WebClient webClient = WebClient.create();

        SteamUserDataResponse responseBody = webClient.get()
                .uri(builder.toUriString())
                .retrieve()
                .bodyToMono(SteamUserDataResponse.class)
                .block();

        if (responseBody != null) {
            return responseBody;
        }
        System.out.println("Request failed or returned an empty response.");
        return null;
    }

    public SteamUserSummaryDataResponse fetchSteamUserSummaryData(long steamId) {
        String baseUrl = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("key", API_KEY)
                .queryParam("steamids", steamId);

        WebClient webClient = WebClient.create();

        SteamUserSummaryDataResponse responseBody = webClient.get()
                .uri(builder.toUriString())
                .retrieve()
                .bodyToMono(SteamUserSummaryDataResponse.class)
                .block();
        System.out.println(responseBody.response().players().get(0).personaname());
        if (responseBody != null) {
            return responseBody;
        }
        System.out.println("Request failed or returned an empty response.");
        return null;
    }
}
