package com.steamgames.steamgames.fetcher;

import com.steamgames.steamgames.model.hlbt.HlbtResponseRecord;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.BodyInserters;

import reactor.core.publisher.Mono;

@Component
public class HlbtFetcher {
    public Mono<HlbtResponseRecord> fetchHlbtData(String searchTerm) {
        String baseUrl = "https://howlongtobeat.com/api/search";

        WebClient webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.REFERER, "https://howlongtobeat.com/")
                .build();

        HlbtRequestPayload payload = new HlbtRequestPayload();
        payload.setSearchType("games");
        payload.setSearchTerms(new String[]{searchTerm});
        payload.setSearchPage(1);
        payload.setSize(10);

        return webClient.post()
                .uri(baseUrl)
                .body(BodyInserters.fromValue(payload))
                .retrieve()
                .bodyToMono(HlbtResponseRecord.class);
    }
}
