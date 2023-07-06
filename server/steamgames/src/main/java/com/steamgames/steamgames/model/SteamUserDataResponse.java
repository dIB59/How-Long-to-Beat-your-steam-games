package com.steamgames.steamgames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public record SteamUserDataResponse(
        ResponseRecord response
) {
}
