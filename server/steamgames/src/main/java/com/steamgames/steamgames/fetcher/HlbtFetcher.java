package com.steamgames.steamgames.fetcher;

import com.steamgames.steamgames.model.HlbtResponseRecord;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.BodyInserters;

public class HlbtFetcher {
    public HlbtResponseRecord fetchHlbtData(String searchTerm) {
        String baseUrl = "https://howlongtobeat.com/api/search";

        WebClient webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.REFERER, "https://howlongtobeat.com/")
                .build();

        HlbtRequestPayload payload = new HlbtRequestPayload();
        payload.setSearchType("games");
        payload.setSearchTerms(new String[]{searchTerm});
        payload.setSearchPage(1);
        payload.setSize(1);

        HlbtResponseRecord response = webClient.post()
                .uri(baseUrl)
                .body(BodyInserters.fromValue(payload))
                .retrieve()
                .bodyToMono(HlbtResponseRecord.class)
                .block();

        System.out.println(response);
        return response;
    }
}
