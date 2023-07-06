package com.steamgames.steamgames.model;

import java.util.List;

public record ResponseRecord(
        int game_count,
        List<GameRecord> games

) {
}
