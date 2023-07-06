package com.steamgames.steamgames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GameRecord(
        @JsonProperty("appid") int appId,
        @JsonProperty("name") String name,
        @JsonProperty("playtime_forever") int playtimeForever,
        @JsonProperty("img_icon_url") String imgIconUrl,
        @JsonProperty("has_community_visible_stats") boolean hasCommunityVisibleStats,
        @JsonProperty("playtime_windows_forever") int playtimeWindowsForever,
        @JsonProperty("playtime_mac_forever") int playtimeMacForever,
        @JsonProperty("playtime_linux_forever") int playtimeLinuxForever,
        @JsonProperty("rtime_last_played") int rtimeLastPlayed,
        @JsonProperty("playtime_disconnected") int playtimeDisconnected,
        @JsonProperty("content_descriptorids") int[] contentDescriptorIds
) {
}
