package com.steamgames.steamgames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SteamUserData(@JsonProperty("games_count") int GamesCount) {
}
