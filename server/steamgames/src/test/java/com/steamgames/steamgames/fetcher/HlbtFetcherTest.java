package com.steamgames.steamgames.fetcher;

import com.steamgames.steamgames.model.hlbt.HlbtResponseRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class HlbtFetcherTest {

    private final HlbtFetcher hlbtFetcher = new HlbtFetcher();

    @Test
    @Order(1)
    public void testFetchHlbtData() {
        Mono<HlbtResponseRecord> responseMono = hlbtFetcher.fetchHlbtData("Stellaris");

        HlbtResponseRecord response = responseMono.block();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.pageTotal());
        Assertions.assertEquals("Stellaris", response.data().get(0).game_name());
    }

    @Test
    @Order(2)
    public void testFetchHlbtData2() {
        Mono<HlbtResponseRecord> responseMono = hlbtFetcher.fetchHlbtData("Cyberpunk 2077");

        HlbtResponseRecord response = responseMono.block();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.pageTotal());
        Assertions.assertEquals("Cyberpunk 2077", response.data().get(0).game_name());
    }
}
