package com.steamgames.steamgames.fetcher;

import com.steamgames.steamgames.model.HlbtResponseRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HlbtFetcherTest {

    @Test
    public void testFetchHlbtData() {
        HlbtFetcher hlbtFetcher = new HlbtFetcher();
        HlbtResponseRecord response = hlbtFetcher.fetchHlbtData("Stellaris");

        Assertions.assertNotNull(response);
        System.out.println(response.data());

        Assertions.assertEquals(1, response.pageTotal());
        Assertions.assertEquals("Stellaris", response.data().get(0).game_name());
    }
}

