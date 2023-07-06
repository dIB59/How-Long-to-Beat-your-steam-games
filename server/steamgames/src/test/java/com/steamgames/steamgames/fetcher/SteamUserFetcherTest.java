package com.steamgames.steamgames.fetcher;

import com.steamgames.steamgames.model.SteamUserData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SteamUserFetcherTest {

    @Mock
    private RestTemplate restTemplate;

    private SteamUserFetcher steamUserFetcher;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        steamUserFetcher = new SteamUserFetcher(restTemplate);
    }

    @Test
    public void testFetchSteamUserData() {
        String hibSteamId = "your-hib-steam-id";
        String steamApiKey = "your-steam-api-key";
        String expectedUrl = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?steamid="
                + hibSteamId + "&format=json&key=" + steamApiKey
                + "&include_appinfo=true&include_played_free_games=true";
        SteamUserData mockUserData = new SteamUserData(); // Create a mock SteamUserData object

        when(restTemplate.getForObject(expectedUrl, SteamUserData.class)).thenReturn(mockUserData);

        SteamUserData result = steamUserFetcher.fetchSteamUserData(steamApiKey);

        assertEquals(mockUserData, result);
        verify(restTemplate, times(1)).getForObject(expectedUrl, SteamUserData.class);
    }

    @Test
    public void ValidApiKeyTest() {
        String expectedApiKey = SteamUserFetcher.getApiKey();
        System.out.println(expectedApiKey);
        assertNotNull(expectedApiKey);

    }

}
