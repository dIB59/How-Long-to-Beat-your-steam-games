package com.steamgames.steamgames.model.usersummary;

import java.util.List;

public record SteamUserSummaryDataResponse(ResponseData response) {
    public record ResponseData(List<Player> players) {
        public record Player(
                String steamid,
                int communityvisibilitystate,
                int profilestate,
                String personaname,
                String profileurl,
                String avatar,
                String avatarmedium,
                String avatarfull,
                String avatarhash,
                int personastate,
                String primaryclanid,
                long timecreated,
                int personastateflags
        ) {}
    }
}