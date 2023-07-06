package com.steamgames.steamgames.fetcher;

import com.steamgames.steamgames.model.GameRecord;
import com.steamgames.steamgames.model.ResponseRecord;
import com.steamgames.steamgames.model.SteamUserDataResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
public class SteamUserFetcherTest {


    List<GameRecord> games = Arrays.asList(
            new GameRecord(4000, "Garry's Mod", 22, "4a6f25cfa2426445d0d9d6e233408de4d371ce8b", true, 8, 0, 0, 1623356526, 157, null),
            new GameRecord(400, "Portal", 1, "cfa928ab4119dd137e50d728e8fe703e4e970aff", true, 0, 0, 0, 1511627981, 157, null),
            new GameRecord(17410, "Mirror's Edge", 231, "cfea4731163004b2e5117c3b42a798c48c483d8f", false, 0, 0, 0, 1511980592, 157, null)
    );

    @Mock
    private RestTemplate restTemplate;

    private SteamUserFetcher steamUserFetcher;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        steamUserFetcher = new SteamUserFetcher(restTemplate);
    }

    @Test
    public void MockedFetchSteamUserDataTest() {
        long hibSteamId = 76561198347296426L;
        String expectedUrl = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?steamid="
                + hibSteamId + "&format=json&key=" + SteamUserFetcher.getApiKey()
                + "&include_appinfo=true&include_played_free_games=true";
        SteamUserDataResponse mockUserData = new SteamUserDataResponse(new ResponseRecord(3, games));

        when(restTemplate.getForObject(expectedUrl, SteamUserDataResponse.class)).thenReturn(mockUserData);

        SteamUserDataResponse result = steamUserFetcher.fetchSteamUserData(hibSteamId);
        System.out.println(result);

        assertEquals(mockUserData, result);
        verify(restTemplate, times(1)).getForObject(expectedUrl, SteamUserDataResponse.class);
    }

    @Test
    public void ValidApiKeyTest() {
        String expectedApiKey = SteamUserFetcher.getApiKey();
        System.out.println(expectedApiKey);
        assertNotNull(expectedApiKey);

    }

    @Test
    public void fetchSteamUserDataTest() {
        long hibSteamId = 76561198347296426L;
        SteamUserDataResponse result = steamUserFetcher.fetchSteamUserData(hibSteamId);

        System.out.println(result);

        assertNotEquals(0, result.response().game_count());
        Assertions.assertNotNull(result.response().games());


    }

}
