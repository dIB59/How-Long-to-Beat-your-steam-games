package com.steamgames.steamgames.fetcher;

import com.steamgames.steamgames.model.SteamUserData;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SteamUserFetcher {

    private static String API_KEY;
    private final RestTemplate restTemplate;

    @Autowired
    public SteamUserFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        Dotenv dotenv = Dotenv.load();
        API_KEY = dotenv.get("STEAM_API_KEY");
    }

    public SteamUserData fetchSteamUserData(long steamId) {
        String url = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?steamid="
                + steamId + "&format=json&key=" + API_KEY
                + "&include_appinfo=true&include_played_free_games=true";

        return restTemplate.getForObject(url, SteamUserData.class);
    }

    public static String getApiKey() {
        return API_KEY;
    }

}
